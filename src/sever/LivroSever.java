
package sever;

import biblioteca.Biblioteca;
import biblioteca.Emprestimo;
import biblioteca.Livro;

public class LivroSever {
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
 static void visualizarLivrosDisponiveis() {
        System.out.println("===== LIVROS DISPONÍVEIS =====");
        for (Livro livro : dados.Dados.getLivros()) {
            if (livro.isDisponivel()) { 
                System.out.println("ID: " + livro.getIdLivro() + " - Título: " + livro.getTitulo());
            }
        }
    }
}
