package biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

    static ArrayList<Usuario> us = new ArrayList<Usuario>();
    static ArrayList<Bibliotecario> bli = new ArrayList<Bibliotecario>();
    static ArrayList<Administrardor> adm = new ArrayList<Administrardor>();
    static ArrayList<Livro> livros = new ArrayList<Livro>();
    static Scanner cafe = new Scanner(System.in);
    static Scanner cafeln = new Scanner(System.in);
    static int contadorusurio;
    static int pociçãoUsuario;
    static String tipoUsurio;

    public static void main(String[] args) {
        int tes = 1;
        do {
            menu();
            if (tipoUsurio.equalsIgnoreCase("usuario")){
                menuUsuariov(pociçãoUsuario);
            }if (tipoUsurio.equalsIgnoreCase("bibliotecario")){
                menuBibliotecario();
            }if(tipoUsurio.equalsIgnoreCase("adm")){
                menuadm();
            }
        } while (tes == 1);
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
                                pociçãoUsuario = i;
                                tipoUsurio = "usuario";
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
                                pociçãoUsuario = i;
                                tipoUsurio = "bibliotecario";
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
                                pociçãoUsuario = i;
                                tipoUsurio = "adm";
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
        System.out.println("digite seu cpf ");
        String testecpf = cafe.next();
        switch (escolhaconta) {
            case 1:
                for (int i = 0; i < us.size(); i++) {
                    if (us.get(i).getCpf().equalsIgnoreCase(testecpf)) {
                    }
                }
                contadorusurio++;
                Usuario u = new Usuario(contadorusurio, testecpf);
                us.add(u);
                System.out.println("conta criada com sucesso");
                break;
            case 2:
                for (int i = 0; i < bli.size(); i++) {
                    if (bli.get(i).getCpf().equalsIgnoreCase(testecpf)) {
                    }
                }
                contadorusurio++;
                System.out.println("conta criada com suceso, o codigo de bibliotecario e bli123");
                Bibliotecario b = new Bibliotecario("bli123", contadorusurio, testecpf);
                bli.add(b);
                break;
            case 3:
                for (int i = 0; i < adm.size(); i++) {
                    if (bli.get(i).getCpf().equalsIgnoreCase(testecpf)) {
                    }
                }
                contadorusurio++;
                System.out.println("conta criada com suceso, o codigo de bibliotecario e adm123");
                Administrardor a = new Administrardor("adm123", contadorusurio, testecpf);
                adm.add(a);
                break;
        }
    }

    static void editardados(int pociçaodousurio, String tipoUsurio) {
        if (tipoUsurio.equalsIgnoreCase("usuario")) {
            System.out.println(" digite o novos dados caso não queria mudar digite os dadoas antigos ");
            System.out.println("novo nome");
            String novonome = cafeln.nextLine();
            System.out.println("novo email ");
            String novoemail = cafe.next();
            System.out.println("nova Senhar");
            String novasenhar = cafe.next();
            us.get(pociçãoUsuario).EditarDados(novonome, novoemail, novasenhar);
        }
        if (tipoUsurio.equalsIgnoreCase("bibliotecario")) {
            System.out.println(" digite o novos dados caso não queria mudar digite os dadoas antigos ");
            System.out.println("novo nome");
            String novonome = cafeln.nextLine();
            System.out.println("novo email ");
            String novoemail = cafe.next();
            System.out.println("nova Senhar");
            String novasenhar = cafe.next();
            bli.get(pociçãoUsuario).EditarDados(novonome, novoemail, novasenhar);
        }
        if (tipoUsurio.equalsIgnoreCase("adm")) {
            System.out.println(" digite o novos dados caso não queria mudar digite os dadoas antigos ");
            System.out.println("novo nome");
            String novonome = cafeln.nextLine();
            System.out.println("novo email ");
            String novoemail = cafe.next();
            System.out.println("nova Senhar");
            String novasenhar = cafe.next();
            adm.get(pociçãoUsuario).EditarDados(novonome, novoemail, novasenhar);
        }
    }

    static void visualizarhistorico(int posiçãoUsuario) {
        System.out.println("o seu historico de livros e: ");
        us.get(posiçãoUsuario).visualizarHistorico();
    }

    static String verificarStatusConta(int pociçãoUsuario) {
        return us.get(contadorusurio).verificarStatusConta();
    }

    static void recuperarSenha(String cpf) {
        System.out.println("qual o tipo de usuario");
        int tipo = cafe.nextInt();
        System.out.println("qual e seu cpf ");
        String recpCpf = cafe.next();
        switch (tipo) {
            case 1:
                for (int i = 0; i < us.size(); i++) {
                    if (us.get(i).getCpf().equalsIgnoreCase(cpf)) {
                        us.get(i).recuperarSenha();
                    }
                }
            case 2:
                for (int i = 0; i < bli.size(); i++) {
                    if (bli.get(i).getCpf().equalsIgnoreCase(cpf)) {
                        bli.get(i).recuperarSenha();
                    }
                }
            case 3:
                for (int i = 0; i < adm.size(); i++) {
                    if (adm.get(i).getCpf().equalsIgnoreCase(cpf)) {
                        adm.get(i).recuperarSenha();
                    }
                }
        }

    }

    static void menu() {
        System.out.println("o que deseja fazer ");
        System.out.println("+---+-------------------+\n"
                + "| 1 | login             |\n"
                + "+---+-------------------+\n"
                + "| 2 | cria conta        |\n"
                + "+---+-------------------+\n"
                + "| 3 |  recuperer Senhar |\n"
                + "+---+-------------------+");
        int Escolhar = cafe.nextInt();
        switch (Escolhar) {
            case 1:
                login();
                break;
            case 2:
                criarconta();
                break;
            case 3:
                System.out.println("qual o seu cpf");
                String recCpfv = cafe.next();
                recuperarSenha(recCpfv);
                break;
        }
    }

    static void menuUsuariov(int posiçãoUsuario) {
        System.out.println("o que deseja");
        System.out.println("+---+-------------------------+\n"
                + "| 1 | fazer emprestimo        |\n"
                + "+---+-------------------------+\n"
                + "| 2 | renovar emprestimo      |\n"
                + "+---+-------------------------+\n"
                + "| 3 | visualizar historico    |\n"
                + "+---+-------------------------+\n"
                + "| 4 |  verificar status conta |\n"
                + "+---+-------------------------+\n"
                + "| 5 | pesquisa livros         |\n"
                + "+---+-------------------------+\n"
                + "| 6 | sair                    |\n"
                + "+---+-------------------------+");
                int escolhaUsuario = cafe.nextInt();
                switch(escolhaUsuario){
                    case 1:
                        //função a ser feita pois emprestimo falta correção
                         System.out.println("em desemvovimento");
                        break;
                    case 2:
                       //função a ser feita pois emprestimo falta correção
                         System.out.println("em desemvovimento");
                         break;
                    case 3:
                        visualizarhistorico(posiçãoUsuario);
                        break;
                    case 4:
                         verificarStatusConta(pociçãoUsuario);
                        break;
                    case 5:
                        pesquisaLivros();
                        //falta atulizar a classe livro
                    case 6:
                        break;
                }
    }
    static void menuBibliotecario(){
        // falta correção da classe
    }
    static void menuadm(){
        // falta correção do jogo
    }
}