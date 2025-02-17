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

public class ReservaDAO {
    Connection conexao;
    public ReservaDAO(){
        conexao = new Conexao().getConexao();        
    }    
    
       
    //inserir os dados de uma pessoa no mysql
    public void inserirReserva(Model.ReservaModel r){
        try{
           String sql = "INSERT INTO reserva (tituloLivro, nomeUsuario, datadevolucao, idlivrosfk, idusuariofk) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, r.getTituloLivro());
        ps.setString(2, r.getNomeUsuario());
        ps.setString(3, r.getDataDevolucao().toString());
        ps.setInt(4, r.getCodLivro());
        ps.setInt(5, r.getCodUsuario());
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
    
    
}


