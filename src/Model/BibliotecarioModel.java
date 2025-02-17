package Model;

import Dados.Dados;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BibliotecarioModel extends UsuarioModel {
    private String codigoBibliotecario;
    public static int contadorEmprestimo = 0;

    public BibliotecarioModel( int idusuario, String cpf, String nome, String email, String senha, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String cep) {
        super(idusuario, cpf, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep);
        this.codigoBibliotecario = idusuario+"bli";
    }

    

    public static String gerarCodigoBibliotecario() {
        Random random = new Random();
        int codigo = 1000 + random.nextInt(9000);
        return String.format("%04d", codigo);
    }


    public void removerLivro(int idLivro) {
        List<LivroModel> livros = Dados.getLivros(); // Obtém a lista de livros
        if (livros != null) {
            for (int i = 0; i < livros.size(); i++) {
                // Verifica se o ID do livro atual é igual ao ID do livro a ser removido
                if (livros.get(i).getIdLivro()==idLivro) {
                    livros.remove(i); // Remove o livro
                    System.out.println("Livro removido com sucesso!");
                    return; // Sai do método após a remoção
                }
            }
        }
        System.out.println("Livro não encontrado.");
    }


    public void visualizarLivros() {
        if (Dados.getLivros().isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            System.out.println("=== Lista de Livros ===");
            for (LivroModel livro : Dados.getLivros()) {
                livro.exibir();
                System.out.println();
            }
        }
    }
    
    public void registrarEmprestimo(int idUsuario, int idLivro) {
        // Verifica se o ID do usuário é válido
        if (idUsuario < 0 || idUsuario >= Dados.getUsuarios().size()) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        UsuarioModel usuario = Dados.getUsuarios().get(idUsuario);
        // Filtra os livros para encontrar um livro disponível com o ID correspondente
        LivroModel livro = Dados.getLivros().stream()
                .filter(l -> l.getIdLivro()==idLivro && l.getDisponivel())
                .findFirst()
                .orElse(null);

        // Verifica se o livro foi encontrado e se está disponível
        if (livro != null) {
            livro.setDisponivel(false); // Marca o livro como não disponível
            EmprestimoModel novoEmprestimo = new EmprestimoModel(Dados.getPosicaoUsuario(), idLivro); // Usa o construtor correto
            usuario.registrarEmprestimo(novoEmprestimo); // Registra o empréstimo para o usuário
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Livro não disponível ou não encontrado.");
        }
    }



    // aqui vai a função de exbir pelo banco

    @Override
    public void exibirDados() {
        System.out.println("=== Dados do Bibliotecário ===");
        System.out.println("Código: " + codigoBibliotecario);
        super.exibirDados();
    }

    public String getCodigoBibliotecario() {
        return codigoBibliotecario;
    }

    
}

