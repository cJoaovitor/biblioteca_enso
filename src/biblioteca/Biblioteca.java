package biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class  Biblioteca {

    static ArrayList<Usuario> us = new ArrayList<Usuario>();
    static ArrayList<Bibliotecario> bli = new ArrayList<Bibliotecario>();
    static ArrayList<Administrardor> adm = new ArrayList<Administrardor>();
    static ArrayList<Livro> livros = new ArrayList<Livro>();
    static Scanner cafe = new Scanner(System.in);
    static Scanner cafeln = new Scanner(System.in);
    static int contadorusurio;
    public static void main(String[] args) {
    criarconta();
    criarconta();
    criarconta();
    }

       static boolean login() {
        System.out.println("bem vindo a nossa biblioteca:");
        int escolha;
        boolean loginFeito;
        do {
            System.out.println("para para fazer login digite 1 para criar conta uma conta 2");
            escolha = cafe.nextInt();
            if (escolha == 2) {
                criarconta();
                loginFeito = false;
                return loginFeito;
            }
            if (escolha == 1) {
                System.out.println("qual e o nivel da sua conta 1 para usurio 2 para bibliotecario 3 para adm ");
                int nivelConta = cafe.nextInt();
                String pesNome;
                String PesSenha;
                String PesEmail;
                switch (nivelConta) {

                    case 1:
                        System.out.println("digite se nome de usuario");
                        pesNome = cafeln.nextLine();
                        System.out.println("digite sua senha");
                        PesSenha = cafeln.nextLine();
                        System.out.println("digite seu email");
                        PesEmail = cafeln.nextLine();
                        for (int i = 0; i < us.size(); i++) {
                            if (us.get(i).getNome().equals(pesNome) && us.get(i).getSenha().equalsIgnoreCase(PesEmail) && us.get(i).getSenha().equalsIgnoreCase(PesSenha)) {
                                System.out.println("login feito con sucesso");
                                loginFeito = true;
                                return loginFeito;
                            }
                        }
                        System.out.println("error no login tente novamente ou crei uma conta");
                        loginFeito = false;
                        return loginFeito;
                    case 2:
                       System.out.println("digite se nome de usuario");
                        pesNome = cafeln.nextLine();
                        System.out.println("digite sua senha");
                        PesSenha = cafeln.nextLine();
                        System.out.println("digite seu email");
                        PesEmail = cafeln.nextLine();
                        System.out.println("digite o codigo de bibliotecario");
                        String pescodigo = cafe.next();
                        PesEmail = cafeln.nextLine();
                        for (int i = 0; i < bli.size(); i++) {
                            if (bli.get(i).getNome().equals(pesNome) && bli.get(i).getSenha().equalsIgnoreCase(PesEmail) && bli.get(i).codigoBibliotecario.equalsIgnoreCase(pescodigo)) {
                                System.out.println("login feito con sucesso");
                                loginFeito = true;
                                return loginFeito;
                            }
                        }
                        System.out.println("error no login tente novamente ou crei uma conta");
                        loginFeito = false;
                        return loginFeito;
                    case 3:
                        System.out.println("digite se nome de usuario");
                        pesNome = cafeln.nextLine();
                        System.out.println("digite sua senha");
                        PesSenha = cafeln.nextLine();
                        System.out.println("digite seu email");
                        PesEmail = cafeln.nextLine();
                        System.out.println("digite o codigo de bibliotecario");
                        String pescodigoadm = cafe.next();
                        PesEmail = cafeln.nextLine();
                        for (int i = 0; i < adm.size(); i++) {
                            if (adm.get(i).getNome().equals(pesNome) && adm.get(i).getSenha().equalsIgnoreCase(PesEmail) && adm.get(i).getCodigoAdd().equalsIgnoreCase(pescodigoadm)) {
                                System.out.println("login feito con sucesso");
                                loginFeito = true;
                                return loginFeito;
                            }
                        }
                        System.out.println("error no login tente novamente ou crei uma conta");
                        loginFeito = false;
                        return loginFeito;
                }

            }
        } while (escolha > 2);
        loginFeito = false;
        return loginFeito;
    }

    static void criarconta() {
        System.out.println("bem vindo para criar a sua conta primeiro nos diga a nivel dela 1 para usuario 2 para bibliotecaro 3 para add ");
        int escolhaconta = cafe.nextInt();
        switch (escolhaconta) {
            case 1:
                contadorusurio ++;
                System.out.println(contadorusurio);
                //Usuario u = new Usuario(contadorusurio);
                
        }   
    }
}
