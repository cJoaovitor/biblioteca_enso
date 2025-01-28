
package dados;

import biblioteca.Administrador;
import biblioteca.Bibliotecario;
import biblioteca.Livro;
import biblioteca.Usuario;
import java.util.ArrayList;


 public class Dados {
    static ArrayList<Usuario> usuarios = new ArrayList<>();
    static ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();
    static ArrayList<Administrador> administradores = new ArrayList<>();
    static ArrayList<Livro> livros = new ArrayList<>();
    int contadorUsuarios;

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static ArrayList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public static ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public static ArrayList<Livro> getLivros() {
        return livros;
    }

    public int getContadorUsuarios() {
        return contadorUsuarios;
    }
    
}
