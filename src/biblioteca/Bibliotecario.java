package biblioteca;

import java.util.Scanner;

public class Bibliotecario extends Usuario {
    private String codigoBibliotecario;
    public static int contadorEmprestimo = 0;

    public Bibliotecario(String codigoBibliotecario, int idUsuario, String cpf, String nome, String email, String senha) {
       super(idUsuario, cpf, nome, email, senha); // Agora passando a senha
       this.codigoBibliotecario = codigoBibliotecario;
   }

    public String getCodigoBibliotecario() {
        return codigoBibliotecario;
    }

    public void adicionarLivro(Scanner scanner) {
        Livro novoLivro = new Livro(scanner);
        Biblioteca.livros.add(novoLivro);
        System.out.println("Livro adicionado com sucesso: " + novoLivro.getTitulo());
    }

    public void removerLivro(int idLivro) {
        for (int i = 0; i < Biblioteca.livros.size(); i++) {
            if (Biblioteca.livros.get(i).getIdLivro() == idLivro) {
                Biblioteca.livros.remove(i);
                System.out.println("Livro removido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void visualizarLivros() {
        if (Biblioteca.livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("=== Lista de Livros ===");
            for (Livro livro : Biblioteca.livros) {
                livro.exibir();
                System.out.println();
            }
        }
    }

    public void registrarEmprestimo(int idUsuario, int idLivro) {
        if (idUsuario < 0 || idUsuario >= Biblioteca.usuarios.size()) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        Usuario usuario = Biblioteca.usuarios.get(idUsuario);
        Livro livro = Biblioteca.livros.stream()
                .filter(l -> l.getIdLivro() == idLivro && l.isDisponivel())
                .findFirst()
                .orElse(null);

        if (livro != null) {
            livro.setDisponivel(false);
            Emprestimo novoEmprestimo = new Emprestimo(++contadorEmprestimo, usuario, livro);
            usuario.registrarEmprestimo(novoEmprestimo);
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Livro não disponível ou não encontrado.");
        }
    }

    public void visualizarHistoricoEmprestimos(int idUsuario) {
        if (idUsuario < 0 || idUsuario >= Biblioteca.usuarios.size()) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.println("=== Histórico de Empréstimos do Usuário " + idUsuario + " ===");
        Biblioteca.usuarios.get(idUsuario).visualizarHistorico();
    }

    public void editarDados(String novoNome, String novoEmail, String novaSenha) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            this.nome = novoNome;
        }
        if (novoEmail != null && !novoEmail.trim().isEmpty()) {
            this.email = novoEmail;
        }
        if (novaSenha != null && !novaSenha.trim().isEmpty()) {
            this.senha = novaSenha;
        }
        System.out.println("Dados do bibliotecário atualizados com sucesso!");
    }

    public void exibirDados() {
        System.out.println("=== Dados do Bibliotecário ===");
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("Código do Bibliotecário: " + codigoBibliotecario);
    }
}
