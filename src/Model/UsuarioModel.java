package Model;

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
    protected String codigo;
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
        this.codigo = "USR"+idusuario;
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

    public String getCodigo() {
        return codigo;
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
