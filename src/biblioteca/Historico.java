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
 public int calcularHistoricos() {
 return emprestimos.size();
 }
 public void exibirHistoricoDeEmprestimo() {
 if (emprestimos.isEmpty()) {
 System.out.println("Nenhum empréstimo registrado para este usuário.");
 } else {
 System.out.println("Histórico de Empréstimos do Usuário " + idUsuario + ":");
 for (Emprestimo emprestimo : emprestimos) {
 System.out.println(emprestimo);
 }
 }
 }
 public int exibirHistoricoCompleto() {
 System.out.println("Exibindo histórico completo:");
 for (int i = 0 ; i< emprestimos.size() ; i++) {
 System.out.println("Usuário ID: " + idUsuario + ", Empréstimo:");
 emprestimos.get(i).exibirEmprestimo();
 return i;
 }
 return 0;
 }
 void renovar(int i){
     emprestimos.get(i).renovarEmprestimo();
 }
}