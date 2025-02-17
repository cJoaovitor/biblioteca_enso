package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    
    public List<Model.LivroModel> consultarTodosLivros() {
    List<Model.LivroModel> livros = new ArrayList<>();
    try {
        String sql = "SELECT * FROM biblioteca.livro;";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Model.LivroModel livro = new Model.LivroModel();
            livro.setIdLivro(rs.getInt("id"));
            livro.setCodigo(rs.getString("codigo"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setAutor(rs.getString("autor"));
            livro.setGenero(rs.getString("genero"));
            livro.setDescricao(rs.getString("descricao"));
            livro.setAnoPublicacao(rs.getString("anoPublicacao"));
            livro.setEditora(rs.getString("editora"));
            livro.setDisponivel(rs.getBoolean("disponivel"));
            livro.setEmprestado(rs.getBoolean("emprestado"));
            livro.setStatus(rs.getString("livro_status"));
            livros.add(livro);
        }
    } catch (SQLException e) {
        System.out.println("Erro ao consultar livros: " + e.getMessage());
    }
    return livros;
}

    
    
}
