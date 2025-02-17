package Model;

import Dados.Dados;

public class AdministradorModel extends UsuarioModel {
    private final String codigoAdministrador;
    private final String codigoUsuario;

    public AdministradorModel(int codigoUsuario, String cpf, String nome, String email, String senha, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String cep) {
        super(codigoUsuario, cpf, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep);
        this.codigoAdministrador = Dados.gerarCodigoAdministrador();
        this.codigoUsuario = String.valueOf(codigoUsuario);
    }

    public AdministradorModel(int codigoUsuario, String cpf, String nome, String email, String senha) {
        super(codigoUsuario, cpf, nome, email, senha, "", "", "", "", "", "", "");
        this.codigoAdministrador = Dados.gerarCodigoAdministrador();
        this.codigoUsuario = String.valueOf(codigoUsuario);
    }

    public void removerUsuario(int posicaoUsuario) {
        try {
            if (posicaoUsuario < 0 || posicaoUsuario >= Dados.getUsuarios().size()) {
                System.out.println("Usuário não encontrado.");
                return;
            }
            Dados.getUsuarios().remove(posicaoUsuario);
            System.out.println("Usuário removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao remover usuário: " + e.getMessage());
        }
    }

    @Override
    public void exibirDados() {
        System.out.println("=== Dados do Administrador ===");
        System.out.println("Código do Administrador: " + codigoAdministrador);
        System.out.println("Código do Usuário: " + codigoUsuario);
        super.exibirDados();
    }

    public String getCodigoAdministrador() {
        return codigoAdministrador;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }
}
