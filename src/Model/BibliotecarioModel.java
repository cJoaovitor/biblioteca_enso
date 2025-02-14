package Model;

import Dados.Dados;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BibliotecarioModel extends UsuarioModel {
    private String codigoBibliotecario;
    public static int contadorEmprestimo = 0;

    public BibliotecarioModel(String codigoBibliotecario, String idUsuario, String cpf, String nome, String email, String senha) {
        super(idUsuario, cpf, nome, email, senha, "Rua Exemplo", "789", "", "Centro", "SP", "São Paulo", "00000-000");
        this.codigoBibliotecario = codigoBibliotecario;
    }

    public static String gerarCodigoBibliotecario() {
        Random random = new Random();
        int codigo = 1000 + random.nextInt(9000);
        return String.format("%04d", codigo);
    }

    public void adicionarLivro(Scanner scanner) {
        LivroModel novoLivro = new LivroModel(scanner);
        Dados.getLivros().add(novoLivro);
        System.out.println("Livro adicionado com sucesso: " + novoLivro.getTitulo());
    }

    public void removerLivro(String idLivro) {
        List<LivroModel> livros = Dados.getLivros(); // Obtém a lista de livros
        if (livros != null) {
            for (int i = 0; i < livros.size(); i++) {
                // Verifica se o ID do livro atual é igual ao ID do livro a ser removido
                if (livros.get(i).getIdLivro().equals(idLivro)) {
                    livros.remove(i); // Remove o livro
                    System.out.println("Livro removido com sucesso!");
                    return; // Sai do método após a remoção
                }
            }
        }
        System.out.println("Livro não encontrado.");
    }


    public void visualizarLivros() {
        if (Dados.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("=== Lista de Livros ===");
            for (LivroModel livro : Dados.getLivros()) {
                livro.exibir();
                System.out.println();
            }
        }
    }
    
    public void registrarEmprestimo(int idUsuario, String idLivro) {
        // Verifica se o ID do usuário é válido
        if (idUsuario < 0 || idUsuario >= Dados.getUsuarios().size()) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        UsuarioModel usuario = Dados.getUsuarios().get(idUsuario);
        // Filtra os livros para encontrar um livro disponível com o ID correspondente
        LivroModel livro = Dados.getLivros().stream()
                .filter(l -> l.getIdLivro().equals(idLivro) && l.isDisponivel())
                .findFirst()
                .orElse(null);

        // Verifica se o livro foi encontrado e se está disponível
        if (livro != null) {
            livro.setDisponivel(false); // Marca o livro como não disponível
            EmprestimoModel novoEmprestimo = new EmprestimoModel(Dados.getPosicaoUsuario(), Dados.getLivro(idUsuario)); // Usa o construtor correto
            usuario.registrarEmprestimo(novoEmprestimo); // Registra o empréstimo para o usuário
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Livro não disponível ou não encontrado.");
        }
    }



    public void visualizarHistoricoEmprestimos(int idUsuario) {
        if (idUsuario < 0 || idUsuario >= Dados.getUsuarios().size()) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.println("=== Histórico de Empréstimos do Usuário " + idUsuario + " ===");
        Dados.getUsuarios().get(idUsuario).visualizarHistorico();
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

    @Override
    public void exibirDados() {
        System.out.println("=== Dados do Bibliotecário ===");
        System.out.println("Código: " + codigoBibliotecario);
        super.exibirDados();
    }

    public Object getCodigoBibliotecario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

