
package dados;

import biblioteca.Administrador;
import biblioteca.Bibliotecario;
import biblioteca.Livro;
import biblioteca.Usuario;
import java.util.ArrayList;


 public class Dados {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Bibliotecario> bibliotecarios = new ArrayList<>();
    private static ArrayList<Administrador> administradores = new ArrayList<>();
    private static ArrayList<Livro> livros = new ArrayList<>();
    private static String tipoUsuario = "";
    private static int contadorUsuario = 0;
    private static int posicaoUsuario = -1;
    private static int contadorEmprestimo = 0; // Inicializa o contador de empréstimos
    private static int contadorLivros = 0; // Contador de livros para IDs
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
    public static void AumentarContardoUsuario(){
        contadorUsuario ++;
    }
    public static void AumentarContardolivro(){
        contadorLivros++;
    }
    public static void Aumentarcontardoemprestimo(){
        contadorEmprestimo ++;
    }

    public static int getContadorUsuario() {
        return contadorUsuario;
    }
    public static void SalvarPosicaoUsuario(int posicao){
        posicaoUsuario = posicao;
    }

    public static void setTipoUsuario(String tipoUsuario) {
        Dados.tipoUsuario = tipoUsuario;
    }

    public static void setContadorUsuario(int contadorUsuario) {
        Dados.contadorUsuario = contadorUsuario;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        Dados.usuarios = usuarios;
    }

    public static void setBibliotecarios(ArrayList<Bibliotecario> bibliotecarios) {
        Dados.bibliotecarios = bibliotecarios;
    }

    public static void setAdministradores(ArrayList<Administrador> administradores) {
        Dados.administradores = administradores;
    }

    public static void setLivros(ArrayList<Livro> livros) {
        Dados.livros = livros;
    }

    public static void setPosicaoUsuario(int posicaoUsuario) {
        Dados.posicaoUsuario = posicaoUsuario;
    }

    public static void setContadorEmprestimo(int contadorEmprestimo) {
        Dados.contadorEmprestimo = contadorEmprestimo;
    }

    public static void setContadorLivros(int contadorLivros) {
        Dados.contadorLivros = contadorLivros;
    }

   
    
}
