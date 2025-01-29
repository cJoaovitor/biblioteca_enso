
package sever;

import biblioteca.Biblioteca;
import biblioteca.Emprestimo;
import biblioteca.Livro;

public class Empretimosever {
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
}
