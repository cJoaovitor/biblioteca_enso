package Dados;

import Model.AdministradorModel;
import Model.BibliotecarioModel;
import Model.EmprestimoModel;
import Model.LivroModel;
import Model.UsuarioModel;
import java.util.ArrayList;
import java.util.List;

public class Dados {
    private static final ArrayList<UsuarioModel> usuarios = new ArrayList<>();
    private static final ArrayList<BibliotecarioModel> bibliotecarios = new ArrayList<>();
    private static final ArrayList<AdministradorModel> administradores = new ArrayList<>();
    private static final ArrayList<LivroModel> livros = new ArrayList<>();
    private static final ArrayList<EmprestimoModel> emprestimos = new ArrayList<>();
    private static String tipoUsuario = "";
    private static int contadorUsuario = 0;
    private static int posicaoUsuario = -1;
    private static int contadorEmprestimo = 0; // Contador de empréstimos
    private static int contadorLivros = 0; // Contador de livros para IDs
    private static int contadorBibliotecario = 0; // Contador de bibliotecários
      

    public static String gerarIdUsuario() {
        return "USR" + contadorUsuario++; // Gera um ID único para usuário
    }

    public static String gerarCodigoBibliotecario() {
        return "BIB" + contadorBibliotecario++; // Gera um ID único para bibliotecário
    }

    public static int getContadorUsuario() {
        return contadorUsuario; // Retorna o contador atual
    }

    // Getters
    public static ArrayList<UsuarioModel> getUsuarios() {
        return new ArrayList<>(usuarios);
    }

    public static ArrayList<BibliotecarioModel> getBibliotecarios() {
        return new ArrayList<>(bibliotecarios);
    }

    public static ArrayList<AdministradorModel> getAdministradores() {
        return new ArrayList<>(administradores);
    }

    public static ArrayList<LivroModel> getLivros() {
        return new ArrayList<>(livros);
    }

    public static ArrayList<EmprestimoModel> getEmprestimos() {
        return new ArrayList<>(emprestimos);
    }

    public static String getTipoUsuario() {
        return tipoUsuario;
    }

    public static int getPosicaoUsuario() {
        return posicaoUsuario;
    }
    
    
 

    public static int getContadorEmprestimo() {
        return contadorEmprestimo;
    }

    public static int getContadorLivros() {
        return contadorLivros;
    }

 
    
    public static int getContadorBibliotecario() {
        return contadorBibliotecario;
    }

    public static void setContadorUsuario(int novoValor) {
        contadorUsuario = novoValor;
    }

    public static void setContadorBibliotecario(int contador) {
        contadorBibliotecario = contador;
    }

    // Métodos para adicionar e remover
    public static void adicionarLivro(LivroModel livro) {
        livros.add(livro);
        contadorLivros++;
        System.out.println("Livro adicionado com sucesso! Total de livros: " + contadorLivros);
    }

    public static void removerLivro(LivroModel livro) {
        if (livros.remove(livro)) {
            contadorLivros--;
            System.out.println("Livro removido com sucesso! Total de livros: " + contadorLivros);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

   public static void adicionarUsuario(UsuarioModel usuario) {
    usuarios.add(usuario);
    contadorUsuario++;
    System.out.println("Usuário adicionado com sucesso! Total de usuários: " + contadorUsuario);
}

public static void removerUsuario(UsuarioModel usuario) {
    if (usuarios.remove(usuario)) {
        contadorUsuario--;
        System.out.println("Usuário removido com sucesso! Total de usuários: " + contadorUsuario);
    } else {
        System.out.println("Usuário não encontrado!");
    }
}

public static void adicionarBibliotecario(BibliotecarioModel bibliotecario) {
    bibliotecarios.add(bibliotecario);
    contadorBibliotecario++;
    System.out.println("Bibliotecário adicionado com sucesso! Total de bibliotecários: " + contadorBibliotecario);
}

public static void removerBibliotecario(BibliotecarioModel bibliotecario) {
    if (bibliotecarios.remove(bibliotecario)) {
        contadorBibliotecario--;
        System.out.println("Bibliotecário removido com sucesso! Total de bibliotecários: " + contadorBibliotecario);
    } else {
        System.out.println("Bibliotecário não encontrado!");
    }
}


    public static void adicionarAdministrador(AdministradorModel administrador) {
        administradores.add(administrador);
        System.out.println("Administrador adicionado com sucesso! Total de administradores: " + administradores.size());
    }

    public static void removerAdministrador(AdministradorModel administrador) {
        if (administradores.remove(administrador)) {
            System.out.println("Administrador removido com sucesso! Total de administradores: " + administradores.size());
        } else {
            System.out.println("Administrador não encontrado!");
        }
    }

    public static void adicionarEmprestimo(EmprestimoModel emprestimo) {
        emprestimos.add(emprestimo);
        contadorEmprestimo++;
        System.out.println("Empréstimo adicionado com sucesso! Total de empréstimos: " + contadorEmprestimo);
    }

    public static void removerEmprestimo(EmprestimoModel emprestimo) {
        if (emprestimos.remove(emprestimo)) {
            contadorEmprestimo--;
            System.out.println("Empréstimo removido com sucesso! Total de empréstimos: " + contadorEmprestimo);
        } else {
            System.out.println("Empréstimo não encontrado!");
        }
    }

    public static void salvarPosicaoUsuario(int posicao) {
        posicaoUsuario = posicao;
    }

    public static void setTipoUsuario(String tipoUsuario) {
        Dados.tipoUsuario = tipoUsuario;
    }

    public static void setUsuarios(ArrayList<UsuarioModel> usuarios) {
        Dados.usuarios.clear();
        Dados.usuarios.addAll(usuarios);
        contadorUsuario = Dados.usuarios.size(); // Atualiza o contador com o tamanho da lista
    }

    public static void setBibliotecarios(ArrayList<BibliotecarioModel> bibliotecarios) {
        Dados.bibliotecarios.clear();
        Dados.bibliotecarios.addAll(bibliotecarios);
        contadorBibliotecario = Dados.bibliotecarios.size(); // Atualiza o contador com o tamanho da lista
    }

    public static void setAdministradores(ArrayList<AdministradorModel> administradores) {
        Dados.administradores.clear();
        Dados.administradores.addAll(administradores);
    }

    public static void setLivros(ArrayList<LivroModel> livros) {
        Dados.livros.clear();
        Dados.livros.addAll(livros);
        contadorLivros = Dados.livros.size(); // Atualiza o contador com o tamanho da lista
    }

    public static void setEmprestimos(ArrayList<EmprestimoModel> emprestimos) {
        Dados.emprestimos.clear();
        Dados.emprestimos.addAll(emprestimos);
        contadorEmprestimo = Dados.emprestimos.size(); // Atualiza o contador com o tamanho da lista
    }

    public static void setPosicaoUsuario(int posicaoUsuario) {
        Dados.posicaoUsuario = posicaoUsuario;
    }

    // Métodos de busca
    public static UsuarioModel buscarUsuarioPorCpf(String cpf) {
        return usuarios.stream()
                .filter(usuario -> usuario.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public static UsuarioModel getUsuario(String codigoUsuario) {
        if (codigoUsuario == null) {
            System.out.println("Código do usuário não pode ser nulo.");
            return null;
        }
        
        return usuarios.stream()
                .filter(usuario -> usuario.getIdusuario() != null && usuario.getIdusuario().equals(codigoUsuario))
                .findFirst()
                .orElse(null);
    }

    public static BibliotecarioModel buscarBibliotecarioPorCpf(String cpf) {
        return bibliotecarios.stream()
                .filter(bibliotecario -> bibliotecario.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public static AdministradorModel buscarAdministradorPorCpf(String cpf) {
        return administradores.stream()
                .filter(administrador -> administrador.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public static LivroModel buscarLivroPorCodigo(String codigo) {
        return livros.stream()
                .filter(livro -> livro.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public static LivroModel getLivro(String codigoLivro) {
        return livros.stream()
                .filter(livro -> livro.getIdLivro().equals(codigoLivro))
                .findFirst()
                .orElse(null);
    }

    public static void atualizarUsuario(UsuarioModel usuarioSelecionado) {
        int index = usuarios.indexOf(usuarioSelecionado);
        if (index != -1) {
            usuarios.set(index, usuarioSelecionado);
            System.out.println("Usuário atualizado com sucesso!");
        } else {
            System.out.println("Usuário não encontrado!");
        }
    }

    public static List<LivroModel> buscarLivrosPorAutor(String autorPesquisado) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autorPesquisado))
                .toList();
    }

    public static List<LivroModel> buscarLivrosPorTitulo(String tituloLivro) {
        return livros.stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(tituloLivro))
                .toList();
    }

    public static List<LivroModel> buscarLivrosPorGenero(String genero) {
        return livros.stream()
                .filter(livro -> livro.getGenero().equalsIgnoreCase(genero))
                .toList();
    }

    public static BibliotecarioModel buscarBibliotecarioPorId(String id) {
        return bibliotecarios.stream()
                .filter(bibliotecario -> bibliotecario.getCodigoBibliotecario().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static LivroModel getLivro(int codLivro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static UsuarioModel getUsuario(int codUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void setTipoUsuario(int TIPO_ADMINISTRADOR) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
 

    
}
