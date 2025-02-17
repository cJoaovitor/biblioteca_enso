package Model;

import Dados.Dados;

public class AdministradorModel extends UsuarioModel {
    private final String codigoAdministrador;
<<<<<<< HEAD
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
=======

    public AdministradorModel( int idUsuario, String cpf, String nome, String email, String senha, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String cep) {
        super(idUsuario, cpf, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep);
        this.codigoAdministrador = codigoAdministrador;
    }

    public AdministradorModel(String codigoAdministrador, int idUsuario, String cpf, String nome, String email, String senha) {
        super(idUsuario, cpf, nome, email, senha, "", "", "", "", "", "", "");
        this.codigoAdministrador = codigoAdministrador;
>>>>>>> 1bc9f95fd7609a92086d0c81cb7abfdc18f6face
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

<<<<<<< HEAD
    @Override
    public void exibirDados() {
        System.out.println("=== Dados do Administrador ===");
        System.out.println("Código do Administrador: " + codigoAdministrador);
        System.out.println("Código do Usuário: " + codigoUsuario);
=======
  
    @Override
    public void exibirDados() {
        System.out.println("=== Dados do Administrador ===");
        System.out.println("Código: " + codigoAdministrador);
>>>>>>> 1bc9f95fd7609a92086d0c81cb7abfdc18f6face
        super.exibirDados();
    }

    public String getCodigoAdministrador() {
        return codigoAdministrador;
    }
<<<<<<< HEAD

    public String getCodigoUsuario() {
        return codigoUsuario;
    }
=======
>>>>>>> 1bc9f95fd7609a92086d0c81cb7abfdc18f6face
}
