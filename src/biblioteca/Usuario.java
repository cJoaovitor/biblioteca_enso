package biblioteca;

import java.util.ArrayList;

public class Usuario {
    protected int idusuario;
    protected String cpf;
    protected String nome;
    protected String email;
    protected String senha;
    protected Historico historicoEmprestimos;

    // Construtor da classe Usuario
    public Usuario(int idusuario, String cpf, String nome, String email, String senha) {
        this(cpf, nome, email, senha);
    }

    // Construtor da classe Usuario
    public Usuario(String cpf, String nome, String email, String senha) {
        this.idusuario = idusuario;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.historicoEmprestimos = new Historico(idusuario); // Passa o ID do usuário ao criar o histórico
    }

    // Métodos getters
    public int getIdusuario() {
        return idusuario;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    // Método para visualizar o histórico de empréstimos
    public void visualizarHistorico() {
        ArrayList<Emprestimo> emprestimos = historicoEmprestimos.getEmprestimos();

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum histórico de empréstimos encontrado.");
        } else {
            System.out.println("=== Histórico de Empréstimos ===");
            for (Emprestimo emprestimo : emprestimos) {
                emprestimo.exibirEmprestimo(); // Exibe detalhes do empréstimo
            }
        }
    }

    // Método para editar os dados do usuário
    public void editarDados(String novoNome, String novoEmail, String novaSenha) {
        boolean atualizado = false;

        if (novoNome != null && !novoNome.trim().isEmpty()) {
            this.nome = novoNome;
            atualizado = true;
        } else {
            System.out.println("Nome não pode ser vazio.");
        }

        if (novoEmail != null && !novoEmail.trim().isEmpty()) {
            this.email = novoEmail;
            atualizado = true;
        } else {
            System.out.println("Email não pode ser vazio.");
        }

        if (novaSenha != null && !novaSenha.trim().isEmpty()) {
            this.senha = novaSenha;
            atualizado = true;
        } else {
            System.out.println("Senha não pode ser vazia.");
        }

        if (atualizado) {
            System.out.println("Dados do usuário atualizados com sucesso!");
        }
    }

    // Método para registrar um novo empréstimo
    public void registrarEmprestimo(Emprestimo novoEmprestimo) {
        if (novoEmprestimo != null) {
            historicoEmprestimos.registrarEmprestimo(novoEmprestimo);
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Erro ao registrar o empréstimo.");
        }
    }

    // Método para exibir dados do usuário
    public void exibirDados() {
        System.out.println("=== Dados do Usuário ===");
        System.out.println("ID: " + idusuario);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("CPF: " + cpf);
        // Não exibir a senha por questões de segurança
    }
}
