package Model;

import View.ZPrincipal;
import java.util.Scanner;
import Dados.Dados;

public class BibliotecaModel {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
         ZPrincipal telaPrincipal = new ZPrincipal();
         telaPrincipal.setVisible(true); // Torna a tela visível
    }

   

    private static void menuInicial() {
        while (true) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Login");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (opcao == 1) {
                realizarLogin();
            } else if (opcao == 2) {
                System.out.println("Saindo do sistema...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void realizarLogin() {
        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        UsuarioModel usuarioLogado = Dados.getUsuarios().stream()
            .filter(usuario -> usuario.getEmail().equals(email) && usuario.getSenha().equals(senha))
            .findFirst()
            .orElse(null);

        if (usuarioLogado != null) {
            System.out.println("Login realizado com sucesso!");
            menuUsuario(usuarioLogado);
        } else {
            System.out.println("Email ou senha inválidos.");
        }
    }

    private static void menuUsuario(UsuarioModel usuario) {
        while (true) {
            System.out.println("=== Menu do Usuário ===");
            System.out.println("1. Visualizar Dados");
            System.out.println("2. Visualizar Histórico de Empréstimos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    usuario.exibirDados();
                    break;
                case 2:
                    
                    break;
                case 3:
                    System.out.println("Saindo do menu do usuário...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}