package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();
    static ArrayList<Administrador> administradores = new ArrayList<>();
    static ArrayList<Livro> livros = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int contadorUsuario = 0;
    static String tipoUsuario = "";
    static int posicaoUsuario = -1;
    static int contadorEmprestimo = 0; // Inicializa o contador de empréstimos
    static int contadorLivros = 0; // Contador de livros para IDs
    int contadorUsuarios;
    
    public static void main(String[] args) {
        criarLivros(); // Cria 30 livros ao iniciar
        criarAdministradorPadrao(); // Cria um administrador padrão
        criarUsuarios(); // Cria 10 usuários
        criarBibliotecarios(); // Cria 2 bibliotecários
        while (true) {
            login();
        }
    }

    static boolean login() {
        if (usuarios.isEmpty() && bibliotecarios.isEmpty() && administradores.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado. Por favor, crie uma conta primeiro.");
            criarConta();
            return true; // Login automático após criar conta
        }

        System.out.println("Bem-vindo!");
        System.out.println("1. Login");
        System.out.println("2. Criar Conta");
        System.out.println("3. Encerrar Sistema");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        if (escolha == 3) {
            System.out.println("Sistema encerrado. Até logo!");
            System.exit(0); // Encerra o sistema
        }

        if (escolha == 2) {
            criarConta();
            return true; // Login automático após criar conta
        }

        System.out.println("Nível de conta: 1 para usuário, 2 para bibliotecário, 3 para adm");
        int nivelConta = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        String pesEmail;

        switch (nivelConta) {
            case 1:
                pesEmail = solicitarEmail(usuarios);
                if (pesEmail == null) return false; // Se não encontrar o e-mail, retorna
                return autenticarUsuario(usuarios, pesEmail, "usuario");

            case 2:
                pesEmail = solicitarEmail(bibliotecarios);
                if (pesEmail == null) return false; // Se não encontrar o e-mail, retorna
                return autenticarUsuario(bibliotecarios, pesEmail, "bibliotecario");

            case 3:
                pesEmail = solicitarEmail(administradores);
                if (pesEmail == null) return false; // Se não encontrar o e-mail, retorna
                return autenticarUsuario(administradores, pesEmail, "adm");

            default:
                System.out.println("Opção inválida.");
                return false;
        }
    }

    private static String solicitarEmail(ArrayList<? extends Usuario> lista) {
        System.out.println("Email:");
        String pesEmail = scanner.nextLine();

        // Verifica se o e-mail está cadastrado
        for (Usuario usuario : lista) {
            if (usuario.getEmail().equalsIgnoreCase(pesEmail)) {
                return pesEmail; // Retorna o e-mail se encontrado
            }
        }
        System.out.println("E-mail não cadastrado. Tente novamente.");
        return null; // Retorna null se o e-mail não for encontrado
    }

    private static boolean autenticarUsuario(ArrayList<? extends Usuario> lista, String email, String tipo) {
        String pesSenha;
        Usuario usuarioEncontrado = null;

        // Busca o usuário pelo e-mail
        for (Usuario usuario : lista) {
            if (usuario.getEmail().equalsIgnoreCase(email)) {
                usuarioEncontrado = usuario;
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("E-mail não cadastrado.");
            return false; // E-mail não encontrado
        }

        // Autentica o usuário
        int tentativas = 0; // Contador de tentativas
        while (tentativas < 3) {
            System.out.println("Senha:");
            pesSenha = scanner.nextLine();
            if (usuarioEncontrado.getSenha().equals(pesSenha)) {
                posicaoUsuario = lista.indexOf(usuarioEncontrado);
                tipoUsuario = tipo;
                System.out.println("Login feito com sucesso, " + usuarioEncontrado.getNome() + "!");
                if (tipo.equals("usuario")) {
                    menuUsuario(posicaoUsuario);
                } else if (tipo.equals("bibliotecario")) {
                    menuBibliotecario();
                } else {
                    menuAdm();
                }
                return true;
            } else {
                tentativas++;
                System.out.println("Senha incorreta. Tentativa " + tentativas + " de 3.");
            }
        }

        // Se o usuário errar a senha 3 vezes
        System.out.println("Você excedeu o número de tentativas. Deseja criar uma nova conta? (s/n)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
            criarConta();
        }
        return false; // Retorna falso após 3 tentativas
    }

    static void criarConta() {
        System.out.println("Bem-vindo! Primeiro, nos diga o nível da conta: 1 para usuário, 2 para bibliotecário, 3 para adm.");
        int escolhaConta = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        System.out.println("CPF:");
        String testeCpf = scanner.nextLine();

        if (!validarCPF(testeCpf)) {
            System.out.println("CPF inválido. Conta não criada.");
            return;
        }

        System.out.println("Nome:");
        String nome = scanner.nextLine();

        System.out.println("Email:");
        String email = scanner.nextLine();

        System.out.println("Senha:");
        String senha = scanner.nextLine();

        System.out.println("Confirme a sua senha:");
        String confirmaSenha = scanner.nextLine();

        if (!senha.equals(confirmaSenha)) {
            System.out.println("As senhas não coincidem. Conta não criada.");
            return;
        }

        switch (escolhaConta) {
            case 1: // Usuário
                if (verificaCpfExistente(usuarios, testeCpf)) return;
                Usuario u = new Usuario(++contadorUsuario, testeCpf, nome, email, senha);
                usuarios.add(u);
                System.out.println("Conta de usuário criada com sucesso.");
                tipoUsuario = "usuario";
                posicaoUsuario = usuarios.size() - 1; // Loga automaticamente
                break;

            case 2: // Bibliotecário
                if (verificaCpfExistente(bibliotecarios, testeCpf)) return;
                Bibliotecario b = new Bibliotecario("bli" + (++contadorUsuario), ++contadorUsuario, testeCpf, nome, email, senha);
                bibliotecarios.add(b);
                System.out.println("Conta de bibliotecário criada com sucesso.");
                tipoUsuario = "bibliotecario";
                posicaoUsuario = bibliotecarios.size() - 1; // Loga automaticamente
                menuBibliotecario(); // Volta para o menu do bibliotecário
                break;

            case 3: // Administrador
                if (verificaCpfExistente(administradores, testeCpf)) return;
                Administrador a = new Administrador("ADM" + (++contadorUsuario), ++contadorUsuario, testeCpf, nome, email, senha);
                administradores.add(a);
                System.out.println("Conta de administrador criada com sucesso.");
                tipoUsuario = "adm";
                posicaoUsuario = administradores.size() - 1; // Loga automaticamente
                menuAdm(); // Volta para o menu do administrador
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    static boolean verificaCpfExistente(ArrayList<? extends Usuario> lista, String cpf) {
        for (Usuario usuario : lista) {
            if (usuario.getCpf().equalsIgnoreCase(cpf)) {
                System.out.println("O CPF já está cadastrado.");
                return true;
            }
        }
        return false;
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
                    usuarios.get(posicaoUsuario).visualizarHistorico();
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
                    usuarios.get(posicaoUsuario).editarDados(novoNome, novoEmail, novaSenha);
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
                    bibliotecarios.get(posicaoUsuario).editarDados(novoNome, novoEmail, novaSenha);
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
                    administradores.get(posicaoUsuario).adicionarBibliotecario(cpf, nome, email, senha);
                    break;
                case 2:
                    System.out.println("Digite a posição do usuário que deseja remover:");
                    int posicaoUsuarioRemover = scanner.nextInt();
                    administradores.get(posicaoUsuario).removerUsuario(posicaoUsuarioRemover);
                    break;
                case 3:
                    for (Usuario usuario : usuarios) {
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
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getIdLivro() == idLivro) {
                livros.remove(i);
                System.out.println("Livro removido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    static void visualizarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("=== Lista de Livros ===");
            for (Livro livro : livros) {
                livro.exibir();
                System.out.println();
            }
        }
    }

    static void emprestimo(int posicaoUsuario, int idLivro) {
        if (idLivro < 0 || idLivro >= livros.size()) {
            System.out.println("ID de livro inválido.");
            return;
        }
        
        Livro livro = livros.get(idLivro); // Supondo que 'livros' é uma lista de objetos Livro
        if (livro.isDisponivel()) {
            Emprestimo novoEmprestimo = new Emprestimo(
                ++Biblioteca.contadorEmprestimo, // Incrementa e usa o contador
                usuarios.get(posicaoUsuario), // Passa o objeto Usuario
                livro // Passa o objeto Livro
            );
            livro.setDisponivel(false); // Marca o livro como não disponível
            usuarios.get(posicaoUsuario).registrarEmprestimo(novoEmprestimo);
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Livro não disponível.");
        }
    }

    static void visualizarHistoricoEmprestimos(int idUsuario) {
        if (idUsuario < 0 || idUsuario >= usuarios.size()) {
            System.out.println("Usuário não encontrado.");
            return;
        }
        usuarios.get(idUsuario).visualizarHistorico();
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
      livros.add(novoLivro);

      System.out.println("Livro adicionado com sucesso: " + titulo);
  }


static void criarLivros() {
    livros.add(new Livro(++contadorLivros, "Dom Casmurro", "Machado de Assis", "Romance", "Um dos clássicos da literatura brasileira.", "1899", "Editora A"));
    livros.add(new Livro(++contadorLivros, "O Alquimista", "Paulo Coelho", "Ficção", "Uma fábula sobre seguir seus sonhos.", "1988", "Editora B"));
    livros.add(new Livro(++contadorLivros, "1984", "George Orwell", "Ficção Científica", "Uma distopia sobre um governo totalitário.", "1949", "Editora C"));
    livros.add(new Livro(++contadorLivros, "A Moreninha", "Joaquim Manuel de Macedo", "Romance", "Uma história de amor e amizade.", "1844", "Editora D"));
    livros.add(new Livro(++contadorLivros, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Ficção", "Uma história poética sobre a infância e a amizade.", "1943", "Editora E"));
    livros.add(new Livro(++contadorLivros, "Cem Anos de Solidão", "Gabriel García Márquez", "Realismo Mágico", "A história da família Buendía.", "1967", "Editora F"));
    livros.add(new Livro(++contadorLivros, "A Revolução dos Bichos", "George Orwell", "Ficção", "Uma sátira sobre a política.", "1945", "Editora G"));
    livros.add(new Livro(++contadorLivros, "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "Uma épica jornada pela Terra Média.", "1954", "Editora H"));
    livros.add(new Livro(++contadorLivros, "A Cabana", "William P. Young", "Ficção", "Um encontro com Deus em uma cabana isolada.", "2007", "Editora I"));
    livros.add(new Livro(++contadorLivros, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Fantasia", "A primeira aventura do jovem bruxo Harry Potter.", "1997", "Editora J"));
    livros.add(new Livro(++contadorLivros, "O Morro dos Ventos Uivantes", "Emily Brontë", "Romance", "Uma história de amor e vingança.", "1847", "Editora K"));
    livros.add(new Livro(++contadorLivros, "Orgulho e Preconceito", "Jane Austen", "Romance", "Uma crítica social através de uma história de amor.", "1813", "Editora L"));
    livros.add(new Livro(++contadorLivros, "Moby Dick", "Herman Melville", "Aventura", "A obsessão de um capitão por uma baleia.", "1851", "Editora M"));
    livros.add(new Livro(++contadorLivros, "O Grande Gatsby", "F. Scott Fitzgerald", "Ficção", "Uma crítica à sociedade americana dos anos 1920.", "1925", "Editora N"));
    livros.add(new Livro(++contadorLivros, "A Metamorfose", "Franz Kafka", "Ficção", "A transformação de um homem em inseto.", "1915", "Editora O"));
    livros.add(new Livro(++contadorLivros, "O Apanhador no Campo de Centeio", "J.D. Salinger", "Ficção", "A história de um jovem em busca de identidade.", "1951", "Editora P"));
    livros.add(new Livro(++contadorLivros, "Fahrenheit 451", "Ray Bradbury", "Ficção Científica", "Uma sociedade onde os livros são queimados.", "1953", "Editora Q"));
    livros.add(new Livro(++contadorLivros, "O Sol é Para Todos", "Harper Lee", "Ficção", "Uma reflexão sobre justiça e moralidade.", "1960", "Editora R"));
    livros.add(new Livro(++contadorLivros, "O Estrangeiro", "Albert Camus", "Ficção", "A busca de sentido em um mundo absurdo.", "1942", "Editora S"));
    livros.add(new Livro(++contadorLivros, "A Menina que Roubava Livros", "Markus Zusak", "Ficção", "Uma história sobre o poder das palavras.", "2005", "Editora T"));
    livros.add(new Livro(++contadorLivros, "O Senhor das Moscas", "William Golding", "Ficção", "Um grupo de meninos em uma ilha deserta.", "1954", "Editora U"));
    livros.add(new Livro(++contadorLivros, "O Código Da Vinci", "Dan Brown", "Ficção", "Um thriller que mistura arte e religião.", "2003", "Editora V"));
    livros.add(new Livro(++contadorLivros, "A Garota no Trem", "Paula Hawkins", "Ficção", "Um mistério psicológico sobre um desaparecimento.", "2015", "Editora W"));
    livros.add(new Livro(++contadorLivros, "A Sutil Arte de Ligar o F*da-se", "Mark Manson", "Autoajuda", "Um guia sobre como viver uma vida significativa.", "2016", "Editora X"));
    livros.add(new Livro(++contadorLivros, "O Homem Mais Rico da Babilônia", "George S. Clason", "Autoajuda", "Lições sobre finanças e riqueza.", "1926", "Editora Y"));
    livros.add(new Livro(++contadorLivros, "Como Fazer Amigos e Influenciar Pessoas", "Dale Carnegie", "Autoajuda", "Dicas sobre relacionamentos e influência.", "1936", "Editora Z"));
    livros.add(new Livro(++contadorLivros, "O Poder do Hábito", "Charles Duhigg", "Autoajuda", "Como os hábitos moldam nossas vidas.", "2012", "Editora AA"));
    livros.add(new Livro(++contadorLivros, "O Milagre da Manhã", "Hal Elrod", "Autoajuda", "Um guia para transformar suas manhãs e sua vida.", "2012", "Editora AB"));
    livros.add(new Livro(++contadorLivros, "A Arte da Guerra", "Sun Tzu", "Estratégia", "Um tratado sobre estratégia militar e liderança.", "5 a.C.", "Editora AC"));
    livros.add(new Livro(++contadorLivros, "O Livro dos Espíritos", "Allan Kardec", "Espiritualidade", "Fundamentos do Espiritismo.", "1857", "Editora AD"));
    livros.add(new Livro(++contadorLivros, "A Ciência e a Religião", "Albert Einstein", "Filosofia", "Reflexões sobre ciência e espiritualidade.", "1930", "Editora AE"));
    livros.add(new Livro(++contadorLivros, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", "Ficção", "Uma história poética sobre a infância e a amizade.", "1943", "Editora AF"));
    livros.add(new Livro(++contadorLivros, "A Revolução dos Bichos", "George Orwell", "Ficção", "Uma sátira sobre a política.", "1945", "Editora AG"));
    livros.add(new Livro(++contadorLivros, "A Metamorfose", "Franz Kafka", "Ficção", "A transformação de um homem em inseto.", "1915", "Editora AH"));
    livros.add(new Livro(++contadorLivros, "O Morro dos Ventos Uivantes", "Emily Brontë", "Romance", "Uma história de amor e vingança.", "1847", "Editora AI"));
    livros.add(new Livro(++contadorLivros, "O Grande Gatsby", "F. Scott Fitzgerald", "Ficção", "Uma crítica à sociedade americana dos anos 1920.", "1925", "Editora AJ"));
    livros.add(new Livro(++contadorLivros, "Cem Anos de Solidão", "Gabriel García Márquez", "Realismo Mágico", "A história da família Buendía.", "1967", "Editora AK"));
    livros.add(new Livro(++contadorLivros, "Orgulho e Preconceito", "Jane Austen", "Romance", "Uma crítica social através de uma história de amor.", "1813", "Editora AL"));
    livros.add(new Livro(++contadorLivros, "Moby Dick", "Herman Melville", "Aventura", "A obsessão de um capitão por uma baleia.", "1851", "Editora AM"));
    livros.add(new Livro(++contadorLivros, "O Alquimista", "Paulo Coelho", "Ficção", "Uma fábula sobre seguir seus sonhos.", "1988", "Editora AN"));
    livros.add(new Livro(++contadorLivros, "A Menina que Roubava Livros", "Markus Zusak", "Ficção", "Uma história sobre o poder das palavras.", "2005", "Editora AO"));
    livros.add(new Livro(++contadorLivros, "O Senhor dos Anéis", "J.R.R. Tolkien", "Fantasia", "Uma épica jornada pela Terra Média.", "1954", "Editora AP"));
    livros.add(new Livro(++contadorLivros, "O Estrangeiro", "Albert Camus", "Ficção", "A busca de sentido em um mundo absurdo.", "1942", "Editora AQ"));
    livros.add(new Livro(++contadorLivros, "A Cabana", "William P. Young", "Ficção", "Um encontro com Deus em uma cabana isolada.", "2007", "Editora AR"));
    livros.add(new Livro(++contadorLivros, "O Código Da Vinci", "Dan Brown", "Ficção", "Um thriller que mistura arte e religião.", "2003", "Editora AS"));
    livros.add(new Livro(++contadorLivros, "Fahrenheit 451", "Ray Bradbury", "Ficção Científica", "Uma sociedade onde os livros são queimados.", "1953", "Editora AT"));
    livros.add(new Livro(++contadorLivros, "A Sutil Arte de Ligar o F*da-se", "Mark Manson", "Autoajuda", "Um guia sobre como viver uma vida significativa.", "2016", "Editora AU"));
    livros.add(new Livro(++contadorLivros, "O Homem Mais Rico da Babilônia", "George S. Clason", "Autoajuda", "Lições sobre finanças e riqueza.", "1926", "Editora AV"));
    livros.add(new Livro(++contadorLivros, "Como Fazer Amigos e Influenciar Pessoas", "Dale Carnegie", "Autoajuda", "Dicas sobre relacionamentos e influência.", "1936", "Editora AW"));
    livros.add(new Livro(++contadorLivros, "O Poder do Hábito", "Charles Duhigg", "Autoajuda", "Como os hábitos moldam nossas vidas.", "2012", "Editora AX"));
    livros.add(new Livro(++contadorLivros, "O Milagre da Manhã", "Hal Elrod", "Autoajuda", "Um guia para transformar suas manhãs e sua vida.", "2012", "Editora AY"));
    livros.add(new Livro(++contadorLivros, "A Arte da Guerra", "Sun Tzu", "Estratégia", "Um tratado sobre estratégia militar e liderança.", "5 a.C.", "Editora AZ"));
}



    static void criarAdministradorPadrao() {
        if (administradores.isEmpty()) {
            // Cria um administrador padrão
            Administrador adminPadrao = new Administrador("ADM001", ++contadorUsuario, "000.000.000-00", "Admin Padrão", "admin@biblioteca.com", "senhaAdmin");
            administradores.add(adminPadrao);
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
        for (Livro livro : livros) {
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
        for (Livro livro : livros) {
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

            for (String[] dados : usuariosDados) {
                Usuario usuario = new Usuario(dados[0], dados[1], dados[2], dados[3]);
                usuarios.add(usuario);
            }
        }

        static void criarBibliotecarios() {
            // Criar 2 bibliotecários
            String[][] bibliotecariosDados = {
                {"111.222.333-44", "Maria Clara", "maria.clara@biblioteca.com", "senhaMaria", "1"},
                {"222.333.444-55", "José Carlos", "jose.carlos@biblioteca.com", "senhaJose", "2"}
            };

            for (String[] dados : bibliotecariosDados) {
                int idUsuario = Integer.parseInt(dados[4]); // Convertendo o ID para inteiro
                // Adicionando a senha ao construtor
                Bibliotecario bibliotecario = new Bibliotecario(dados[0], idUsuario, dados[1], dados[2], dados[3], dados[4]);
                bibliotecarios.add(bibliotecario);
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
        for (Bibliotecario bibliotecario : bibliotecarios) {
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
        bibliotecarios.add(novoBibliotecario);

        System.out.println("Conta de bibliotecário criada com sucesso.");
    }

    // Método para gerar um novo ID de usuário
    static int gerarNovoIdUsuario() {
        return ++contadorUsuario; // Incrementa o contador de usuários
    }
}