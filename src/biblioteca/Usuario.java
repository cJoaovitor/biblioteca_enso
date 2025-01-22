package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {

    protected int idusuario;
    protected String nome;
    private String cpf;
    protected String email;
    protected String senha;
    protected String StatusConta;
    protected Emprestimo enpresyimosAtivos;
    protected Historico historicoEmprestimos;
    Scanner cafe = new Scanner(System.in);
    Scanner cafeline = new Scanner(System.in);

    public Usuario(int idusuario, String cpf) {
        String axuSenha;
        System.out.println("nome:");
        nome = cafeline.nextLine();
        System.out.println("email:");
        email = cafe.next();
        System.out.println("senha:");
        axuSenha = cafe.next();
        this.cpf = cpf;
        System.out.println("comfirne a sua senha");
        senha = cafe.next();
        while (!senha.equals(axuSenha)) {
            System.out.println("comfirne a sua senha");
            senha = cafe.next();
        }
        StatusConta = "ativo";
        historicoEmprestimos = new Historico(this.idusuario);
    }

    public void EditarDados(String novonome, String novoemail, String novasenhar) {
        nome = novonome;
        email = novoemail;
        senha = novasenhar;
    }

    public void visualizarHistorico() {
        historicoEmprestimos.exibirHistoricoCompleto();
        /* isso vai ter o nome da funcao de exbição do historico */
    }

    String verificarStatusConta() {
        System.out.println("olá " + nome + " o status da sua conta e: " + StatusConta);
        return StatusConta;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public void recuperarSenha() {
        System.out.println("digite senha ");
        String axuSenha = cafe.next();
        System.out.println("comfirne a sua senha");
        senha = cafe.next();
        while (!senha.equals(axuSenha)) {
            System.out.println("comfirne a sua senha");
            senha = cafe.next();
        }
    }
    public void exibir (){
        System.out.println("nome:"+nome);
        System.out.println("id Usuario:"+idusuario);
        System.out.println("cpf"+cpf);
    }
}
