package Model;

import java.util.Date;

class NotificacaoModel {
    private static int contador = 0; // Contador estático para gerar um ID único para cada notificação
    private int idNotificacao; // Identificador único da notificação
    private int idUsuario; // ID do usuário associado à notificação
    private Date dataEnvio; // Data em que a notificação foi enviada
    private String tipo; // Tipo da notificação (ex: "Conta", "Recuperação", "Empréstimo")
    private String mensagem; // Conteúdo da notificação
    private String emailDestinatario; // Endereço de e-mail do destinatário

    // Construtor
    public NotificacaoModel(int idUsuario, String tipo, String emailDestinatario) {
        this.idNotificacao = ++contador; // Incrementa o contador para gerar um novo ID
        this.idUsuario = idUsuario; // Atribui o ID do usuário
        this.dataEnvio = new Date(); // Define a data de envio como a data atual
        this.tipo = tipo; // Define o tipo da notificação
        this.emailDestinatario = emailDestinatario; // Atribui o e-mail do destinatário
    }

    // Método para enviar a notificação
    public void enviarNotificacao() {
        System.out.println("Enviando notificação para: " + emailDestinatario);
        System.out.println("Tipo: " + tipo);
        System.out.println("Mensagem: " + mensagem);
        System.out.println("Data de envio: " + dataEnvio);
        System.out.println("Notificação enviada com sucesso!\n");
        // Aqui você pode integrar um sistema de envio de e-mail real
    }

    // Método para criar conta
    public void criarConta(String nome) {
        mensagem = "Sua conta foi criada com sucesso. Bem-vindo, " + nome + "!";
        enviarNotificacao();
    }

    // Método para recuperar senha
    public void recuperarSenha(String email, String nome, boolean senhaRecuperada) {
        if (!senhaRecuperada) {
            mensagem = "Foi enviado um código por e-mail para o senhor " + nome + ".";
        } else {
            mensagem = "Sua senha foi mudada com sucesso.";
        }
        enviarNotificacao();
    }

    // Método para notificar sobre empréstimo
    public void notificarEmprestimo(String nomeLivro, String dataDevolucao) {
        mensagem = "Seu empréstimo do livro " + nomeLivro + " foi realizado com sucesso. A data para devolução é: " + dataDevolucao + ".";
        enviarNotificacao();
    }

    // Método para notificar sobre prazo
    public void notificarPrazo(int dias) {
        mensagem = "Seu empréstimo tem apenas " + dias + " dias de validade.";
        enviarNotificacao();
    }

    // Getters
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
