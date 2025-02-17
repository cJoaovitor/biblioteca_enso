package Model;

import Dados.Dados;

public class AdministradorModel extends UsuarioModel {
    private final String codigoAdministrador;

    public AdministradorModel(String codigoAdministrador, int idUsuario, String cpf, String nome, String email, String senha, String logradouro, String numero, String complemento, String bairro, String uf, String cidade, String cep) {
        super(idUsuario, cpf, nome, email, senha, logradouro, numero, complemento, bairro, uf, cidade, cep);
        this.codigoAdministrador = codigoAdministrador;
    }

    public AdministradorModel(String codigoAdministrador, int idUsuario, String cpf, String nome, String email, String senha) {
        super(idUsuario, cpf, nome, email, senha, "", "", "", "", "", "", "");
        this.codigoAdministrador = codigoAdministrador;
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

    public void adicionarBibliotecario(String cpf, String nome, String email, String senha) {
        int idUsuario = Dados.getUsuarios().size() + 1; // Gera um ID único
        BibliotecarioModel novoBibliotecario = new BibliotecarioModel(BibliotecarioModel.gerarCodigoBibliotecario(), idUsuario, cpf, nome, email, senha);
        Dados.getUsuarios().add(novoBibliotecario);
        System.out.println("Bibliotecário adicionado com sucesso!");
    }

    @Override
    public void exibirDados() {
        System.out.println("=== Dados do Administrador ===");
        System.out.println("Código: " + codigoAdministrador);
        super.exibirDados();
    }

    public String getCodigoAdministrador() {
        return codigoAdministrador;
    }
}
