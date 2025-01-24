
package biblioteca;
import java.util.ArrayList;
public class Historico {
    private int idUsuario; 
    private ArrayList<Emprestimo> emprestimos; 
    
     public Historico(int idUsuario) {
        this.idUsuario = idUsuario;
        this.emprestimos = new ArrayList<>();
    }
      public void registrarEmprestimo(Emprestimo emprestimo) {
        if (emprestimo != null) {
            emprestimos.add(emprestimo);
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Erro: O empréstimo é inválido.");
        }
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }




       
}
