/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LivroDAO {
    Connection conexao;
    public LivroDAO(){
        conexao = new Conexao().getConexao();        
    }    
    
       
    //inserir os dados de uma pessoa no mysql
    public void inserirLivro(Model.LivroModel l){
        try{
           String sql = "INSERT INTO livro (id,codigo, titulo, autor, genero, descricao, anoPublicacao, editora, disponivel, emprestado, livro_status) VALUES (?<?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, l.getIdLivro());
            ps.setString(2, l.getCodigo());
            ps.setString(3, l.getAutor());
            ps.setString(4, l.getGenero());
            ps.setString(5, l.getDescricao());
            ps.setString(6, l.getAnoPublicacao());
            ps.setString(7, l.getEditora());
            ps.setBoolean(8, l.getDisponivel());
            ps.setBoolean(9, l.getEmprestado());
            ps.setString(10, l.getStatus());
            ps.executeUpdate();

            System.out.println("\n Pessoa inserida com sucesso");
                           
        }catch(Exception e){
          System.out.println("Erro: "+e);

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
        public Model.LivroModel buscarLivroPorCodigo(String codigo) {
    Model.LivroModel livro = null;

    try {
        String sql = "SELECT * FROM livro WHERE codigo = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, codigo);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            livro = new Model.LivroModel(
                rs.getInt("idlivro"),
                rs.getString("titulo"),
                rs.getString("autor"),
                rs.getString("genero"),
                rs.getString("descricao"),
                rs.getString("anoPublicacao"),
                rs.getString("editora"),
                rs.getString("livro_status")
            );
        }

    } catch (SQLException e) {
        System.out.println("Erro na consulta do livro: " + e);
    }

    return livro;
}

    
}
