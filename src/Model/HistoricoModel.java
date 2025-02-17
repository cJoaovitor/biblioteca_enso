package Model;

import DAO.EmprestimoDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class HistoricoModel {
    private int idUsuario;
    private int idhistorico;
    private int idempretimo;

    // Construtor com ID do usuário
    public HistoricoModel(int idUsuario) {
        this.idUsuario = idUsuario;
        this.idempretimo = idempretimo;
    }

    HistoricoModel(String codigoUsuario, Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

    // Método para registrar um empréstimo
    public void registrarEmprestimo(EmprestimoModel emprestimo) {
        if (emprestimo != null) {
            DAO.EmprestimoDAO e = new EmprestimoDAO ();
            e.inserirEmprestimo(emprestimo);
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

    List<EmprestimoModel> getEmprestimos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
