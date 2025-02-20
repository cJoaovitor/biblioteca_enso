/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;




import Model.EmprestimoModel;
import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmprestimoDAO {
    Connection conexao;
    public EmprestimoDAO(){
        conexao = new Conexao().getConexao();        
    }    
    
       
    //inserir os dados de uma pessoa no mysql
    public void inserirEmprestimo(Model.EmprestimoModel E) {
    try {
        String sql = "INSERT INTO emprestimo (id_usuario, id_livro, data_emprestimo, data_devolucao, qtd_renovacoes, devolvido) VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, E.getIdUsuario());
        ps.setInt(2, E.getLivro());
        ps.setDate(3, java.sql.Date.valueOf(E.getDataEmprestimo())); // Converte LocalDate para Date
        ps.setDate(4, java.sql.Date.valueOf(E.getDataDevolucao()));
        ps.setInt(5, E.getQuantderenovar());
        ps.setBoolean(6, E.getDevolvido());
        
        ps.executeUpdate();
        System.out.println("\nEmpréstimo inserido com sucesso!");
                           
    } catch (SQLException e) {
        System.out.println("Erro ao inserir empréstimo: " + e.getMessage());
    }
}

    public void consultarTudo(){
        
        try {
            String sql="select * from pessoa;";
            PreparedStatement sttmt=conexao.prepareStatement(sql);
            ResultSet rst=sttmt.executeQuery();
            while(rst.next()){
                String n = rst.getString("nome");
                int i = rst.getInt("id");
                System.out.println("Dados do banco: "+n+" "+i);
            }
        } catch (SQLException ex) {
            System.out.println("Erro na consulta de pessoa: "+ex);
        }
    }
  public void atualizarDataDevolucao(int idUsuario, int idLivro) {
    try {
        String sql = "UPDATE emprestimo SET data_devolucao = DATE_ADD(data_emprestimo, INTERVAL 7 DAY) " +
                     "WHERE id_usuario = ? AND id_livro = ?";

        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ps.setInt(2, idLivro);

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Data de devolução atualizada com sucesso!");
        } else {
            System.out.println("Nenhum empréstimo encontrado com os dados fornecidos.");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao atualizar a data de devolução: " + e.getMessage());
    }
}
public Model.EmprestimoModel buscarEmprestimo(int idUsuario, int idLivro) {
    Model.EmprestimoModel emprestimo = null;

    try {
        String sql = "SELECT * FROM emprestimo WHERE id_usuario = ? AND id_livro = ? AND devolvido = false";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ps.setInt(2, idLivro);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            emprestimo = new EmprestimoModel(
                rs.getInt("id_emprestimo"),
                rs.getInt("id_usuario"),
                rs.getInt("id_livro"),
                rs.getDate("data_emprestimo").toLocalDate(),
                rs.getDate("data_devolucao").toLocalDate(),
                rs.getInt("qtd_renovacoes"),
                rs.getBoolean("devolvido")
            );
        }
    } catch (SQLException e) {
        System.out.println("Erro ao buscar empréstimo: " + e.getMessage());
    }

    return emprestimo;
}

    
}
