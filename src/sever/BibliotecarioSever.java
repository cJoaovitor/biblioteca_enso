
package sever;

import biblioteca.Administrador;
import biblioteca.Bibliotecario;
import biblioteca.Livro;
import biblioteca.Usuario;
import java.util.Scanner;


public class BibliotecarioSever {
    static void removerLivro(int idLivro) {
        for (int i = 0; i < dados.Dados.getLivros().size(); i++) {
            if (dados.Dados.getLivros().get(i).getIdLivro() == idLivro) {
                dados.Dados.getLivros().remove(i);
                System.out.println("Livro removido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
  static void visualizarLivros() {
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
  
    static void adicionarLivro() {
      Scanner scanner = new Scanner(System.in);

      // Solicita os dados do livro
      System.out.print("Digite o título do livro: ");
      String titulo = scanner.nextLine();
      System.out.print("Digite o autor do livro: ");
      String autor = scanner.nextLine();
      System.out.print("Digite o gênero do livro: ");
      String genero = scanner.nextLine();
      System.out.print("Digite a descrição do livro: ");
      String descricao = scanner.nextLine();
      System.out.print("Digite o ano de publicação: ");
      String anoPublicacao = scanner.nextLine();
      System.out.print("Digite a editora: ");
      String editora = scanner.nextLine();

      // Cria o novo livro com ID gerado automaticamente
      Livro novoLivro = new Livro(++contadorLivros, titulo, autor, genero, descricao, anoPublicacao, editora);
      dados.Dados.getLivros().add(novoLivro);

     System.out.println("Livro adicionado com sucesso: " + titulo);
  }
    static void criarContaBibliotecario(Usuario usuarioAtual) {
        // Verifica se o usuário atual é um administrador
        if (!(usuarioAtual instanceof Administrador)) {
            System.out.println("Apenas administradores podem adicionar bibliotecários.");
            return;
        }

        System.out.print("Código do Bibliotecário: ");
        String codigoBibliotecario = scanner.nextLine(); // Adicionando o código do bibliotecário
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        // Verifica se o e-mail já está cadastrado
        for (Bibliotecario bibliotecario : dados.Dados.getBibliotecarios()) {
            if (bibliotecario.getEmail().equals(email)) {
                System.out.println("E-mail já cadastrado. Tente novamente.");
                return;
            }
        }

        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Confirme a sua senha: ");
        String confirmarSenha = scanner.nextLine();

        if (!senha.equals(confirmarSenha)) {
            System.out.println("As senhas não coincidem. Tente novamente.");
            return;
        }

        // Cria a conta do bibliotecário
        int idUsuario = ++contadorUsuario; // Lógica para gerar um novo ID de usuário
        Bibliotecario novoBibliotecario = new Bibliotecario(codigoBibliotecario, idUsuario, cpf, nome, email, senha);
        dados.Dados.getBibliotecarios().add(novoBibliotecario);

        System.out.println("Conta de bibliotecário criada com sucesso.");
    }

}
