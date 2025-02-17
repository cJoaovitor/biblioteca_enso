package Dados;

public class Dados {
    private static int contadorUsuario = 0;
    private static int contadorEmprestimo = 0;
    private static int contadorLivros = 0;
    private static int contadorBibliotecario = 0;
    private static int contadorAdministrador = 0;
    private static int contadorReserva = 0;
    private static int contadorHistorico = 0;
    private static int contadorNotificacoes = 0;
    private static int posicaoUsuario = -1;

    public static String gerarCodigoUsuario() {
        return "USR" + contadorUsuario++; // Gera um ID único para usuário
    }

    public static String gerarCodigoBibliotecario() {
        return "BIB" + contadorBibliotecario++; // Gera um ID único para bibliotecário
    }

    public static String gerarCodigoAdministrador() {
        return "ADM" + contadorAdministrador++; // Gera um ID único para administrador
    }

    public static String gerarCodigoHistorico() {
        return "HIS" + contadorHistorico++; // Gera um ID único para Histórico
    }

    public static String gerarCodigoNotificacao() {
        return "NOT" + contadorNotificacoes++; // Gera um ID único para Notificações
    }

    public static String gerarCodigoReserva() {
        return "RES" + contadorReserva++; // Gera um ID único para Reserva
    }

    
    
    public static int getContadorUsuario() {
        return contadorUsuario;
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

    public static int getContadorAdministrador() {
        return contadorAdministrador;
    }

    public static int getContadorReserva() {
        return contadorReserva;
    }

    public static int getContadorHistorico() {
        return contadorHistorico;
    }

    public static int getContadorNotificacoes() {
        return contadorNotificacoes;
    }

    public static int getPosicaoUsuario() {
        return posicaoUsuario;
    }
    
    
    

    public static void setPosicaoUsuario(int posicao) {
        posicaoUsuario = posicao;
    }

    public static void setContadorUsuario(int novoValor) {
        contadorUsuario = novoValor;
    }

    public static void setContadorBibliotecario(int contador) {
        contadorBibliotecario = contador;
    }

    public static void setContadorAdministrador(int contador) {
        contadorAdministrador = contador;
    }

    
    
    
    
    public static void incrementarContadorLivros() {
        contadorLivros++;
    }

    public static void decrementarContadorLivros() {
        contadorLivros--;
    }

    public static void incrementarContadorEmprestimos() {
        contadorEmprestimo++;
    }

    public static void decrementarContadorEmprestimos() {
        contadorEmprestimo--;
    }

    public static void incrementarContadorReservas() {
        contadorReserva++;
    }

    public static void decrementarContadorReservas() {
        contadorReserva--;
    }

    public static void incrementarContadorHistorico() {
        contadorHistorico++;
    }

    public static void decrementarContadorHistorico() {
        contadorHistorico--;
    }

    public static void incrementarContadorNotificacoes() {
        contadorNotificacoes++;
    }

    public static void decrementarContadorNotificacoes() {
        contadorNotificacoes--;
    }

    public static Object getUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
