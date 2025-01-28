package biblioteca;

import java.util.Scanner;
import dados.Dados.*;
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
        dados.Dados.getLivros().add(novoLivro);
        System.out.println("Livro adicionado com sucesso: " + novoLivro.getTitulo());
    }

    public void removerLivro(int idLivro) {
        for (int i = 0; i < dados.Dados.getLivros().size(); i++) {
            if (dados.Dados.getLivros().get(i).getIdLivro() == idLivro) {
                dados.Dados.getLivros().remove(i);
                System.out.println("Livro removido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void visualizarLivros() {
        if (dados.Dados.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("=== Lista de Livros ===");
            for (Livro livro : dados.Dados.getLivros()) {
                livro.exibir();
                System.out.println();
            }
        }
    }

    public void registrarEmprestimo(int idUsuario, int idLivro) {
        if (idUsuario < 0 || idUsuario >= dados.Dados.getUsuarios().size()) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        Usuario usuario = dados.Dados.getUsuarios().get(idUsuario);
        Livro livro = dados.Dados.getLivros().stream()
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
        if (idUsuario < 0 || idUsuario >= dados.Dados.getUsuarios().size()) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.println("=== Histórico de Empréstimos do Usuário " + idUsuario + " ===");
        dados.Dados.getUsuarios().get(idUsuario).visualizarHistorico();
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