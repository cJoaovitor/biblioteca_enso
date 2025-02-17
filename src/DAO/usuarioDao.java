/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;

public class usuarioDao {
    Connection conexao;
    public usuarioDao(){
        conexao = new Conexao().getConexao();        
    }    
    
       
    //inserir os dados de uma pessoa no mysql
    public void inserirUsuario(Model.UsuarioModel u){
        try{
            String sql = "insert into usuario (idusuario, cpf, dataNascimento, sexo, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setInt(1, u.getIdusuario());            
            ps.setString(2, u.getCpf());
            ps.setString(3, u.getDataNascimento());
            ps.setString(4, u.getSexo());
            ps.setString(5, u.getNome());
            ps.setString(6, u.getEmail());
            ps.setString(7, u.getSenha());
            ps.setString(8, u.getLogradouro());
            ps.setString(9, u.getNumero());
            ps.setString(10, u.getComplemento());
            ps.setString(11, u.getBairro());
            ps.setString(12, u.getUf());
            ps.setString(13, u.getCidade());
            ps.setString(14, u.getCep());
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

