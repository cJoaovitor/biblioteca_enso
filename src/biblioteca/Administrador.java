package biblioteca;

import static dados.Dados.*;
import static biblioteca.Biblioteca.contadorUsuario;
import static biblioteca.Biblioteca.*;

public class Administrador extends Usuario {
    private final String codigoAdm;

    public Administrador(String codigoAdm, int idusuario, String cpf, String nome, String email, String senha) {
        super(idusuario, cpf, nome, email, senha);
        this.codigoAdm = codigoAdm;
    }

    public String getCodigoAdm() {
        return codigoAdm;
    }

    @Override
    public void editarDados(String novoNome, String novoEmail, String novaSenha) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            this.nome = novoNome;
        }
        if (novoEmail != null && !novoEmail.trim().isEmpty()) {
            this.email = novoEmail;
        }
        if (novaSenha != null && !novaSenha.trim().isEmpty()) {
            this.senha = novaSenha;
        }
        System.out.println("Dados do administrador atualizados com sucesso!");
    }

    public void visualizarHistorico(int posicaoUsuario) {
        System.out.println("Histórico de empréstimos do usuário: ");
        getUsuarios().get(posicaoUsuario).visualizarHistorico();
    }

    public void removerUsuario(int posicaoUsuario) {
        if (posicaoUsuario >= 0 && posicaoUsuario < getUsuarios().size()) {
            getUsuarios().remove(posicaoUsuario);
            System.out.println("Usuário removido com sucesso!");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public void adicionarBibliotecario(String cpf, String nome, String email, String senha) {
        if (!bibliotecarioJaCadastrado(cpf)) {
            dados.Dados.getBibliotecarios().add(new Bibliotecario("bli" + (++contadorUsuario), ++contadorUsuario, cpf, nome, email, senha));
            System.out.println("Bibliotecário adicionado com sucesso.");
        } else {
            System.out.println("Bibliotecário com esse CPF já cadastrado.");
        }
    }

    private boolean bibliotecarioJaCadastrado(String cpf) {
        for (Bibliotecario bibliotecario : getBibliotecarios()) {
            if (bibliotecario.getCpf().equalsIgnoreCase(cpf)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void exibirDados() {
        System.out.println("=== Dados do Administrador ===");
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Código de ADM: " + codigoAdm);
    }
}