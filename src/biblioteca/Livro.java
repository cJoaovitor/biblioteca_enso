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
    private boolean disponivel;

    // Construtor
   public  Livro( Scanner scanner) {
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


    // Adiciona novos livros à lista de livros
    
    

        // Atualiza a disponibilidade de um livro
    public  void atualizarDisponibilidade( Scanner scanner) {
        if (disponivel = true){
            disponivel = false;
        }else {
            disponivel = true;
        }
    }


    // Pesquisa livros com base em diferentes critérios
    public  void pesquisarLivros(List<Livro> livros, Scanner scanner) {
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
                    System.out.println("Disponibilidade: " + (livro.isDisponivel() ? "Disponível" : "Indisponível"));
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

    // Busca um livro na lista de livros pelo ID
    static Livro buscarLivroPorId(List<Livro> livros, int idLivro) {
        for (Livro livro : livros) {
            if (livro.getIdLivro() == idLivro) {
                return livro;
            }
        }
        return null;
    }

    // Obtém uma entrada inteira do usuário, tratando exceções
    static int obterEntradaInteira(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }
    public void exibir(){
        System.out.println(titulo);
        System.out.println(genero);
        System.out.println(autor);
        System.out.println(editora);
        System.out.println(disponivel);
        System.out.println(descricao);
        System.out.println(idLivro);
        System.out.println(anoPublicacao);
    }
}

