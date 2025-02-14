package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoModel {
    private static int contadorEmprestimos = 1; 
    private String idEmprestimo;
    private int  idusuario;
    private  int idlivro;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;
    private List<UsuarioModel> reservas;

    // Construtor principal
    public EmprestimoModel(int  idusuario, int  idlivro) {
        this.idEmprestimo = gerarCodigoEmprestimo(contadorEmprestimos);
        this.idusuario = idusuario;
        this.idlivro = idlivro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataEmprestimo.plusDays(14);
        this.devolvido = false;
        this.reservas = new ArrayList<>();
        contadorEmprestimos++; // Incrementa o contador
    }

    // Método para gerar códigos de empréstimo
    private static String gerarCodigoEmprestimo(int codigo) {
        return String.format("E%03d", codigo); // Formato "E001", "E002", etc.
    }

    // Métodos Getters
    public String getIdEmprestimo() { return idEmprestimo; }
    public int getUsuario() { return idusuario; }
    public int  getLivro() { return idlivro; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public boolean isDevolvido() { return devolvido; }
    public List<UsuarioModel> getReservas() { return reservas; }

    // Método para devolver o empréstimo
    public void devolverEmprestimo() {
        this.devolvido = true;
        System.out.println("Empréstimo devolvido com sucesso!");
        notificarReservas();
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
        System.out.println("Título do Livro: " + livro.getTitulo());
        System.out.println("Data de Empréstimo: " + dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data de Devolução: " + dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Status: " + (devolvido ? "Devolvido" : "Não devolvido"));
    }

    // Método para reservar o livro
    public void reservar(UsuarioModel usuarioReserva) {
        if (devolvido) {
            System.out.println("O livro já está disponível para empréstimo.");
        } else {
            reservas.add(usuarioReserva);
            System.out.println("Usuário " + usuarioReserva.getNome() + " reservado o livro " + livro.getTitulo() + " com sucesso.");
        }
    }

    // Método para notificar reservas
    private void notificarReservas() {
        if (!reservas.isEmpty()) {
            for (UsuarioModel usuarioReserva : reservas) {
                System.out.println("Notificação: O livro " + livro.getTitulo() + " foi devolvido e está disponível para empréstimo.");
            }
            reservas.clear();
        }
    }

    // Método para definir nova data de devolução
    public void setDataDevolucao(LocalDate novaDevolucao) {
        this.dataDevolucao = novaDevolucao;
    }
}
