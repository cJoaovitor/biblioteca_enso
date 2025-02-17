package Model;

<<<<<<< HEAD
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
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Dados.Dados;
import java.time.LocalDate;

public class UsuarioModel {

    public static UsuarioModel buscarUsuarioPorCPF(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    protected int idusuario;
    protected String cpf;
    protected String dataNascimento;
    protected String sexo;
    protected String nome;
    protected String email;
    protected String senha;
    protected String logradouro;
    protected String numero;
    protected String complemento;
    protected String bairro;
    protected String uf;
    protected String cidade;
    protected String cep;
    protected HistoricoModel historicoEmprestimos;
     String dataDevolucao;

    public UsuarioModel(int idusuario, String cpf, String nome, String email, String senha, 
                        String logradouro, String numero, String complemento, 
                        String bairro, String uf, String cidade, String cep) {
        this.idusuario = idusuario;
>>>>>>> 1bc9f95fd7609a92086d0c81cb7abfdc18f6face
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
<<<<<<< HEAD
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
=======
        this.historicoEmprestimos = new HistoricoModel(idusuario);
    }
    
     public String getDataDevolucao() {
       
        return dataDevolucao; // Método para obter a data de devolução
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao; // Método para atualizar a data de devolução
    }

    // Getters e Setters
    public int getIdusuario() { return idusuario; }
    public void setIdusuario( int idusuario) { this.idusuario = idusuario; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
    public HistoricoModel getHistoricoEmprestimos() { return historicoEmprestimos; }
    public void setHistoricoEmprestimos(HistoricoModel historicoEmprestimos) { this.historicoEmprestimos = historicoEmprestimos; }

    // vou colacar as funçoes de exblir pelo banco

    public void editarDadosUsuario(int posicaoUsuario) {
        try {
            UsuarioModel usuario = Dados.getUsuarios().get(posicaoUsuario);
            if (usuario == null) {
                System.out.println("Usuário não encontrado.");
                return;
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite o novo nome (deixe em branco para não alterar): ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo email (deixe em branco para não alterar): ");
            String novoEmail = scanner.nextLine();
            System.out.print("Digite a nova senha (deixe em branco para não alterar): ");
            String novaSenha = scanner.nextLine();
            System.out.print("Digite o novo logradouro (deixe em branco para não alterar): ");
            String novoLogradouro = scanner.nextLine();
            System.out.print("Digite o novo número (deixe em branco para não alterar): ");
            String novoNumero = scanner.nextLine();
            System.out.print("Digite o novo complemento (deixe em branco para não alterar): ");
            String novoComplemento = scanner.nextLine();
            System.out.print("Digite o novo bairro (deixe em branco para não alterar): ");
            String novoBairro = scanner.nextLine();
            System.out.print("Digite a nova UF (deixe em branco para não alterar): ");
            String novoUf = scanner.nextLine();
            System.out.print("Digite a nova cidade (deixe em branco para não alterar): ");
            String novaCidade = scanner.nextLine();
            System.out.print("Digite o novo CEP (deixe em branco para não alterar): ");
            String novoCep = scanner.nextLine();

            usuario.editarDados(
                novoNome.isEmpty() ? null : novoNome,
                novoEmail.isEmpty() ? null : novoEmail,
                novaSenha.isEmpty() ? null : novaSenha,
                novoLogradouro.isEmpty() ? null : novoLogradouro,
                novoNumero.isEmpty() ? null : novoNumero,
                novoComplemento.isEmpty() ? null : novoComplemento,
                novoBairro.isEmpty() ? null : novoBairro,
                novoUf.isEmpty() ? null : novoUf,
                novaCidade.isEmpty() ? null : novaCidade,
                novoCep.isEmpty() ? null : novoCep
            );
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro: Posição do usuário inválida.");
        } catch (Exception e) {
            System.out.println("Erro ao editar dados: " + e.getMessage());
        }
    }

    public void editarDados(String novoNome, String novoEmail, String novaSenha, String novoLogradouro, 
                            String novoNumero, String novoComplemento, String novoBairro, 
                            String novoUf, String novaCidade, String novoCep) {
        if (novoNome != null) this.nome = novoNome;
        if (novoEmail != null) this.email = novoEmail;
        if (novaSenha != null) this.senha = novaSenha;
        if (novoLogradouro != null) this.logradouro = novoLogradouro;
        if (novoNumero != null) this.numero = novoNumero;
        if (novoComplemento != null) this.complemento = novoComplemento;
        if (novoBairro != null) this.bairro = novoBairro;
        if (novoUf != null) this.uf = novoUf;
        if (novaCidade != null) this.cidade = novaCidade;
        if (novoCep != null) this.cep = novoCep;
    }

    public void registrarEmprestimo(EmprestimoModel novoEmprestimo) {
        if (novoEmprestimo != null) {
            historicoEmprestimos.registrarEmprestimo(novoEmprestimo);
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Erro ao registrar o empréstimo.");
        }
    }

    public void exibirDados() {
        System.out.println("=== Dados do Usuário ===");
        System.out.println("ID: " + idusuario);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("CPF: " + cpf);
        System.out.println("Logradouro: " + logradouro);
        System.out.println("Número: " + numero);
        System.out.println("Complemento: " + complemento);
        System.out.println("Bairro: " + bairro);
        System.out.println("UF: " + uf);
        System.out.println("Cidade: " + cidade);
        System.out.println("CEP: " + cep);
    }
  /* outa função que ser feita pelo banco 
    public List<EmprestimoModel> getEmprestimos() {
        return historicoEmprestimos.getEmprestimos();
    }
 
    public List<LivroModel> getLivrosEmprestados() {
        List<LivroModel> livrosEmprestados = new ArrayList<>();
        for (EmprestimoModel emprestimo : historicoEmprestimos.getEmprestimos()) {
            livrosEmprestados.add(Dados.getLivro(EmprestimoModel.getLivro()));
        }
        return livrosEmprestados;
    }

   public void adicionarLivroEmprestado(LivroModel livro) {
    if (livro != null) {
        // Cria um novo empréstimo com o usuário atual e o livro
        EmprestimoModel novoEmprestimo = new EmprestimoModel(this, livro);
        historicoEmprestimos.registrarEmprestimo(novoEmprestimo);
        System.out.println("Livro adicionado aos empréstimos.");
    } else {
        System.out.println("Erro ao adicionar livro: livro nulo.");
    }
}


    public void removerLivroEmprestado(LivroModel livro) {
        if (livro != null) {
            List<EmprestimoModel> emprestimos = historicoEmprestimos.getEmprestimos();
            
            // Verifica se o livro está presente nos empréstimos
            boolean livroRemovido = emprestimos.removeIf(emp -> emp.getLivro().getIdLivro().equals(livro.getIdLivro()) && !emp.isDevolvido());
            
            if (livroRemovido) {
                System.out.println("Livro removido dos empréstimos.");
            } else {
                System.out.println("Livro não encontrado nos empréstimos ou já foi devolvido.");
            }
        } else {
            System.out.println("Erro ao remover livro: livro nulo.");
        }
    }

    public String getCodigo() {
        return idusuario;
    }

   

    public void setDataDevolucao(LocalDate novaDevolucao) {
        List<EmprestimoModel> emprestimos = historicoEmprestimos.getEmprestimos();
        if (!emprestimos.isEmpty()) {
            emprestimos.get(emprestimos.size() - 1).setDataDevolucao(novaDevolucao);
            System.out.println("Data de devolução atualizada.");
        } else {
            System.out.println("Nenhum empréstimo encontrado para atualizar a data de devolução.");
        }
    }

   */
    
}
>>>>>>> 1bc9f95fd7609a92086d0c81cb7abfdc18f6face
