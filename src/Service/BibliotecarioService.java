package Service;

import Model.AdministradorModel;
import Model.BibliotecarioModel;
import Model.LivroModel;
import Model.UsuarioModel;
import Dados.Dados;
import java.util.Scanner;

public class BibliotecarioService {
    private static final Scanner scanner = new Scanner(System.in);
  /* vai vira função de banco
    public static void removerLivro(String idLivro) {
        LivroModel livroRemovido = null;
        for (LivroModel livro : Dados.getLivros()) {
            if (livro.getIdLivro().equals(idLivro)) { // Usar equals para comparação de strings
                livroRemovido = livro;
                break;
            }
        }
        if (livroRemovido != null) {
            Dados.getLivros().remove(livroRemovido);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void visualizarLivros() {
        if (Dados.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("=== Lista de Livros ===");
            for (LivroModel livro : Dados.getLivros()) {
                livro.exibir(); // Certifique-se de que este método está implementado
                System.out.println();
            }
        }
    }

    public static void adicionarLivro() {
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

        // Gerar ID automaticamente
        String idLivro = "C" + String.format("%03d", Dados.getContadorLivros() + 1); // Ex: C001, C002, ...

        // Criação do novo livro
        LivroModel novoLivro = new LivroModel(idLivro, titulo, autor, genero, descricao, anoPublicacao, editora);
        Dados.adicionarLivro(novoLivro);

        System.out.println("Livro adicionado com sucesso: " + titulo);
    }

    public static void criarContaBibliotecario(UsuarioModel usuarioAtual) {
    if (!(usuarioAtual instanceof AdministradorModel)) {
        System.out.println("Apenas administradores podem adicionar bibliotecários.");
        return;
    }

    System.out.print("Código do Bibliotecário: ");
    String codigoBibliotecario = scanner.nextLine();
    System.out.print("CPF: ");
    String cpf = scanner.nextLine();
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
    System.out.print("Email: ");
    String email = scanner.nextLine();

    // Verifica se o e-mail já está cadastrado
    for (BibliotecarioModel bibliotecario : Dados.getBibliotecarios()) {
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

    // Incrementa o contador antes de criar o novo bibliotecário
    String novoId = String.valueOf(Dados.getContadorUsuario()); // Converte o ID para String
    Dados.setContadorUsuario(Dados.getContadorUsuario() + 1);

    // Cria o novo bibliotecário com todos os dados do construtor
    BibliotecarioModel novoBibliotecario = new BibliotecarioModel(
        codigoBibliotecario,
        novoId,
        cpf,
        nome,
        email,
        senha
    );

    Dados.getBibliotecarios().add(novoBibliotecario);

    System.out.println("Conta de bibliotecário criada com sucesso.");
}


    // Feche o scanner quando não for mais necessário
    public static void fecharScanner() {
        scanner.close();
    }
   */
}
