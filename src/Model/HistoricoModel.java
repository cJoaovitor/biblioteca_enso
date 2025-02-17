package Model;

import DAO.EmprestimoDAO;
<<<<<<< HEAD
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
=======
import java.util.ArrayList;
>>>>>>> 1bc9f95fd7609a92086d0c81cb7abfdc18f6face

public class HistoricoModel {
    private int idUsuario;
    private int idhistorico;
    private int idempretimo;

    // Construtor com ID do usuário
    public HistoricoModel(int idUsuario) {
        this.idUsuario = idUsuario;
        this.idempretimo = idempretimo;
    }

<<<<<<< HEAD
    HistoricoModel(String codigoUsuario, Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

=======
>>>>>>> 1bc9f95fd7609a92086d0c81cb7abfdc18f6face
   

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

<<<<<<< HEAD
    List<EmprestimoModel> getEmprestimos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

=======
>>>>>>> 1bc9f95fd7609a92086d0c81cb7abfdc18f6face
}
