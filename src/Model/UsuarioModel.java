package Model;

import static Dados.Dados.gerarCodigoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioModel {
    private int CodigoUsuario;
    private String cpf;
    private String dataNascimento;
    private String sexo;
    private String nome;
    private String email;
    private String senha;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String uf;
    private String cidade;
    private String cep;
    private HistoricoModel historicoEmprestimos;

    public UsuarioModel(int CodigoUsuario, String cpf, String nome, String email, String senha,
                        String logradouro, String numero, String complemento,
                        String bairro, String uf, String cidade, String cep) {
        this.CodigoUsuario = CodigoUsuario;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.uf = uf;
        this.cidade = cidade;
        this.cep = cep;
        this.historicoEmprestimos = new HistoricoModel(CodigoUsuario);
    }

    public int getCodigoUsuario() {
        return CodigoUsuario;
    }

    public void setCodigoUsuario(int CodigoUsuario) {
        this.CodigoUsuario = CodigoUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public HistoricoModel getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public void setHistoricoEmprestimos(HistoricoModel historicoEmprestimos) {
        this.historicoEmprestimos = historicoEmprestimos;
    }

    

    public static UsuarioModel buscarUsuarioPorCPF(String cpf, Connection connection) {
        String sql = "SELECT * FROM usuarios WHERE cpf = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cpf);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int idusuario = resultSet.getInt("idusuario");
                    String nome = resultSet.getString("nome");
                    String email = resultSet.getString("email");
                    String senha = resultSet.getString("senha");
                    String logradouro = resultSet.getString("logradouro");
                    String numero = resultSet.getString("numero");
                    String complemento = resultSet.getString("complemento");
                    String bairro = resultSet.getString("bairro");
                    String uf = resultSet.getString("uf");
                    String cidade = resultSet.getString("cidade");
                    String cep = resultSet.getString("cep");
                    return new UsuarioModel(idusuario, cpf, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<EmprestimoModel> getEmprestimos(Connection connection) {
        List<EmprestimoModel> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM emprestimos WHERE idusuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, CodigoUsuario);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int idemprestimo = resultSet.getInt("idemprestimo");
                    int idlivro = resultSet.getInt("idlivro");
                    String dataDevolucao = resultSet.getString("dataDevolucao");
                    boolean devolvido = resultSet.getBoolean("devolvido");
                    EmprestimoModel emprestimo = new EmprestimoModel(idemprestimo, this, idlivro, dataDevolucao, devolvido);
                    emprestimos.add(emprestimo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimos;
    }
}