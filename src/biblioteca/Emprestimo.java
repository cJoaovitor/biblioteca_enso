
package biblioteca;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Emprestimo {
    private int idEmprestimo;
    private int idUsuario;
    private int idLivro;
    private String dataEmprestimo;
    private String dataDevolucao;
    private Livro livroemprestado;
    private boolean devolvido;
    

     public Emprestimo(int idEmprestimo, int idUsuario, int idLivro, String dataEmprestimo, String dataDevolucao, boolean devolvido, Livro l) {
        this.idEmprestimo = idEmprestimo;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
        livroemprestado = l;
     }


    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public void devolverEmprestimo() {
        this.devolvido = true;
        System.out.println("Empréstimo realizado com sucesso!");
    }

    public void registrarEmprestimo(int usuarioId, int livroId) {
        this.idUsuario = usuarioId;
        this.idLivro = livroId;
        this.dataEmprestimo = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.dataDevolucao = LocalDate.now().plusDays(14).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.devolvido = false;
        System.out.println("Empréstimo registrado com sucesso!");
    }

    public void atualizarStatus() {
        if (!devolvido) {
            this.devolvido = true;
            System.out.println("Status atualizado para devolvido.");
        } else {
            System.out.println("O livro já foi devolvido.");
        }
    }

    public void renovarEmprestimo() {
        LocalDate novaDataDevolucao = LocalDate.parse(dataDevolucao, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(7);
        this.dataDevolucao = novaDataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Empréstimo renovado. Nova data de devolução: " + dataDevolucao);
    }

    public float calcularMulta(int diasAtraso) {
        float multaPorDia = 1.5f; // Exemplo: R$ 1,50 por dia de atraso
        float multa = diasAtraso * multaPorDia;
        System.out.println("Multa calculada: R$ " + multa);
        return multa;
    }

    public void exibirEmprestimo() {
        System.out.println("=== Informações do Empréstimo ===");
        System.out.println("Empréstimo Id: " + idEmprestimo);
        System.out.println("Usuário Id: " + idUsuario);
        System.out.println("Livro Id: " + idLivro);
        System.out.println("Data de Empréstimo: " + dataEmprestimo);
        System.out.println("Data de Devolução: " + dataDevolucao);
        System.out.println("Status: " + (devolvido ? "Devolvido" : "Não devolvido"));
    }
}
