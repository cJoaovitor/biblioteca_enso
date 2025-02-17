package Service;

import Model.AdministradorModel;
import Model.BibliotecarioModel;
import Model.LivroModel;
import Model.UsuarioModel;
import Dados.Dados;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFormattedTextField;

public class UsuarioService {

    public static final int TIPO_ADMINISTRADOR = 2025; 
    public static final int TIPO_BIBLIOTECARIO = 2026;
    public static final int TIPO_USUARIO_SIMPLES = 2027;

    public static List<UsuarioModel> obterUsuarios() {
        return Dados.getUsuarios();
    }

    public static UsuarioModel obterUsuarioPorCodigo(String codigo) {
        return Dados.getUsuario(codigo);
    }

    

    public static void excluirUsuario(UsuarioModel usuario) {
        Dados.removerUsuario(usuario);
    }

    public static void login(String cpf, String senha) {
        // Verifica login de usuário comum
        for (UsuarioModel usuario : Dados.getUsuarios()) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                Dados.setTipoUsuario(TIPO_USUARIO_SIMPLES);
                Dados.setPosicaoUsuario(Dados.getUsuarios().indexOf(usuario));
                System.out.println("Login realizado com sucesso como usuário.");
                return;
            }
        }

        // Verifica login de bibliotecário
        for (BibliotecarioModel bibliotecario : Dados.getBibliotecarios()) {
            if (bibliotecario.getCpf().equals(cpf) && bibliotecario.getSenha().equals(senha)) {
                Dados.setTipoUsuario(TIPO_BIBLIOTECARIO);
                Dados.setPosicaoUsuario(Dados.getBibliotecarios().indexOf(bibliotecario));
                System.out.println("Login realizado com sucesso como bibliotecário.");
                return;
            }
        }

        // Verifica login de administrador
        for (AdministradorModel administrador : Dados.getAdministradores()) {
            if (administrador.getCpf().equals(cpf) && administrador.getSenha().equals(senha)) {
                Dados.setTipoUsuario(TIPO_ADMINISTRADOR);
                Dados.setPosicaoUsuario(Dados.getAdministradores().indexOf(administrador));
                System.out.println("Login realizado com sucesso como administrador.");
                return;
            }
        }

        System.out.println("CPF ou senha inválidos.");
    }

    private static boolean verificaCpfExistente(List<UsuarioModel> usuarios, String cpf) {
        return usuarios.stream().anyMatch(usuario -> usuario.getCpf().equals(cpf));
    }
   /*
    public static void visualizarHistorico(String codigoUsuario) {
        UsuarioModel usuario = obterUsuarioPorCodigo(codigoUsuario);
        if (usuario != null) {
            System.out.println("===== HISTÓRICO DO USUÁRIO =====");
            List<LivroModel> livrosEmprestados = usuario.getLivrosEmprestados();
            if (!livrosEmprestados.isEmpty()) {
                for (LivroModel livro : livrosEmprestados) {
                    System.out.println("Título: " + livro.getTitulo());
                }
            } else {
                System.out.println("O usuário não possui livros emprestados.");
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void atualizarUsuario(UsuarioModel usuario) {
        Dados.atualizarUsuario(usuario);
    }

    public static UsuarioModel buscarUsuarioPorNome(String nomeUsuario) {
        return Dados.getUsuarios().stream()
                .filter(usuario -> usuario.getNome().equalsIgnoreCase(nomeUsuario))
                .findFirst()
                .orElse(null);
    }

    public static void criarContaBibliotecario(String cpf, String nome, String email, String senha, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String cep) {
        if (verificaCpfExistente(Dados.getBibliotecarios(), cpf)) {
            System.out.println("CPF já cadastrado.");
            return;
        }

        String idUsuario = Dados.gerarIdUsuario();
        String codigoBibliotecario = Dados.gerarCodigoBibliotecario();

        BibliotecarioModel bibliotecario = new BibliotecarioModel(codigoBibliotecario, idUsuario, cpf, nome, email, senha);
        Dados.adicionarBibliotecario(bibliotecario);
        System.out.println("Conta de bibliotecário criada com sucesso.");
    }

    public static boolean verificaCpfExistente(ArrayList<BibliotecarioModel> bibliotecarios, String cpf) {
        return bibliotecarios.stream()
                .anyMatch(bibliotecario -> bibliotecario.getCpf().equals(cpf));
    }

    public static int verificarTipoUsuario(String cpf) {
        if (Dados.buscarUsuarioPorCpf(cpf) != null) {
            return TIPO_USUARIO_SIMPLES; // Retorna o tipo de usuário
        }
        if (Dados.buscarBibliotecarioPorCpf(cpf) != null) {
            return TIPO_BIBLIOTECARIO; // Retorna o tipo de bibliotecário
        }
        if (Dados.buscarAdministradorPorCpf(cpf) != null) {
            return TIPO_ADMINISTRADOR; // Retorna o tipo de administrador
        }
        return -1; // Retorna -1 se não encontrado
    }

    public static boolean verificarCodigoBibliotecario(String cpf, String codigo) {
        return Dados.getBibliotecarios().stream()
                .anyMatch(bibliotecario -> bibliotecario.getCodigoBibliotecario().equals(codigo) && bibliotecario.getCpf().equals(cpf));
    }

    public static boolean verificarCodigoAdministrador(String cpf, String codigo) {
        return Dados.getAdministradores().stream()
                .anyMatch(administrador -> administrador.getCodigoAdministrador().equals(codigo) && administrador.getCpf().equals(cpf));
    }

    public static void criarContaAdministrador(String cpf, String nome, String email, String senha, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String cep, String codigoAdministrador) {
        if (verificaCpfExistente1(Dados.getAdministradores(), cpf)) {
            System.out.println("CPF já cadastrado.");
            return;
        }

        String idUsuario = Dados.gerarIdUsuario();
        AdministradorModel administrador = new AdministradorModel(codigoAdministrador, idUsuario, cpf, nome, email, senha);
        Dados.adicionarAdministrador(administrador);
        System.out.println("Conta de administrador criada com sucesso.");
    }

    private static boolean verificaCpfExistente1(ArrayList<AdministradorModel> administradores, String cpf) {
        return administradores.stream()
                .anyMatch(administrador -> administrador.getCpf().equals(cpf));
    }

    public static void criarContaBibliotecario(String cpf, String nome, String email, String senha, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String cep, String codigoBibliotecario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 */
}
