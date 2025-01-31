package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import dados.Dados.*;
import sever.UsuarioSever.*;
public class Biblioteca {
  
    static Scanner scanner = new Scanner(System.in);
    
    
    
    public static void main(String[] args) {
        criarLivros(); // Cria 30 livros ao iniciar
        criarAdministradorPadrao(); // Cria um administrador padrão
        criarUsuarios(); // Cria 10 usuários
        criarBibliotecarios(); // Cria 2 bibliotecários
        while (true) {
            System.out.println(" o que deseja fazer 1 login 2 criar conta 3 sair  ");
            int escolha = scanner.nextInt();
            switch(escolha){
                case 1:
            sever.UsuarioSever.login();
            if(dados.Dados.getTipoUsuario().equals("usuario")){
                menuUsuario(dados.Dados.getPosicaoUsuario());
            }if(dados.Dados.getTipoUsuario().equals("bibliotecario")){
                menuBibliotecario();
            }if(dados.Dados.getTipoUsuario().equals("bibliotecario")){
                menuAdm();
            }
            break;
                case 2 :
                    sever.UsuarioSever.criarConta();
                    break;
                case 3:
                    System.out.println("até mais");
                    System.exit(0);
            }
        }
    }

   


    static void menuUsuario(int posicaoUsuario) {
        while (true) {
            System.out.println("===== MENU USUÁRIO =====");
            System.out.println("1. Visualizar Histórico");
            System.out.println("2. Solicitar Empréstimo");
            System.out.println("3. Editar Dados");
            System.out.println("4. Visualizar Livros Disponíveis");
            System.out.println("5. Consultar Detalhes do Livro");
            System.out.println("6. Voltar ao Menu Inicial");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (escolha) {
                case 1:
                    dados.Dados.getUsuarios().get(posicaoUsuario).visualizarHistorico();
                    break;
                case 2:
                    System.out.println("Digite o ID do livro que deseja emprestar:");
                    int idLivro = scanner.nextInt();
                    sever.Empretimosever.emprestimo(posicaoUsuario, idLivro);
                    break;
                case 3:
                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite o novo email:");
                    String novoEmail = scanner.nextLine();
                    System.out.println("Digite a nova senha:");
                    String novaSenha = scanner.nextLine();
                    dados.Dados.getUsuarios().get(posicaoUsuario).editarDados(novoNome, novoEmail, novaSenha);
                    break;
                case 4:
                    sever.LivroSever.visualizarLivrosDisponiveis();
                    break;
                case 5:
                    System.out.println("Digite o ID do livro que deseja consultar:");
                    int idConsulta = scanner.nextInt();
                    sever.LivroSever.consultarDetalhesLivro(idConsulta);
                    break;
                case 6:
                    return; // Volta para o menu inicial
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void menuBibliotecario() {
        while (true) {
            System.out.println("===== MENU BIBLIOTECÁRIO =====");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Remover Livro");
            System.out.println("3. Visualizar Livros");
            System.out.println("4. Visualizar Histórico de Empréstimos de um Usuário");
            System.out.println("5. Editar Dados");
            System.out.println("6. Voltar ao Menu Inicial");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (escolha) {
                case 1:
                    sever.BibliotecarioSever.adicionarLivro();
                    break;
                case 2:
                    System.out.println("Digite o ID do livro que deseja remover:");
                    int idLivro = scanner.nextInt();
                    sever.BibliotecarioSever.removerLivro(idLivro);
                    break;
                case 3:
                    sever.BibliotecarioSever.visualizarLivros();
                    break;
                case 4:
                    System.out.println("Digite o ID do usuário:");
                    int idUsuario = scanner.nextInt();
                    sever.UsuarioSever.visualizarHistoricoEmprestimos(idUsuario);
                    break;
                case 5:
                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite o novo email:");
                    String novoEmail = scanner.nextLine();
                    System.out.println("Digite a nova senha:");
                    String novaSenha = scanner.nextLine();
                    dados.Dados.getBibliotecarios().get(dados.Dados.getPosicaoUsuario()).editarDados(novoNome, novoEmail, novaSenha);
                    break;
                case 6:
                    return; // Volta para o menu inicial
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    static void menuAdm() {
        while (true) {
            System.out.println("===== MENU ADMINISTRADOR =====");
            System.out.println("1. Adicionar Bibliotecário");
            System.out.println("2. Remover Usuário");
            System.out.println("3. Visualizar Todos os Usuários");
            System.out.println("4. Voltar ao Menu Inicial");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (escolha) {
                case 1:
                    System.out.println("Digite o CPF do bibliotecário:");
                    String cpf = scanner.nextLine();
                    System.out.println("Digite o nome do bibliotecário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o email do bibliotecário:");
                    String email = scanner.nextLine();
                    System.out.println("Digite a senha do bibliotecário:");
                    String senha = scanner.nextLine();
                    dados.Dados.getAdministradores().get(dados.Dados.getPosicaoUsuario()).adicionarBibliotecario(cpf, nome, email, senha);
                    break;
                case 2:
                    System.out.println("Digite a posição do usuário que deseja remover:");
                    int posicaoUsuarioRemover = scanner.nextInt();
                    dados.Dados.getAdministradores().get(dados.Dados.getPosicaoUsuario()).removerUsuario(posicaoUsuarioRemover);
                    break;
                case 3:
                    for (Usuario usuario : dados.Dados.getUsuarios()) {
                        usuario.exibirDados();
                    }
                    break;
                case 4:
                    return; // Volta para o menu inicial
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }



static void criarLivros() {
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "Dom Casmurro", "Machado de Assis", "Romance", "Um dos clássicos da literatura brasileira.", "1899", "Editora A"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "O Alquimista", "Paulo Coelho", "Ficção", "Uma fábula sobre seguir seus sonhos.", "1988", "Editora B"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "1984", "George Orwell", "Ficção Científica", "Uma distopia sobre um governo totalitário.", "1949", "Editora C"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "A Moreninha", "Joaquim Manuel de Macedo", "Romance", "Uma história de amor e amizade.", "1844", "Editora D"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Ficção", "Uma história poética sobre a infância e a amizade.", "1943", "Editora E"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "Cem Anos de Solidão", "Gabriel García Márquez", "Realismo Mágico", "A história da família Buendía.", "1967", "Editora F"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "A Revolução dos Bichos", "George Orwell", "Ficção", "Uma sátira sobre a política.", "1945", "Editora G"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "Uma épica jornada pela Terra Média.", "1954", "Editora H"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "A Cabana", "William P. Young", "Ficção", "Um encontro com Deus em uma cabana isolada.", "2007", "Editora I"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia", "A primeira aventura do jovem bruxo Harry Potter.", "1997", "Editora J"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "O Morro dos Ventos Uivantes", "Emily Brontë", "Romance", "Uma história de amor e vingança.", "1847", "Editora K"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "Orgulho e Preconceito", "Jane Austen", "Romance", "Uma crítica social através de uma história de amor.", "1813", "Editora L"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "Moby Dick", "Herman Melville", "Aventura", "A obsessão de um capitão por uma baleia.", "1851", "Editora M"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "O Grande Gatsby", "F. Scott Fitzgerald", "Ficção", "Uma crítica à sociedade americana dos anos 1920.", "1925", "Editora N"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "A Metamorfose", "Franz Kafka", "Ficção", "A transformação de um homem em inseto.", "1915", "Editora O"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "O Apanhador no Campo de Centeio", "J.D. Salinger", "Ficção", "A história de um jovem em busca de identidade.", "1951", "Editora P"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "Fahrenheit 451", "Ray Bradbury", "Ficção Científica", "Uma sociedade onde os livros são queimados.", "1953", "Editora Q"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "O Sol é Para Todos", "Harper Lee", "Ficção", "Uma reflexão sobre justiça e moralidade.", "1960", "Editora R"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "O Estrangeiro", "Albert Camus", "Ficção", "A busca de sentido em um mundo absurdo.", "1942", "Editora S"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "A Menina que Roubava Livros", "Markus Zusak", "Ficção", "Uma história sobre o poder das palavras.", "2005", "Editora T"));
    dados.Dados.getLivros().add(new Livro(dados.Dados.getContadorLivros(), "A Arte da Guerra", "Sun Tzu", "Estratégia", "Um tratado sobre estratégia militar e liderança.", "5 a.C.", "Editora AZ"));
}





    static void criarAdministradorPadrao() {
        if (dados.Dados.getAdministradores().isEmpty()) {
            // Cria um administrador padrão
            Administrador adminPadrao = new Administrador("ADM001", dados.Dados.getContadorUsuario(), "000.000.000-00", "Admin Padrão", "admin@biblioteca.com", "senhaAdmin");
            dados.Dados.getAdministradores().add(adminPadrao);
        }
    }

   
    // Método para visualizar livros disponíveis
   

        static void criarUsuarios() {
            // Criar 10 usuários simples
            String[][] usuariosDados = {
                {"123.456.789-00", "Ana Silva", "ana.silva@gmail.com", "senhaAna"},
                {"234.567.890-01", "Bruno Costa", "bruno.costa@gmail.com", "senhaBruno"},
                {"345.678.901-02", "Carla Mendes", "carla.mendes@gmail.com", "senhaCarla"},
                {"456.789.012-03", "Daniel Oliveira", "daniel.oliveira@gmail.com", "senhaDaniel"},
                {"567.890.123-04", "Eduarda Lima", "eduarda.lima@gmail.com", "senhaEduarda"},
                {"678.901.234-05", "Felipe Santos", "felipe.santos@gmail.com", "senhaFelipe"},
                {"789.012.345-06", "Gabriela Rocha", "gabriela.rocha@gmail.com", "senhaGabriela"},
                {"890.123.456-07", "Henrique Alves", "henrique.alves@gmail.com", "senhaHenrique"},
                {"901.234.567-08", "Isabela Ferreira", "isabela.ferreira@gmail.com", "senhaIsabela"},
                {"012.345.678-09", "João Pedro", "joao.pedro@gmail.com", "senhaJoao"}
            };

            for (String[] dadosUsuario : usuariosDados) {
                Usuario usuario = new Usuario(dadosUsuario[0], dadosUsuario[1], dadosUsuario[2], dadosUsuario[3]);
                dados.Dados.getUsuarios().add(usuario);
            }
        }

        static void criarBibliotecarios() {
            // Criar 2 bibliotecários
            String[][] bibliotecariosDados = {
                {"111.222.333-44", "Maria Clara", "maria.clara@biblioteca.com", "senhaMaria", "1"},
                {"222.333.444-55", "José Carlos", "jose.carlos@biblioteca.com", "senhaJose", "2"}
            };

            for (String[] dadosBibliotecario : bibliotecariosDados) {
                int idUsuario = Integer.parseInt(dadosBibliotecario[4]); // Convertendo o ID para inteiro
                // Adicionando a senha ao construtor
                Bibliotecario bibliotecario = new Bibliotecario(dadosBibliotecario[0], idUsuario, dadosBibliotecario[1], dadosBibliotecario[2], dadosBibliotecario[3], dadosBibliotecario[4]);
                dados.Dados.getBibliotecarios().add(bibliotecario);
            }
        }
}
