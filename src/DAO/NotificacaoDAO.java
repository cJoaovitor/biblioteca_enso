package DAO;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificacaoDAO {
    Connection conexao;

    public NotificacaoDAO() {
        conexao = new Conexao().getConexao();
    }

    
    public List<Noticacao> buscarNotificacoes(String emailUsuario) {
        List<Noticacao> notificacoes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM notificacoes WHERE email_usuario = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, emailUsuario);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Notificacao notificacao = new Notificacao();
                notificacao.setId(rs.getInt("id"));
                notificacao.setEmailUsuario(rs.getString("email_usuario"));
                notificacao.setDataEnvio(rs.getTimestamp("data_envio"));
                notificacao.setTipo(rs.getString("tipo"));
                notificacao.setMensagem(rs.getString("mensagem"));
                notificacao.setEmailDestinatario(rs.getString("email_destinatario"));
                notificacoes.add(notificacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta de notificações: " + e);
        }

        return notificacoes;
    }
}
