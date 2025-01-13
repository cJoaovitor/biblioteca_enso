
package biblioteca;

import java.util.Date;


class Notificacao {
    private static int contador = 0; // Contador estático para gerar um ID único para cada notificação
    private int idNotificacao; // Identificador único da notificação
    private int idUsuario; // ID do usuário associado à notificação
    private Date dataEnvio; // Data em que a notificação foi enviada
    private String tipo; // Tipo da notificação (ex: "Conta", "Recuperação", "Empréstimo")
    private String mensagem; // Conteúdo da notificação
    private String emailDestinatario; // Endereço de e-mail do destinatário

   
    public Notificacao(int idUsuario, String tipo, String emailDestinatario, int idNotifiçao) {
        this.idNotificacao = idNotifiçao;// Incrementa o contador para gerar um novo ID
        this.idUsuario = idUsuario; // Atribui o ID do usuário
        this.dataEnvio = new Date(); // Define a data de envio como a data atual
        this.tipo = tipo; // Define o tipo da notificação
        this.emailDestinatario = emailDestinatario; // Atribui o e-mail do destinatário
    }

        public void enviarNotificacao() {
        // Simula o envio de uma notificação
        System.out.println("Enviando notificação para: " + emailDestinatario);
        System.out.println("Tipo: " + tipo);
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Data de envio: " + dataEnvio);
        System.out.println("Notificação enviada com sucesso!\n");
        // Aqui você pode integrar um sistema de envio de e-mail real
    }

    //funcão padrão vou usa de base so mudar a mensagem
     public String criarconta(String nome){
       mensagem = "sua conta foi criada com suceso bem vindo "+nome;
       return mensagem;
    }
    
    
    public String recuperarsenha(String email, String nome, boolean senharescuperada ){
        if (senharescuperada == false){
            mensagem = "foi enviado um coddigo por email para o senhor "+nome;
            return mensagem;
        }else{
            mensagem = "sua senha foi mudar com suceso ";
            return mensagem;
        }
    }
    public String notificarEmprestimo (String nomelivro, String dataDevolução){
        mensagem= "seu emprestimo "+nomelivro+"do foi relisado com suceso a data para devolução e:"+dataDevolução;
        return mensagem;
    }

    public String notificarprazo(int dia){
        mensagem  = "seu empretime tem penas "+dia+" de validez";
        return mensagem;
    }


    public int getIdNotificacao() {
        return idNotificacao; // Retorna o ID da notificação
    }

    public int getIdUsuario() {
        return idUsuario; // Retorna o ID do usuário
    }

    public Date getDataEnvio() {
        return dataEnvio; // Retorna a data de envio da notificação
    }

    public String getTipo() {
        return tipo; // Retorna o tipo da notificação
    }

    public String getMensagem() {
        return mensagem; // Retorna o conteúdo da mensagem
    }

    public String getEmailDestinatario() {
        return emailDestinatario; // Retorna o e-mail do destinatário
    }
}
