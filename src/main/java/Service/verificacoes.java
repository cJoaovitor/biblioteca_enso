package Service;

import Model.UsuarioModel;
import java.util.ArrayList;

class verificacoes {
     public static boolean verificaCpfExistente(ArrayList<? extends UsuarioModel> lista, String cpf) {
        for (UsuarioModel usuario : lista) {
            if (usuario.getCpf().equalsIgnoreCase(cpf)) {
                return true; // CPF já está cadastrado
            }
        }
        return false; // CPF não está cadastrado
    }
}
