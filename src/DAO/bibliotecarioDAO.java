/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

public class bibliotecarioDAO {
    Connection conexao;
    public bibliotecarioDAO(){
        conexao = new Conexao().getConexao();        
    }    
    
       
    //inserir os dados de uma pessoa no mysql
    public void inserirBliotecario(Model.BibliotecarioModel b){
        try{
            String sql = "insert into usuario (idusuario, cpf, dataNascimento, sexo, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep,codigoBibliotecario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setInt(1, b.getIdusuario());            
            ps.setString(2, b.getCpf());
            ps.setString(3, b.getDataNascimento());
            ps.setString(4, b.getSexo());
            ps.setString(5, b.getNome());
            ps.setString(6, b.getEmail());
            ps.setString(7, b.getSenha());
            ps.setString(8, b.getLogradouro());
            ps.setString(9, b.getNumero());
            ps.setString(10, b.getComplemento());
            ps.setString(11, b.getBairro());
            ps.setString(12, b.getUf());
            ps.setString(13, b.getCidade());
            ps.setString(14, b.getCep());
            ps.setString(15, b.getCodigoBibliotecario());
            ps.executeUpdate();    //mandando para o banco
            
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
    
    
}
