package Service;

import DAO.LivroDAO;
import Model.LivroModel;
import Model.UsuarioModel;
import Dados.Dados;
import java.util.List;

public class LivroService {

    public static List<LivroModel> obterLivros() {
        return Dados.getLivros();
    }

    public static LivroModel obterLivroPorCodigo(String codigo) {
        for (LivroModel livro : Dados.getLivros()) {
            if (livro.getCodigo().equals(codigo)) {
                return livro;
            }
        }
        return null;
    }

    public static LivroModel obterLivroPorId(int id) {
        for (LivroModel livro : Dados.getLivros()) {
            if (livro.getIdLivro() == id) {
                return livro;
            }
        }
        return null;
    }
         

    public static void emprestar(LivroModel livro, UsuarioModel usuario) {
        if (livro.getDisponivel()) {
            livro.setDisponivel(false);
            usuario.adicionarLivroEmprestado(livro);
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("O livro não está disponível para empréstimo.");
        }
    }

    public static void devolver(LivroModel livro, UsuarioModel usuario) {
        List<LivroModel> livrosEmprestados = usuario.getLivrosEmprestados();
        if (!livrosEmprestados.contains(livro)) {
            System.out.println("O usuário não possui este livro emprestado.");
            return;
        }

        livro.setDisponivel(true);
        livrosEmprestados.remove(livro);
        System.out.println("Livro devolvido com sucesso!");
    }

    public static void salvarLivro(LivroModel livro) {
        Dados.adicionarLivro(livro);
        System.out.println("Livro salvo com sucesso!");
    }

    public static void atualizarLivro(LivroModel livro) {
        int index = Dados.getLivros().indexOf(livro);
        if (index != -1) {
            Dados.getLivros().set(index, livro);
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void excluirLivro(LivroModel livro) {
        if (Dados.getLivros().remove(livro)) {
            System.out.println("Livro excluído com sucesso!");
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void visualizarLivrosDisponiveis() {
        List<LivroModel> livrosDisponiveis = Dados.getLivros().stream()
            .filter(LivroModel::getDisponivel)
            .toList(); // Usando stream para filtrar os livros disponíveis
        
        if (livrosDisponiveis.isEmpty()) {
            System.out.println("Nenhum livro disponível no momento.");
        } else {
            System.out.println("=== Livros Disponíveis ===");
            for (LivroModel livro : livrosDisponiveis) {
                System.out.println("Título: " + livro.getTitulo() + ", Autor: " + livro.getAutor());
            }
        }
    }

    public static void consultarDetalhesLivro(String idConsulta) {
        LivroModel livro = obterLivroPorId(idConsulta);
        if (livro != null) {
            System.out.println("=== Detalhes do Livro ===");
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Gênero: " + livro.getGenero());
            System.out.println("Descrição: " + livro.getDescricao());
            System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
            System.out.println("Editora: " + livro.getEditora());
            System.out.println("Disponível: " + (livro.isDisponivel() ? "Sim" : "Não"));
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    public static List<LivroModel> listarLivros() {
        return obterLivros(); // Retorna a lista de todos os livros
    }

    public static LivroModel buscarLivroPorCodigo(String codigoLivro) {
        DAO.LivroDAO l = new LivroDAO();
        return l.buscarLivroPorCodigo(codigoLivro); // Usa o método já implementado
    }

    public static LivroModel buscarLivroPorId(String livroId) {
        return obterLivroPorId(livroId); // Usa o método já implementado
    }

    public static void emprestarLivro(String codigoLivro, UsuarioModel usuario) {
        LivroModel livro = obterLivroPorCodigo(codigoLivro);
        if (livro != null) {
            emprestar(livro, usuario); // Usa o método de emprestar
        } else {
            System.out.println("Livro não encontrado para empréstimo.");
        }
    }

    public static LivroModel buscarLivroPorId(int livroId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
