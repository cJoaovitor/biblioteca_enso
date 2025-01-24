package biblioteca;

import java.util.ArrayList;

public class Historico {
    private int idUsuario;
    private ArrayList<Emprestimo> emprestimos;

    // Construtor com ID do usuário
    public Historico(int idUsuario) {
        this.idUsuario = idUsuario;
        this.emprestimos = new ArrayList<>();
    }

    // Método para registrar um empréstimo
    public void registrarEmprestimo(Emprestimo emprestimo) {
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

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
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
            for (Emprestimo emprestimo : emprestimos) {
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
            for (Emprestimo emprestimo : emprestimos) {
                emprestimo.exibirEmprestimo();
            }
        }
    }

    // Método para renovar um empréstimo
    public void renovarEmprestimo(int indice) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.get(indice).renovarEmprestimo();
            System.out.println("Empréstimo renovado com sucesso!");
        } else {
            System.out.println("Erro: Índice de empréstimo inválido.");
        }
    }
}
