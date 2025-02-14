package Service;

import Model.EmprestimoModel;
import Model.LivroModel;

public class EmpretimoService {
    public static void emprestimo(int posicaoUsuario, int idLivro) {
        // Verifica se o ID do livro é válido
        if (idLivro < 0 || idLivro >= Dados.Dados.getLivros().size()) {
            System.out.println("ID de livro inválido.");
            return;
        }

        LivroModel livro = Dados.Dados.getLivros().get(idLivro); // Obtém o livro da lista
        if (livro.isDisponivel()) {
            // Cria um novo empréstimo usando o construtor adequado
            EmprestimoModel novoEmprestimo = new EmprestimoModel(
                Dados.Dados.getUsuarios().get(posicaoUsuario), // Passa o objeto Usuario
                livro // Passa o objeto Livro
            );

            // Marca o livro como não disponível
            livro.setDisponivel(false);
            // Registra o empréstimo no usuário
            Dados.Dados.getUsuarios().get(posicaoUsuario).registrarEmprestimo(novoEmprestimo);

            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Livro não disponível.");
        }
    }
}
