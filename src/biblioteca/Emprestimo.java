
package biblioteca;
import java.util.Date;
public class Emprestimo {
    private int idEmprestimo;
    private int idUsuario; // Referência ao usuário que fez o empréstimo
    private int idLivro;   // Referência ao livro emprestado
    private String dataEmprestimo; // Data em formato "dd/MM/yyyy"
    private String dataDevolucao;  // Data em formato "dd/MM/yyyy"
    private boolean devolvido;

    public Emprestimo(int idEmprestimo, int idUsuario, int idLivro, String dataEmprestimo, String dataDevolucao, boolean devolvido) {
        this.idEmprestimo = idEmprestimo;
        this.idUsuario = idUsuario;
        this.idLivro = idLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.devolvido = devolvido;
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
    
    public void Devolucao(){
        this.devolvido = true;
        System.out.println("Empréstimo realizado com sucesso!");
    }
    
    public void exibirEmprestimo(){
        
        System.out.println("=== Informações do Empréstimo ===");
        System.out.println("Empréstimo Id: "+idEmprestimo);
        System.out.println("Usuário Id: "+ idUsuario);
        System.out.println("Livro Id: "+idLivro);
        System.out.println("Data de Empréstimo: "+dataEmprestimo);
        System.out.println("Data de Devolução: "+dataDevolucao);
         if (devolvido) {
        System.out.println("Status: Devolvido");
    } else {
        System.out.println("Status: Não devolvido");
    }
}
}

  

