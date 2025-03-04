/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Dados.Dados;
import Model.UsuarioModel;
import java.sql.*;
import java.util.ArrayList;

public class usuarioDao {
    Connection conexao;
    public usuarioDao(){
        conexao = new Conexao().getConexao();        
    }    
    
       
    //inserir os dados de uma pessoa no mysql
    public void inserirUsuario(Model.UsuarioModel u){
        try{
            String sql = "insert into usuario (idusuario, CodigoUsuario cpf, dataNascimento, sexo, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conexao.prepareStatement(sql);
           
            ps.setInt(1, u.getIdusuario());   
            ps.setString(2, u.getCodigo());
            ps.setString(3, u.getCpf());
            ps.setString(4, u.getDataNascimento());
            ps.setString(5, u.getSexo());
            ps.setString(6, u.getNome());
            ps.setString(7, u.getEmail());
            ps.setString(8, u.getSenha());
            ps.setString(9, u.getLogradouro());
            ps.setString(10, u.getNumero());
            ps.setString(11, u.getComplemento());
            ps.setString(12, u.getBairro());
            ps.setString(13, u.getUf());
            ps.setString(14, u.getCidade());
            ps.setString(15, u.getCep());
            ps.executeUpdate();    //mandando para o banco
            
            System.out.println("\n Pessoa inserida com sucesso");
                           
        }catch(Exception e){
          System.out.println("Erro: "+e);

        }
    }
    // Atualiza o CPF
public void atualizarCpf(String novoCpf) {
    try {
        String sql = "UPDATE usuario SET cpf = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoCpf);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("CPF atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar CPF: " + ex);
    }
}

// Atualiza a Data de Nascimento
public void atualizarDataNascimento(String novaDataNascimento) {
    try {
        String sql = "UPDATE usuario SET dataNascimento = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novaDataNascimento);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Data de Nascimento atualizada com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Data de Nascimento: " + ex);
    }
}

// Atualiza o Sexo
public void atualizarSexo(String novoSexo) {
    try {
        String sql = "UPDATE usuario SET sexo = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoSexo);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Sexo atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Sexo: " + ex);
    }
}

// Atualiza o Nome
public void atualizarNome(String novoNome) {
    try {
        String sql = "UPDATE usuario SET nome = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoNome);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Nome atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Nome: " + ex);
    }
}

// Atualiza o Email
public void atualizarEmail(String novoEmail) {
    try {
        String sql = "UPDATE usuario SET email = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoEmail);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Email atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Email: " + ex);
    }
}

// Atualiza a Senha
public void atualizarSenha(String novaSenha) {
    try {
        String sql = "UPDATE usuario SET senha = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novaSenha);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Senha atualizada com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Senha: " + ex);
    }
}

// Atualiza o Logradouro
public void atualizarLogradouro(String novoLogradouro) {
    try {
        String sql = "UPDATE usuario SET logradouro = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoLogradouro);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Logradouro atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Logradouro: " + ex);
    }
}

// Atualiza o Número
public void atualizarNumero(String novoNumero) {
    try {
        String sql = "UPDATE usuario SET numero = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoNumero);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Número atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Número: " + ex);
    }
}

// Atualiza o Complemento
public void atualizarComplemento(String novoComplemento) {
    try {
        String sql = "UPDATE usuario SET complemento = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoComplemento);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Complemento atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Complemento: " + ex);
    }
}

// Atualiza o Bairro
public void atualizarBairro(String novoBairro) {
    try {
        String sql = "UPDATE usuario SET bairro = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoBairro);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Bairro atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Bairro: " + ex);
    }
}

// Atualiza o UF
public void atualizarUf(String novoUf) {
    try {
        String sql = "UPDATE usuario SET uf = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoUf);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("UF atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar UF: " + ex);
    }
}

// Atualiza a Cidade
public void atualizarCidade(String novaCidade) {
    try {
        String sql = "UPDATE usuario SET cidade = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novaCidade);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("Cidade atualizada com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar Cidade: " + ex);
    }
}

// Atualiza o CEP
public void atualizarCep(String novoCep) {
    try {
        String sql = "UPDATE usuario SET cep = ? WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, novoCep);
        ps.setInt(2, Dados.getPosicaoUsuario());
        ps.executeUpdate();
        System.out.println("CEP atualizado com sucesso.");
    } catch (SQLException ex) {
        System.out.println("Erro ao atualizar CEP: " + ex);
    }
}
public Model.UsuarioModel buscarUsuarioPorCodigo(String codigo) {
    Model.UsuarioModel usuario = null;

    try {
        // Consulta SQL buscando pelo código
        String sql = "SELECT * FROM usuario WHERE codigo = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, codigo);  // Define o código como parâmetro da consulta

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Preenche o objeto UsuarioModel com os dados do banco
            usuario = new Model.UsuarioModel(
                rs.getInt("idusuario"),
                rs.getString("cpf"),
                rs.getString("nome"),
                rs.getString("email"),
                rs.getString("senha"),
                rs.getString("logradouro"),
                rs.getString("numero"),
                rs.getString("complemento"),
                rs.getString("bairro"),
                rs.getString("uf"),
                rs.getString("cidade"),
                rs.getString("cep")
            );
        }

    } catch (SQLException e) {
        System.out.println("Erro na consulta do usuário: " + e);
    }

    return usuario;  // Retorna o usuário encontrado ou null
}
public  ArrayList <Model.UsuarioModel> consutartudo(){
    ArrayList<UsuarioModel> arayusuario = new ArrayList<>();    
   

    try {
        String sql = "SELECT * FROM usuario ";
        PreparedStatement ps = conexao.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int idusuario = rs.getInt("id_usuario");
            String cpf = rs.getString("cpf");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String senha = rs.getString("senha");
            String logradouro = rs.getString("logradouro");
            String numero = rs.getString("numero");
            String complemento = rs.getString("complemento");
            String bairro = rs.getString("bairro");
            String uf = rs.getString("uf");
            String cidade = rs.getString("cidade");
            String cep = rs.getString("cep");

            
            Model.UsuarioModel u = new UsuarioModel(idusuario, cpf, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep);
            
                                              
            arayusuario.add(u);
        }

    } catch (SQLException e) {
        System.out.println("Erro na consulta do bibliotecário: " + e);
    }

    return arayusuario ;
}
   public void removerUsuario(int idUsuario) {
    try {
        String sql = "DELETE FROM usuario WHERE idusuario = ?";
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, idUsuario);

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Usuário removido com sucesso.");
        } else {
            System.out.println("Nenhum usuário encontrado com esse ID.");
        }

    } catch (SQLException e) {
        System.out.println("Erro ao remover usuário: " + e.getMessage());
    }
}
 
}

