/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author jao
 */
import java.sql.*;

public class Conexao {
    static Connection connection = null;
    String url = "jdbc:mysql://localhost:3306/aula";
    String user = "root";
    String password = "root";

    public Conexao() {
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexao realizada com sucesso");
        } catch (SQLException e) {
            System.out.println("Problema na conexao: " + e.getMessage());
        }
    }

    public static Connection getConexao() {
        return connection;
    }
}
