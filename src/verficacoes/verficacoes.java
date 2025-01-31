
package verficacoes;

import biblioteca.Usuario;
import java.util.ArrayList;

public class verficacoes {
      public static boolean verificaCpfExistente(ArrayList<? extends Usuario> lista, String cpf) {
        for (Usuario usuario : lista) {
            if (usuario.getCpf().equalsIgnoreCase(cpf)) {
                System.out.println("O CPF já está cadastrado.");
                return true;
            }
        }
        return false;
    }
   public static boolean validarCPF(String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) return false;

        // Verifica se todos os dígitos são iguais
        if (cpf.chars().distinct().count() == 1) return false;

        int soma = 0, peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0 : digito1;

        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0 : digito2;

        return (digito1 == Character.getNumericValue(cpf.charAt(9))) && (digito2 == Character.getNumericValue(cpf.charAt(10)));
    }
   public static boolean validarCP (String cpf) {
        // Remove caracteres não numéricos
        cpf = cpf.replaceAll("[^0-9]", "");
        if (cpf.length() != 11) return false;

        // Verifica se todos os dígitos são iguais
        if (cpf.chars().distinct().count() == 1) return false;

        int soma = 0, peso = 10;
        for (int i = 0; i < 9; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }
        int digito1 = 11 - (soma % 11);
        digito1 = (digito1 >= 10) ? 0 : digito1;

        soma = 0;
        peso = 11;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }
        int digito2 = 11 - (soma % 11);
        digito2 = (digito2 >= 10) ? 0 : digito2;

        return (digito1 == Character.getNumericValue(cpf.charAt(9))) && (digito2 == Character.getNumericValue(cpf.charAt(10)));
    }
}

