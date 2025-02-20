package Model;

import DAO.HistoricoDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoModel {
    private static int contadorEmprestimos = 1; 
    private int idEmprestimo;
    private int  idusuario;
    private  int idlivro;
    private int quantderenovar;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    // Construtor principal
    public EmprestimoModel(int  idusuario, int  idlivro) {
        this.idEmprestimo = idEmprestimo;
        this.idusuario = idusuario;
        this.idlivro = idlivro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(14);
        this.devolvido = false;
        this.quantderenovar =0;
         // Incrementa o contador
    }

    public EmprestimoModel(int idEmprestimo, int idusuario, int idlivro,  LocalDate dataEmprestimo, LocalDate dataDevolucao,int quantderenovar, boolean devolvido) {
        this.idEmprestimo = idEmprestimo;
        this.idusuario = idusuario;
        this.idlivro = idlivro;
        this.quantderenovar = quantderenovar;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
    }

   
    // Métodos Getters
    
    public int getQuantderenovar() { return quantderenovar; }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }
    public int getIdUsuario() { return idusuario; }
    public int  getLivro() { return idlivro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public boolean getDevolvido() { return devolvido; }

    // Método para devolver o empréstimo
    public void devolverEmprestimo() {
        this.devolvido = true;
        System.out.println("Empréstimo devolvido com sucesso!");
    }

    // Método para renovar o empréstimo
    public void renovarEmprestimo() {
        if (!devolvido) {
            this.dataDevolucao = this.dataDevolucao.plusDays(7);
            System.out.println("Empréstimo renovado. Nova data de devolução: " + dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } else {
            System.out.println("Não é possível renovar um empréstimo já devolvido.");
        }
    }

    // Método para calcular a multa
    public float calcularMulta() {
        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(dataDevolucao) && !devolvido) {
            long diasAtraso = hoje.toEpochDay() - dataDevolucao.toEpochDay();
            float multaPorDia = 1.5f;
            return diasAtraso * multaPorDia;
        }
        return 0;
    }

    // Método para exibir informações do empréstimo
    public void exibirEmprestimo() {
        System.out.println("=== Informações do Empréstimo ===");
        System.out.println("ID do Empréstimo: " + idEmprestimo);
        System.out.println("Usuário: " + Dados.Dados.getUsuario(idusuario).getNome());
        System.out.println("Título do Livro: " + Dados.Dados.getLivro(idlivro).getTitulo());
        System.out.println("Data de Empréstimo: " + dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data de Devolução: " + dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Status: " + (devolvido ? "Devolvido" : "Não devolvido"));
    }

    // Método para reservar o livro
    public void reservar(UsuarioModel usuarioReserva) {
        if (devolvido) {
            System.out.println("O livro já está disponível para empréstimo.");
        } else {
            
            System.out.println("Usuário "+usuarioReserva.getNome()+" reservado o livro "+Dados.Dados.getLivro(idlivro).getTitulo()+" com sucesso.");
        }
    }

    // Método para notificar reservas
 
    // Método para definir nova data de devolução
    public void setDataDevolucao(LocalDate novaDevolucao) {
        this.dataDevolucao = novaDevolucao;
    }
}
