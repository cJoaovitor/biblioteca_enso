package biblioteca;

import static biblioteca.Biblioteca.contadorLivros;
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
    private boolean disponivel;

    // Construtor que solicita informações do livro ao usuário
    public Livro(Scanner scanner) {
        this(contadorLivros, scanner);
    }

    // Construtor que solicita informações do livro ao usuário
    public Livro(int contadorLivros, Scanner scanner) {
        System.out.print("Digite o ID do livro: ");
        this.idLivro = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Digite o título do livro: ");
        this.titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        this.autor = scanner.nextLine();
        System.out.print("Digite o gênero do livro: ");
        this.genero = scanner.nextLine();
        System.out.print("Digite a descrição do livro: ");
        this.descricao = scanner.nextLine();
        System.out.print("Digite o ano de publicação: ");
        this.anoPublicacao = scanner.nextLine();
        System.out.print("Digite a editora: ");
        this.editora = scanner.nextLine();
        this.disponivel = true; // O livro é criado como disponível
    }

    // Novo construtor para criar livros com parâmetros
    public Livro(int idLivro, String titulo, String autor, String genero, String descricao, String anoPublicacao, String editora) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.descricao = descricao;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.disponivel = true; // O livro é criado como disponível
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

    public boolean isDisponivel() {
        return disponivel;
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

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    // Atualiza a disponibilidade de um livro
    public void atualizarDisponibilidade() {
        this.disponivel = !this.disponivel; // Alterna a disponibilidade
    }

 public static void pesquisarLivros(List<Livro> livros, Scanner scanner) {
    while (true) {
        System.out.println("=== Pesquisa de Livros ===");
        System.out.println("Escolha o critério de pesquisa:");
        System.out.println("1. Título");
        System.out.println("2. Autor");
        System.out.println("3. Gênero");
        System.out.println("4. Ano de Publicação");
        System.out.println("5. Disponibilidade");
        System.out.print("Digite o número da opção desejada: ");

        int opcao = obterEntradaInteira(scanner);
        scanner.nextLine(); // Limpa o buffer

        String termo = "";
        boolean filtrarDisponibilidade = false;

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
            case 5:
                System.out.print("Deseja filtrar por disponibilidade? (s/n): ");
                char respostaDisp = scanner.nextLine().charAt(0);
                filtrarDisponibilidade = (respostaDisp == 's');
                break;
            default:
                System.out.println("Opção inválida. Pesquisa cancelada.");
                return;
        }

        List<Livro> resultados = new ArrayList<>();
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
                case 5:
                    corresponde = filtrarDisponibilidade == livro.isDisponivel();
                    break;
            }

            if (corresponde) {
                resultados.add(livro);
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o termo: " + termo);
        } else {
            // Exibir resultados com paginação
            int pagina = 0;
            int tamanhoPagina = 5; // Ajuste o tamanho da página conforme necessário

            while (true) {
                System.out.println("Resultados encontrados:");
                for (int i = pagina * tamanhoPagina; i < Math.min((pagina + 1) * tamanhoPagina, resultados.size()); i++) {
                    Livro livro = resultados.get(i);
                    System.out.println("Título: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor());
                    System.out.println("Gênero: " + livro.getGenero());
                    System.out.println("Descrição: " + livro.getDescricao());
                    System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
                    System.out.println("Editora: " + livro.getEditora());
                    System.out.println("ID: " + livro.getIdLivro());
                    System.out.println("Disponibilidade: " + (livro.isDisponivel() ? "Disponível" : "Indisponível"));
                    System.out.println("-------------------------------");
                }

                if ((pagina + 1) * tamanhoPagina >= resultados.size()) {
                    break; // Não há mais páginas
                }

                System.out.print("Deseja ver mais resultados? (s/n): ");
                char resposta = scanner.nextLine().charAt(0);
                if (resposta != 's') {
                    break;
                }
                pagina++;
            }
        }

        System.out.print("Deseja realizar outra pesquisa? (s/n): ");
        char resposta = scanner.nextLine().charAt(0);
        if (resposta != 's') {
            break;
        }
    }
}


    // Busca um livro na lista de livros pelo ID
    public static Livro buscarLivroPorId(List<Livro> livros, int idLivro) {
        for (Livro livro : livros) {
            if (livro.getIdLivro() == idLivro) {
                return livro;
            }
        }
        return null;
    }

    // Obtém uma entrada inteira do usuário, tratando exceções
    public static int obterEntradaInteira(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

      // Método para exibir informações do livro
    public void exibir() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Gênero: " + genero);
        System.out.println("Descrição: " + descricao);
        System.out.println("Ano de Publicação: " + anoPublicacao);
        System.out.println("Editora: " + editora);
        System.out.println("ID: " + idLivro);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
    }
}
