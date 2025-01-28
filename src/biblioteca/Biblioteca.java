package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import dados.Dados.*;
public class Biblioteca {
  
    static Scanner scanner = new Scanner(System.in);
    static int contadorUsuario = 0;
    static String tipoUsuario = "";
    static int posicaoUsuario = -1;
    static int contadorEmprestimo = 0; // Inicializa o contador de empréstimos
    static int contadorLivros = 0; // Contador de livros para IDs
    
    
    public static void main(String[] args) {
        criarLivros(); // Cria 30 livros ao iniciar
        criarAdministradorPadrao(); // Cria um administrador padrão
        criarUsuarios(); // Cria 10 usuários
        criarBibliotecarios(); // Cria 2 bibliotecários
        while (true) {
            login();
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
                    emprestimo(posicaoUsuario, idLivro);
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
                    visualizarLivrosDisponiveis();
                    break;
                case 5:
                    System.out.println("Digite o ID do livro que deseja consultar:");
                    int idConsulta = scanner.nextInt();
                    consultarDetalhesLivro(idConsulta);
                    break;
                case 6:
                    return; // Volta para o menu inicial
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    static void menuBibliotecario() {
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
                    adicionarLivro();
                    break;
                case 2:
                    System.out.println("Digite o ID do livro que deseja remover:");
                    int idLivro = scanner.nextInt();
                    removerLivro(idLivro);
                    break;
                case 3:
                    visualizarLivros();
                    break;
                case 4:
                    System.out.println("Digite o ID do usuário:");
                    int idUsuario = scanner.nextInt();
                    visualizarHistoricoEmprestimos(idUsuario);
                    break;
                case 5:
                    System.out.println("Digite o novo nome:");
                    String novoNome = scanner.nextLine();
                    System.out.println("Digite o novo email:");
                    String novoEmail = scanner.nextLine();
                    System.out.println("Digite a nova senha:");
                    String novaSenha = scanner.nextLine();
                    dados.Dados.getBibliotecarios().get(posicaoUsuario).editarDados(novoNome, novoEmail, novaSenha);
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
                    dados.Dados.getAdministradores().get(posicaoUsuario).adicionarBibliotecario(cpf, nome, email, senha);
                    break;
                case 2:
                    System.out.println("Digite a posição do usuário que deseja remover:");
                    int posicaoUsuarioRemover = scanner.nextInt();
                    dados.Dados.getAdministradores().get(posicaoUsuario).removerUsuario(posicaoUsuarioRemover);
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

    static void emprestimo(int posicaoUsuario, int idLivro) {
        if (idLivro < 0 || idLivro >= dados.Dados.getLivros().size()) {
            System.out.println("ID de livro inválido.");
            return;
        }
        
        Livro livro = dados.Dados.getLivros().get(idLivro); // Supondo que 'livros' é uma lista de objetos Livro
        if (livro.isDisponivel()) {
            Emprestimo novoEmprestimo = new Emprestimo(
                ++Biblioteca.contadorEmprestimo, // Incrementa e usa o contador
                dados.Dados.getUsuarios().get(posicaoUsuario), // Passa o objeto Usuario
                livro // Passa o objeto Livro
            );
            livro.setDisponivel(false); // Marca o livro como não disponível
            dados.Dados.getUsuarios().get(posicaoUsuario).registrarEmprestimo(novoEmprestimo);
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Livro não disponível.");
        }
    }

    static void visualizarHistoricoEmprestimos(int idUsuario) {
        if (idUsuario < 0 || idUsuario >= dados.Dados.getUsuarios().size()) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        dados.Dados.getUsuarios().get(idUsuario).visualizarHistorico();
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


static void criarLivros() {
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Dom Casmurro", "Machado de Assis", "Romance", "Um dos clássicos da literatura brasileira.", "1899", "Editora A"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Alquimista", "Paulo Coelho", "Ficção", "Uma fábula sobre seguir seus sonhos.", "1988", "Editora B"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "1984", "George Orwell", "Ficção Científica", "Uma distopia sobre um governo totalitário.", "1949", "Editora C"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Moreninha", "Joaquim Manuel de Macedo", "Romance", "Uma história de amor e amizade.", "1844", "Editora D"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Ficção", "Uma história poética sobre a infância e a amizade.", "1943", "Editora E"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Cem Anos de Solidão", "Gabriel García Márquez", "Realismo Mágico", "A história da família Buendía.", "1967", "Editora F"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Revolução dos Bichos", "George Orwell", "Ficção", "Uma sátira sobre a política.", "1945", "Editora G"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "Uma épica jornada pela Terra Média.", "1954", "Editora H"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Cabana", "William P. Young", "Ficção", "Um encontro com Deus em uma cabana isolada.", "2007", "Editora I"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia", "A primeira aventura do jovem bruxo Harry Potter.", "1997", "Editora J"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Morro dos Ventos Uivantes", "Emily Brontë", "Romance", "Uma história de amor e vingança.", "1847", "Editora K"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Orgulho e Preconceito", "Jane Austen", "Romance", "Uma crítica social através de uma história de amor.", "1813", "Editora L"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Moby Dick", "Herman Melville", "Aventura", "A obsessão de um capitão por uma baleia.", "1851", "Editora M"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Grande Gatsby", "F. Scott Fitzgerald", "Ficção", "Uma crítica à sociedade americana dos anos 1920.", "1925", "Editora N"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Metamorfose", "Franz Kafka", "Ficção", "A transformação de um homem em inseto.", "1915", "Editora O"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Apanhador no Campo de Centeio", "J.D. Salinger", "Ficção", "A história de um jovem em busca de identidade.", "1951", "Editora P"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Fahrenheit 451", "Ray Bradbury", "Ficção Científica", "Uma sociedade onde os livros são queimados.", "1953", "Editora Q"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Sol é Para Todos", "Harper Lee", "Ficção", "Uma reflexão sobre justiça e moralidade.", "1960", "Editora R"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Estrangeiro", "Albert Camus", "Ficção", "A busca de sentido em um mundo absurdo.", "1942", "Editora S"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Menina que Roubava Livros", "Markus Zusak", "Ficção", "Uma história sobre o poder das palavras.", "2005", "Editora T"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Senhor das Moscas", "William Golding", "Ficção", "Um grupo de meninos em uma ilha deserta.", "1954", "Editora U"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Código Da Vinci", "Dan Brown", "Ficção", "Um thriller que mistura arte e religião.", "2003", "Editora V"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Garota no Trem", "Paula Hawkins", "Ficção", "Um mistério psicológico sobre um desaparecimento.", "2015", "Editora W"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Sutil Arte de Ligar o F*da-se", "Mark Manson", "Autoajuda", "Um guia sobre como viver uma vida significativa.", "2016", "Editora X"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Homem Mais Rico da Babilônia", "George S. Clason", "Autoajuda", "Lições sobre finanças e riqueza.", "1926", "Editora Y"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Como Fazer Amigos e Influenciar Pessoas", "Dale Carnegie", "Autoajuda", "Dicas sobre relacionamentos e influência.", "1936", "Editora Z"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Poder do Hábito", "Charles Duhigg", "Autoajuda", "Como os hábitos moldam nossas vidas.", "2012", "Editora AA"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Milagre da Manhã", "Hal Elrod", "Autoajuda", "Um guia para transformar suas manhãs e sua vida.", "2012", "Editora AB"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Arte da Guerra", "Sun Tzu", "Estratégia", "Um tratado sobre estratégia militar e liderança.", "5 a.C.", "Editora AC"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Livro dos Espíritos", "Allan Kardec", "Espiritualidade", "Fundamentos do Espiritismo.", "1857", "Editora AD"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Ciência e a Religião", "Albert Einstein", "Filosofia", "Reflexões sobre ciência e espiritualidade.", "1930", "Editora AE"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Ficção", "Uma história poética sobre a infância e a amizade.", "1943", "Editora AF"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Revolução dos Bichos", "George Orwell", "Ficção", "Uma sátira sobre a política.", "1945", "Editora AG"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Metamorfose", "Franz Kafka", "Ficção", "A transformação de um homem em inseto.", "1915", "Editora AH"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Morro dos Ventos Uivantes", "Emily Brontë", "Romance", "Uma história de amor e vingança.", "1847", "Editora AI"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Grande Gatsby", "F. Scott Fitzgerald", "Ficção", "Uma crítica à sociedade americana dos anos 1920.", "1925", "Editora AJ"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Cem Anos de Solidão", "Gabriel García Márquez", "Realismo Mágico", "A história da família Buendía.", "1967", "Editora AK"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Orgulho e Preconceito", "Jane Austen", "Romance", "Uma crítica social através de uma história de amor.", "1813", "Editora AL"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Moby Dick", "Herman Melville", "Aventura", "A obsessão de um capitão por uma baleia.", "1851", "Editora AM"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Alquimista", "Paulo Coelho", "Ficção", "Uma fábula sobre seguir seus sonhos.", "1988", "Editora AN"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Menina que Roubava Livros", "Markus Zusak", "Ficção", "Uma história sobre o poder das palavras.", "2005", "Editora AO"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "Uma épica jornada pela Terra Média.", "1954", "Editora AP"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Estrangeiro", "Albert Camus", "Ficção", "A busca de sentido em um mundo absurdo.", "1942", "Editora AQ"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Cabana", "William P. Young", "Ficção", "Um encontro com Deus em uma cabana isolada.", "2007", "Editora AR"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Código Da Vinci", "Dan Brown", "Ficção", "Um thriller que mistura arte e religião.", "2003", "Editora AS"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Fahrenheit 451", "Ray Bradbury", "Ficção Científica", "Uma sociedade onde os livros são queimados.", "1953", "Editora AT"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Sutil Arte de Ligar o F*da-se", "Mark Manson", "Autoajuda", "Um guia sobre como viver uma vida significativa.", "2016", "Editora AU"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Homem Mais Rico da Babilônia", "George S. Clason", "Autoajuda", "Lições sobre finanças e riqueza.", "1926", "Editora AV"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "Como Fazer Amigos e Influenciar Pessoas", "Dale Carnegie", "Autoajuda", "Dicas sobre relacionamentos e influência.", "1936", "Editora AW"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Poder do Hábito", "Charles Duhigg", "Autoajuda", "Como os hábitos moldam nossas vidas.", "2012", "Editora AX"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "O Milagre da Manhã", "Hal Elrod", "Autoajuda", "Um guia para transformar suas manhãs e sua vida.", "2012", "Editora AY"));
    dados.Dados.getLivros().add(new Livro(++contadorLivros, "A Arte da Guerra", "Sun Tzu", "Estratégia", "Um tratado sobre estratégia militar e liderança.", "5 a.C.", "Editora AZ"));
}



    static void criarAdministradorPadrao() {
        if (dados.Dados.getAdministradores().isEmpty()) {
            // Cria um administrador padrão
            Administrador adminPadrao = new Administrador("ADM001", ++contadorUsuario, "000.000.000-00", "Admin Padrão", "admin@biblioteca.com", "senhaAdmin");
            dados.Dados.getAdministradores().add(adminPadrao);
        }
    }

    static boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) return false;

        // Verifica se todos os dígitos são iguais
        if (cpf.chars().distinct().count() == 1) return false;

        int soma = 0, peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0 : digito1;

        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0 : digito2;

        return (digito1 == Character.getNumericValue(cpf.charAt(9))) && (digito2 == Character.getNumericValue(cpf.charAt(10)));
    }

    static void consultarDetalhesLivro(int id) {
        for (Livro livro : dados.Dados.getLivros()) {
            if (livro.getIdLivro() == id) {
                System.out.println("===== DETALHES DO LIVRO =====");
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Gênero: " + livro.getGenero());
                System.out.println("Descrição: " + livro.getDescricao());
                System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
                System.out.println("Editora: " + livro.getEditora());
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    // Método para visualizar livros disponíveis
    static void visualizarLivrosDisponiveis() {
        System.out.println("===== LIVROS DISPONÍVEIS =====");
        for (Livro livro : dados.Dados.getLivros()) {
            if (livro.isDisponivel()) { 
                System.out.println("ID: " + livro.getIdLivro() + " - Título: " + livro.getTitulo());
            }
        }
    }

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

    // Método para gerar um novo ID de usuário
    static int gerarNovoIdUsuario() {
        return ++contadorUsuario; // Incrementa o contador de usuários
    }
}