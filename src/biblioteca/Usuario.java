
package biblioteca;
import java.util.Scanner;

public class Usuario {
    protected int  idusuario;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    protected String StatusConta;
    protected Emprestimo enpresyimosAtivos;
    protected Historico historicoEmprestimos;

    public Usuario(int idusuario ) {
        String axuSenha;
        Scanner cafe = new Scanner (System.in);
        Scanner cafeline = new Scanner (System.in);
        System.out.println("olá usuario seja bem vindo a nossa biblioteca");
        System.out.println("para ragistar a sua conta por favor digite seu nome ");
        nome = cafeline.nextLine();
        System.out.println("digite o seu email");
        email = cafe.next();
        System.out.println("digite a sua senha ");
        axuSenha = cafe.next();
        System.out.println("comfirne a sua senha");
        senha=cafe.next();
        while (!senha.equals(axuSenha)){
        System.out.println("comfirne a sua senha");
        senha=cafe.next();
        }
        StatusConta="ativo";
        historicoEmprestimos = new Historico(this.idusuario);
    }
    public void EditarDados(String novonome, String novoemail, String novasenhar){
         nome = novonome;
         email = novoemail;
         senha = novasenhar;
    }
    public void visualizarHistorico(){
    historicoEmprestimos.exibirHistoricoCompleto();
    /* isso vai ter o nome da funcao de exbição do historico */
}
    void verificarStatusConta(){
        System.out.println("olá "+nome+"");
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
    
}
 