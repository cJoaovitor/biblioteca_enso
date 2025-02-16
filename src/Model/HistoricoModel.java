package Model;

import java.util.ArrayList;

public class HistoricoModel {
    private int idUsuario;
    private int idhistorico;
    private int idempretimo;

    // Construtor com ID do usuário
    public HistoricoModel(int idUsuario, int idempretimo) {
        this.idUsuario = idUsuario;
        this.idempretimo = idempretimo;
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
    
    public int getIdhistorico() {
        return idhistorico;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdempretimo() {
        return idempretimo;
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
