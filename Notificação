import java.util.Date;


class Notificacao {
    private static int contador = 0; // Contador estático para gerar um ID único para cada notificação
    private int idNotificacao; // Identificador único da notificação
    private int idUsuario; // ID do usuário associado à notificação
    private Date dataEnvio; // Data em que a notificação foi enviada
    private String tipo; // Tipo da notificação (ex: "Conta", "Recuperação", "Empréstimo")
    private String mensagem; // Conteúdo da notificação
    private String emailDestinatario; // Endereço de e-mail do destinatário

   
    public Notificacao(int idUsuario, String tipo, String mensagem, String emailDestinatario) {
        this.idNotificacao = ++contador; // Incrementa o contador para gerar um novo ID
        this.idUsuario = idUsuario; // Atribui o ID do usuário
        this.dataEnvio = new Date(); // Define a data de envio como a data atual
        this.tipo = tipo; // Define o tipo da notificação
        this.mensagem = mensagem; // Define o conteúdo da mensagem
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

     public static Notificacao criarConta(int idUsuario, String emailDestinatario) {
        String mensagem = "Sua conta foi criada com sucesso! Bem-vindo ao nosso sistema.";
        return new Notificacao(idUsuario, "Conta", mensagem, emailDestinatario);
    }

    
    public static Notificacao recuperarSenha(int idUsuario, String emailDestinatario) {
        String mensagem = "Você solicitou a recuperação de senha. Siga as instruções enviadas para redefinir sua senha.";
        return new Notificacao(idUsuario, "Recuperação", mensagem, emailDestinatario);
    }

    
    public static Notificacao realizarEmprestimo(int idUsuario, Date dataEmprestimo, Date dataDevolucao, String emailDestinatario) {
        String mensagem = String.format("Empréstimo realizado em: %s. Devolução até: %s.", 
                                          dataEmprestimo, dataDevolucao);
        return new Notificacao(idUsuario, "Empréstimo", mensagem, emailDestinatario);
    }

        public static Notificacao notificarPrazo(int idUsuario, long diasRestantes, String emailDestinatario) {
        String mensagem = String.format("Atenção: Faltam %d dias para a devolução do seu empréstimo.", diasRestantes);
        return new Notificacao(idUsuario, "Prazo", mensagem, emailDestinatario);
    }

    
    public static Notificacao calcularMulta(int idUsuario, double multa, String emailDestinatario) {
        String mensagem = String.format("Você está atrasado! Multa total: R$%.2f.", multa);
        return new Notificacao(idUsuario, "Atraso", mensagem, emailDestinatario);
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
