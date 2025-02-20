/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

public class AdministradorDAO {
    Connection conexao;
    public AdministradorDAO(){
        conexao = new Conexao().getConexao();        
    }    
    
       
    //inserir os dados de uma pessoa no mysql
    public void inserirAdm(Model.AdministradorModel a){
        try{
            String sql = "insert into usuario (idusuario, cpf, dataNascimento, sexo, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep,codigoAdministrador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);";
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setInt(1, a.getIdusuario());            
            ps.setString(2, a.getCpf());
            ps.setString(3, a.getDataNascimento());
            ps.setString(4, a.getSexo());
            ps.setString(5, a.getNome());
            ps.setString(6, a.getEmail());
            ps.setString(7, a.getSenha());
            ps.setString(8, a.getLogradouro());
            ps.setString(9, a.getNumero());
            ps.setString(10, a.getComplemento());
            ps.setString(11, a.getBairro());
            ps.setString(12, a.getUf());
            ps.setString(13, a.getCidade());
            ps.setString(14, a.getCep());
            ps.setString(15, a.getCodigoAdministrador());
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
    public int buscarIdUsuarioPorCpf(String cpf) {
    int idUsuario = -1; // Valor padrão caso não encontre

    try {
        String sql = "SELECT idusuario FROM usuario WHERE cpf = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, cpf);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            idUsuario = rs.getInt("idusuario");
        }

    } catch (SQLException e) {
        System.out.println("Erro na consulta: " + e);
    }

    return idUsuario;
}

    }
    

