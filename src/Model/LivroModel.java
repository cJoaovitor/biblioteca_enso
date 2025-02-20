package Model;

import DAO.LivroDAO;
import Dados.Dados;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroModel {
    private int id;
    private String codigo;
    private String titulo;
    private String autor;
    private String genero;
    private String descricao;
    private String anoPublicacao;
    private String editora;
    private boolean disponivel;
    private boolean emprestado;
    private String status;

    // Construtor com Scanner
   

    // Construtor com id e Scanner
    public LivroModel(int id, Scanner scanner) {
        this.id = id;
        System.out.print("Digite o código do livro: ");
        this.codigo = scanner.nextLine();
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
        this.disponivel = true;
        this.emprestado = false;
        System.out.println("qual e o status do livro");
        this.status =  scanner.nextLine();
    }

    // Construtor com parâmetros
    public LivroModel(int id , String titulo, String autor, String genero, String descricao, String anoPublicacao, String editora,String status) {
        this.id = id;
        this.codigo = id+"livro";
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.descricao = descricao;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.disponivel = true;
        this.emprestado = false;
        this.status = status;
    }

    // Métodos getters
    public int getIdLivro() {
        return id;
    }

    public String getCodigo() {
        return codigo;
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

    public boolean getDisponivel() {
        return disponivel;
    }

    public boolean getEmprestado() {
        return emprestado;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void adicionarStatus(String novoStatus) {
        this.status =novoStatus;
              }

    public void atualizarDisponibilidade() {
        this.disponivel = !this.disponivel;
    }

    public void exibir() {
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Gênero: " + genero);
        System.out.println("Descrição: " + descricao);
        System.out.println("Ano de Publicação: " + anoPublicacao);
        System.out.println("Editora: " + editora);
        System.out.println("ID: " + id);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("Emprestado: " + (emprestado ? "Sim" : "Não"));
        System.out.println("Status:"+status);
        
    }

    public static LivroModel buscarLivro(List<LivroModel> livros, int id) {
    for (LivroModel livro : livros) {
        if (livro.getIdLivro() == id ) {
            return livro;
        }
    }
    return null;
}



   public static void emprestarLivro(List<LivroModel> livros, Scanner scanner) {
    System.out.print("Digite o código do livro que deseja emprestar: ");
    String codigoLivro = scanner.nextLine();

    LivroModel livro = buscarLivroPorCodigo(livros, codigoLivro);
    if (livro != null) {
        if (livro.getDisponivel() && !livro.getEmprestado()) {
            livro.setEmprestado(true);
            livro.setDisponivel(false); // Atualiza a disponibilidade
            livro.adicionarStatus("Emprestado");
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("O livro não está disponível para empréstimo.");
        }
    } else {
        System.out.println("Livro não encontrado.");
    }
}


   public static void devolverLivro(List<LivroModel> livros, Scanner scanner) {
    System.out.print("Digite o código do livro que deseja devolver: ");
    String codigoLivro = scanner.nextLine();

    LivroModel livro = buscarLivroPorCodigo(livros, codigoLivro);
    if (livro != null) {
        if (livro.getEmprestado()) {
            livro.setEmprestado(false);
            livro.setDisponivel(true); // Atualiza a disponibilidade
            livro.adicionarStatus("Devolvido");
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("O livro não está emprestado.");
        }
    } else {
        System.out.println("Livro não encontrado.");
    }
}

<<<<<<< HEAD
   
=======
    
    
            
        
        
        
            
        
        
    
>>>>>>> f5296994deddd829a700ab004b65cc0cae078ef8
}