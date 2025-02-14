package Model;

import java.util.ArrayList;

public class HistoricoModel {
    private int idUsuario;
    private ArrayList<EmprestimoModel> emprestimos;

    // Construtor com ID do usuário
    public HistoricoModel(int idUsuario) {
        this.idUsuario = idUsuario;
        this.emprestimos = new ArrayList<>();
    }

    HistoricoModel(String idusuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Método para registrar um empréstimo
    public void registrarEmprestimo(EmprestimoModel emprestimo) {
        if (emprestimo != null) {
            emprestimos.add(emprestimo);
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Erro: O empréstimo é inválido.");
        }
    }

    // Getters e Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<EmprestimoModel> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<EmprestimoModel> emprestimos) {
        this.emprestimos = emprestimos;
    }

    // Método para contar o número de empréstimos
    public int contarEmprestimos() {
        return emprestimos.size();
    }

    // Exibir histórico de empréstimos do usuário
    public void exibirHistoricoDeEmprestimo() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado para este usuário.");
        } else {
            System.out.println("Histórico de Empréstimos do Usuário ID " + idUsuario + ":");
            for (EmprestimoModel emprestimo : emprestimos) {
                emprestimo.exibirEmprestimo(); // Chama o método para exibir detalhes do empréstimo
            }
        }
    }

    // Exibir histórico completo do usuário
    public void exibirHistoricoCompleto() {
        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado para este usuário.");
        } else {
            System.out.println("Exibindo histórico completo do Usuário ID: " + idUsuario);
            for (EmprestimoModel emprestimo : emprestimos) {
                emprestimo.exibirEmprestimo();
            }
        }
    }

}
