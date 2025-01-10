import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livro {
       // Atributos da classe Livro
    private final int idLivro;
    private final String titulo;
    private final String autor;
    private final String genero;
    private final String descricao;
    private final String anoPublicacao;
    private final String editora;
    private final int numExemplares;
    private int disponiveis; // Este pode ser alterado
    private final String categoria;

    
     // Chaves de acesso
    private static final String CHAVE_ADM = "D&48QH83@NWk#";
    private static final String CHAVE_BIBLIOTECARIO = "B@18OTe61$IKo&";

    // Lista para armazenar os livros
    private static List<Livro> biblioteca = new ArrayList<>();
    
    
    
    // Construtor da classe Livro
    public Livro(int idLivro, String titulo, String autor, String genero, 
                 String descricao, String anoPublicacao, String editora, 
                 int numExemplares, int disponiveis, String categoria) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.descricao = descricao;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.numExemplares = numExemplares;
        this.disponiveis = disponiveis;
        this.categoria = categoria;
    }

    // Getters
    public int getIdLivro() {
        return idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public int getNumExemplares() {
        return numExemplares;
    }

    public int getDisponiveis() {
        return disponiveis;
    }

    public String getCategoria() {
        return categoria;
    }

    // Setter para 'disponiveis'
    public void setDisponiveis(int disponiveis) {
        this.disponiveis = disponiveis;
    }
    

    
// Método para atualizar a disponibilidade de exemplares
    public void atualizarDisponibilidade() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a chave de acesso: ");
        String chave = scanner.nextLine();

        // Verifica se a chave é válida
        if (!chave.equals(CHAVE_ADM) && !chave.equals(CHAVE_BIBLIOTECARIO)) {
            System.out.println("Acesso negado. Chave inválida.");
            return;
        }

        System.out.print("Digite o título do exemplar: ");
        String tituloExemplar = scanner.nextLine();

        // Verifica se o exemplar existe na biblioteca
        if (!tituloExemplar.equals(this.titulo)) {
            System.out.println("Exemplar não encontrado.");
            return;
        }

        // Verifica a disponibilidade
        if (this.disponiveis > 0) {
            System.out.println("O exemplar \"" + this.titulo + "\" está disponível para empréstimo.");
        } else {
            System.out.println("O exemplar \"" + this.titulo + "\" não está disponível.");
            System.out.print("Deseja registrar um motivo? (s/n): ");
            char resposta = scanner.next().charAt(0);

            if (resposta == 's' || resposta == 'S') {
                System.out.print("Digite o motivo: ");
                scanner.nextLine(); // Limpa o buffer
                String motivo = scanner.nextLine();
                System.out.println("Motivo registrado: " + motivo);
            }
        }

        // Alterar status
        System.out.print("Deseja alterar o status do exemplar? (d - disponível, n - não disponível): ");
        char novoStatus = scanner.next().charAt(0);

        switch (novoStatus) {
            case 'd', 'D' -> {
                this.disponiveis = this.numExemplares; // Define como disponível
                System.out.println("O exemplar \"" + this.titulo + "\" agora está disponível.");
            }
            case 'n', 'N' -> {
                this.disponiveis = 0; // Define como não disponível
                System.out.print("Digite o motivo para não estar disponível: ");
                scanner.nextLine(); // Limpa o buffer
                String motivo = scanner.nextLine();
                System.out.println("O exemplar \"" + this.titulo + "\" agora está não disponível. Motivo registrado: " + motivo);
            }
            default -> System.out.println("Opção inválida.");
        }
    }

    
    
    
 // Método para pesquisar livros 
    public static void pesquisarLivros() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Pesquisa de Livros ===");
        System.out.println("Escolha um critério de pesquisa:");
        System.out.println("1. Título");
        System.out.println("2. Autor");
        System.out.println("3. Categoria");
        System.out.println("4. Gênero");
        System.out.println("5. Ano de Publicação");
        System.out.println("6. Editora");
        System.out.print("Digite o número do critério desejado: ");
        
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        String criterio = "";
        switch (opcao) {
            case 1 -> criterio = "titulo";
            case 2 -> criterio = "autor";
            case 3 -> criterio = "categoria";
            case 4 -> criterio = "genero";
            case 5 -> criterio = "ano";
            case 6 -> criterio = "editora";
            default -> {
                System.out.println("Opção inválida.");
                return;
            }
        }

        // Exibir todos os livros que correspondem ao critério selecionado
        System.out.println("=== Livros disponíveis para o critério: " + criterio + " ===");
        boolean encontrouLivros = false;
        for (Livro livro : biblioteca) {
            switch (criterio) {
                case "titulo" -> {
                    System.out.println("Título: " + livro.titulo);
                    encontrouLivros = true;
                }
                case "autor" -> {
                    System.out.println("Autor: " + livro.autor);
                    encontrouLivros = true;
                }
                case "categoria" -> {
                    System.out.println("Categoria: " + livro.categoria);
                    encontrouLivros = true;
                }
                case "genero" -> {
                    System.out.println("Gênero: " + livro.genero);
                    encontrouLivros = true;
                }
                case "ano" -> {
                    System.out.println("Ano de Publicação: " + livro.anoPublicacao);
                    encontrouLivros = true;
                }
                case "editora" -> {
                    System.out.println("Editora: " + livro.editora);
                    encontrouLivros = true;
                }
            }
        }

        if (!encontrouLivros) {
            System.out.println("Nenhum livro disponível para o critério selecionado.");
            return;
        }

        // Solicitar valor para pesquisa
        System.out.print("Digite o valor para pesquisa: ");
        String valor = scanner.nextLine();
        boolean encontrado = false;

        for (Livro livro : biblioteca) {
            switch (criterio) {
                case "titulo" -> {
                    if (livro.titulo.equalsIgnoreCase(valor)) {
                        livro.exibirDetalhes();
                        encontrado = true;
                    }
                }
                case "autor" -> {
                    if (livro.autor.equalsIgnoreCase(valor)) {
                        livro.exibirDetalhes();
                        encontrado = true;
                    }
                }
                case "categoria" -> {
                    if (livro.categoria.equalsIgnoreCase(valor)) {
                        livro.exibirDetalhes();
                        encontrado = true;
                    }
                }
                case "genero" -> {
                    if (livro.genero.equalsIgnoreCase(valor)) {
                        livro.exibirDetalhes();
                        encontrado = true;
                    }
                }
                case "ano" -> {
                    if (livro.anoPublicacao.equals(valor)) {
                        livro.exibirDetalhes();
                        encontrado = true;
                    }
                }
                case "editora" -> {
                    if (livro.editora.equalsIgnoreCase(valor)) {
                        livro.exibirDetalhes();
                        encontrado = true;
                    }
                }
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum livro encontrado com o critério: " + valor);
        }
    }
    
    
    
    
    // Método para exibir detalhes do livro
    public void exibirDetalhes() {
        System.out.println("=== Detalhes do Livro ===");
        System.out.println("ID: " + idLivro);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Gênero: " + genero);
        System.out.println("Descrição: " + descricao);
        System.out.println("Ano de Publicação: " + anoPublicacao);
        System.out.println("Editora: " + editora);
        System.out.println("Número de Exemplares: " + numExemplares);
        System.out.println("Disponíveis: " + disponiveis);
        System.out.println("Categoria: " + categoria);
        System.out.println("=========================");
    }
    
    
    

    // Método para adicionar livro à biblioteca
    public static void adicionarLivro(Livro livro) {
        biblioteca.add(livro);
        System.out.println("Livro adicionado com sucesso: " + livro.titulo);
    }

    
    
    // Método para exibir o menu
    public static void exibirMenu() {
        System.out.println("=== Menu da Biblioteca ===");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Atualizar Disponibilidade de Exemplares");
        System.out.println("3. Pesquisar Livro");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }
}