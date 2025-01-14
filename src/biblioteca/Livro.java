package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livro {
    private int idLivro;
    private String titulo;
    private String autor;
    private String genero;
    private String descricao;
    private String anoPublicacao;
    private String editora;
    private List<Exemplar> exemplares;

    // Construtor
    public Livro(int idLivro, String titulo, String autor, String genero, String descricao,
                 String anoPublicacao, String editora, int numExemplares) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.descricao = descricao;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.exemplares = new ArrayList<>();

        // Adiciona exemplares ao livro com IDs únicos
        for (int i = 1; i <= numExemplares; i++) {
            exemplares.add(new Exemplar(idLivro * 100 + i)); // Combina o ID do livro com um número sequencial
        }
    }

    // Métodos Getters
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

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    // Métodos Setters
    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public static void exibirMenu() {
        System.out.println("=== Menu da Biblioteca ===");
        System.out.println("1. Adicionar Livro");
        System.out.println("2. Atualizar Disponibilidade de Exemplares");
        System.out.println("3. Pesquisar Livro");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public static void adicionarLivros(List<Livro> livros, Scanner scanner) {
        while (true) {
            System.out.print("Digite o ID do livro: ");
            int idLivro = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
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
            System.out.print("Digite o número de exemplares: ");
            int numExemplares = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            livros.add(new Livro(idLivro, titulo, autor, genero, descricao, anoPublicacao, editora, numExemplares));
            System.out.println("Livro adicionado com sucesso!");

            System.out.print("Deseja adicionar outro livro? (s/n): ");
            char resposta = scanner.nextLine().charAt(0);
            if (resposta != 's') {
                break;
            }
        }
    }

    public void atualizarDisponibilidadeExemplares(Scanner scanner) {
        if (exemplares.isEmpty()) {
            System.out.println("Nenhum exemplar cadastrado.");
            return;
        }

        while (true) {
            // Exibe todos os exemplares do livro atual com seus IDs
            System.out.println("Exemplares disponíveis para o livro \"" + titulo + "\":");
            for (Exemplar exemplar : exemplares) {
                System.out.println("ID do Exemplar: " + exemplar.getIdExemplar() + " - " +
                        (exemplar.isDisponivel() ? "Disponível" : "Não disponível"));
            }

            System.out.print("Digite o ID do exemplar para atualizar a disponibilidade: ");
            int idExemplar = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer
            Exemplar exemplar = buscarExemplarPorId(idExemplar);
            if (exemplar == null) {
                System.out.println("Exemplar não encontrado.");
                return;
            }
            System.out.println("O exemplar ID " + exemplar.getIdExemplar() + " está " +
                    (exemplar.isDisponivel() ? "disponível." : "não disponível."));
            System.out.print("Deseja alterar a disponibilidade? (d - disponível, n - não disponível): ");
            char status = scanner.nextLine().charAt(0);
            if (status == 'd') {
                if (!exemplar.isDisponivel()) {
                    exemplar.setDisponivel(true);
                    System.out.println("Exemplar agora disponível.");
                } else {
                    System.out.println("O exemplar já está disponível.");
                }
            } else if (status == 'n') {
                if (exemplar.isDisponivel()) {
                    System.out.print("Por que o exemplar está sendo marcado como não disponível? ");
                    String justificativa = scanner.nextLine();
                    exemplar.setDisponivel(false);
                    System.out.println("Exemplar agora não disponível. Justificativa: " + justificativa);
                } else {
                    System.out.println("O exemplar já está não disponível.");
                }
            } else {
                System.out.println("Opção inválida.");
            }

            System.out.print("Deseja atualizar a disponibilidade de outro exemplar? (s/n): ");
            char resposta = scanner.nextLine().charAt(0);
            if (resposta != 's') {
                break;
            }
        }
    }

    private Exemplar buscarExemplarPorId(int idExemplar) {
        for (Exemplar exemplar : exemplares) {
            if (exemplar.getIdExemplar() == idExemplar) {
                return exemplar;
            }
        }
        return null;
    }

    public static void pesquisarLivros(List<Livro> livros, Scanner scanner) {
        while (true) {
            System.out.println("=== Pesquisa de Livros ===");
            System.out.println("Escolha o critério de pesquisa:");
            System.out.println("1. Título");
            System.out.println("2. Autor");
            System.out.println("3. Gênero");
            System.out.println("4. Ano de Publicação");
            System.out.print("Digite o número da opção desejada: ");

            int opcao = obterEntradaInteira(scanner);
            scanner.nextLine(); // Limpa o buffer

            String termo = "";
            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    termo = scanner.nextLine();
                    break;
                case 2:
                    System.out.print("Digite o autor do livro: ");
                    termo = scanner.nextLine();
                    break;
                case 3:
                    System.out.print("Digite o gênero do livro: ");
                    termo = scanner.nextLine();
                    break;
                case 4:
                    System.out.print("Digite o ano de publicação do livro: ");
                    termo = scanner.nextLine();
                    break;
                default:
                    System.out.println("Opção inválida. Pesquisa cancelada.");
                    return;
            }

            boolean encontrado = false;
            for (Livro livro : livros) {
                boolean corresponde = false;

                switch (opcao) {
                    case 1:
                        corresponde = livro.getTitulo().toLowerCase().contains(termo.toLowerCase());
                        break;
                    case 2:
                        corresponde = livro.getAutor().toLowerCase().contains(termo.toLowerCase());
                        break;
                    case 3:
                        corresponde = livro.getGenero().toLowerCase().contains(termo.toLowerCase());
                        break;
                    case 4:
                        corresponde = livro.getAnoPublicacao().contains(termo);
                        break;
                }

                if (corresponde) {
                    System.out.println("Livro encontrado:");
                    System.out.println("Título: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor());
                    System.out.println("Gênero: " + livro.getGenero());
                    System.out.println("Descrição: " + livro.getDescricao());
                    System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
                    System.out.println("Editora: " + livro.getEditora());
                    System.out.println("ID: " + livro.getIdLivro());
                    System.out.println("Exemplares disponíveis: " + livro.getExemplaresDisponiveis());
                    System.out.println("-------------------------------");
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("Nenhum livro encontrado com o termo: " + termo);
            }

            System.out.print("Deseja realizar outra pesquisa? (s/n): ");
            char resposta = scanner.nextLine().charAt(0);
            if (resposta != 's') {
                break;
            }
        }
    }

    private static int obterEntradaInteira(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

    public int getExemplaresDisponiveis() {
        int count = 0;
        for (Exemplar exemplar : exemplares) {
            if (exemplar.isDisponivel()) {
                count++;
            }
        }
        return count;
    }

    // Classe interna Exemplar
    public class Exemplar {
        private final int idExemplar;
        private boolean disponivel;

        public Exemplar(int idExemplar) {
            this.idExemplar = idExemplar;
            this.disponivel = true; // Exemplar começa disponível
        }

        public int getIdExemplar() {
            return idExemplar;
        }

        public boolean isDisponivel() {
            return disponivel;
        }

        public void setDisponivel(boolean disponivel) {
            this.disponivel = disponivel;
        }
    }
}
