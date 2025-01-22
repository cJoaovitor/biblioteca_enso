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
    static int contadoemprestimo;
    static int pociçãoUsuario;
    static String tipoUsurio;

    public static void main(String[] args) {
        int tes = 1;
        do {
            menu();
            if (tipoUsurio.equalsIgnoreCase("usuario")) {
                menuUsuario(pociçãoUsuario);
            }
            if (tipoUsurio.equalsIgnoreCase("bibliotecario")) {
                menuBibliotecario();
            }
            if (tipoUsurio.equalsIgnoreCase("adm")) {
                menuadm();
            }
        } while (tes == 1);
    }

    static boolean login() {
        System.out.println("Bem vindo!");
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
                System.out.println("nivel de conta 1 para usurio 2 para bibliotecario 3 para adm ");
                int nivelConta = cafe.nextInt();
                String pesNome;
                String PesSenha;
                String PesEmail;
                switch (nivelConta) {

                    case 1:
                        System.out.println("Senha:");
                        PesSenha = cafeln.nextLine();
                        System.out.println("Email:");
                        PesEmail = cafeln.nextLine();
                        for (int i = 0; i < us.size(); i++) {
                            if (us.get(i).getSenha().equalsIgnoreCase(PesEmail) && us.get(i).getSenha().equalsIgnoreCase(PesSenha)) {
                                pociçãoUsuario = i;
                                tipoUsurio = "usuario";
                                loginFeito = true;
                                return loginFeito;
                            }
                        }
                        System.out.println("Error tente novamente ou crei uma conta");
                        loginFeito = false;
                        return loginFeito;
                    case 2:
                        System.out.println("Senha:");
                        PesSenha = cafeln.nextLine();
                        System.out.println("Email:");
                        PesEmail = cafeln.nextLine();
                        System.out.println("digite o codigo de bibliotecario");
                        String pescodigo = cafe.next();
                        PesEmail = cafeln.nextLine();
                        for (int i = 0; i < bli.size(); i++) {
                            if ( bli.get(i).getSenha().equalsIgnoreCase(PesEmail) && bli.get(i).codigoBibliotecario.equalsIgnoreCase(pescodigo)) {
                                System.out.println("login feito con sucesso");
                                pociçãoUsuario = i;
                                tipoUsurio = "bibliotecario";
                                loginFeito = true;
                                return loginFeito;
                            }
                        }
                        System.out.println("Error tente novamente ou crie uma conta");
                        loginFeito = false;
                        return loginFeito;
                    case 3:
                        System.out.println("Senha:");
                        PesSenha = cafeln.nextLine();
                        System.out.println("Email:");
                        PesEmail = cafeln.nextLine();
                        System.out.println("digite o codigo de adm");
                        String pescodigoadm = cafe.next();
                        PesEmail = cafeln.nextLine();
                        for (int i = 0; i < adm.size(); i++) {
                            if (adm.get(i).getSenha().equalsIgnoreCase(PesEmail) && adm.get(i).getCodigoAdd().equalsIgnoreCase(pescodigoadm)) {
                                System.out.println("login feito con sucesso");
                                pociçãoUsuario = i;
                                tipoUsurio = "adm";
                                loginFeito = true;
                                return loginFeito;
                            }
                        }
                        System.out.println("Error tente novamente ou crie uma conta");
                        loginFeito = false;
                        return loginFeito;
                }

            }
        } while (escolha > 2);
        loginFeito = false;
        return loginFeito;
    }

    static void criarconta() {
        System.out.println("Bem vindo para criar a sua conta! Primeiro nos diga o nivel dela 1 para usuario 2 para bibliotecaro 3 para adm ");
        int escolhaconta = cafe.nextInt();
        System.out.println(" cpf ");
        String testecpf = cafe.next();
        switch (escolhaconta) {
            case 1:
                for (int i = 0; i < us.size(); i++) {
                    if (us.get(i).getCpf().equalsIgnoreCase(testecpf)) {
                        System.out.println("O cpf ja esta castrasdo");
                    }
                }
                contadorusurio++;
                Usuario u = new Usuario(contadorusurio, testecpf);
                us.add(u);
                System.out.println("Conta criada com sucesso");
                break;
            case 2:
                for (int i = 0; i < bli.size(); i++) {
                    if (bli.get(i).getCpf().equalsIgnoreCase(testecpf)) {
                    }
                }
                contadorusurio++;
                System.out.println("Conta criada com suceso, o codigo de bibliotecario e bli123");
                Bibliotecario b = new Bibliotecario("bli123", contadorusurio, testecpf);
                bli.add(b);
                break;
            case 3:
                for (int i = 0; i < adm.size(); i++) {
                    if (bli.get(i).getCpf().equalsIgnoreCase(testecpf)) {
                    }
                }
                contadorusurio++;
                System.out.println("Conta criada com suceso, o codigo de bibliotecario e adm123");
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

    static void menuUsuario(int posiçãoUsuario) {
        System.out.println("o que deseja");
        System.out.println("+---+-------------------------+\n"
                + "| 1 | realizar emprestimo        |\n"
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
        switch (escolhaUsuario) {
            case 1:
                System.out.println("para fazer o emprestimo primeiro pesquise o livro");
                pesquisaLivros();
                break;
            case 2:
                us.get(pociçãoUsuario).historicoEmprestimos.exibirHistoricoCompleto();
                System.out.println("deseja remova o emprestimo se sim digite 1");
                int removarEmprestimo = cafe.nextInt();
                if (removarEmprestimo == 1) {
                    int a = us.get(pociçãoUsuario).historicoEmprestimos.exibirHistoricoCompleto();
                    us.get(pociçãoUsuario).historicoEmprestimos.renovar(a);
                }
                break;
            case 3:
                visualizarhistorico(posiçãoUsuario);
                break;
            case 4:
                verificarStatusConta(pociçãoUsuario);
                break;
            case 5:
                pesquisaLivros();
            case 6:
                break;
        }
    }

    static void menuBibliotecario() {
        System.out.println("o que deseja fazer");
        System.out.println("+---+-------------------+\n"
                + "| 1 | remover usuário   |\n"
                + "+---+-------------------+\n"
                + "| 2 | adicionar usuário |\n"
                + "+---+-------------------+\n"
                + "| 3 | adicionar livro   |\n"
                + "+---+-------------------+\n"
                + "| 4 | remover livro     |\n"
                + "+---+-------------------+");
        int escolha = cafe.nextInt();
        switch (escolha) {
            case 1:
                removerusuario();
                break;
            case 2:
                criarconta();
                break;
            case 3:
                adicionarlivro();
                break;
            case 4:
                removerlivro();
                break;
        }
    }

    static void menuadm() {
        System.out.println("o que deseja fazer");
        System.out.println("+---+-------------------------+\n"
                + "| 1 | remover bibliotecario   |\n"
                + "+---+-------------------------+\n"
                + "| 2 | adicionar bibliotecario |\n"
                + "+---+-------------------------+");
        int escolhar = cafe.nextInt();
        switch (escolhar) {
            case 1:
                removerbibliotecario();
            case 2:
                criarconta();
        }
    }

    static void pesquisaLivros() {
        System.out.println("pelo oque quer pesquisa o livro; 1 nome do livro, 2 autor, 3 genero");
        int peslv = cafe.nextInt();
        int fazeremprestimo;
        switch (peslv) {
            case 1:
                System.out.println("qual e o nome do livro");
                String peslvnomme = cafeln.nextLine();
                for (int i = 0; i < livros.size(); i++) {
                    if (livros.get(i).getTitulo().equals(peslvnomme)) {
                        livros.get(i).exibir();
                        System.out.println("deseja fazer empretimo desse livro se sim 1 ");
                        fazeremprestimo = cafe.nextInt();
                        if (fazeremprestimo == 1) {
                            emprestimo(pociçãoUsuario, livros.get(i).getIdLivro(), livros.get(i));
                        }
                    }
                }
                break;
            case 2:
                System.out.println("qual e o titulo");
                String peslvtitulo = cafeln.nextLine();
                for (int i = 0; i < livros.size(); i++) {
                    if (livros.get(i).getTitulo().equals(peslvtitulo)) {
                        livros.get(i).exibir();
                        System.out.println("deseja fazer empretimo desse livro se sim 1 ");
                        fazeremprestimo = cafe.nextInt();
                        if (fazeremprestimo == 1) {
                            emprestimo(pociçãoUsuario, livros.get(i).getIdLivro(), livros.get(i));
                        }
                    }
                }
                break;
            case 3:
                System.out.println("qual e o titulo");
                String peslvgenero = cafeln.nextLine();
                for (int i = 0; i < livros.size(); i++) {
                    if (livros.get(i).getTitulo().equals(peslvgenero)) {
                        livros.get(i).exibir();
                        System.out.println("deseja fazer empretimo desse livro se sim 1 ");
                        fazeremprestimo = cafe.nextInt();
                        if (fazeremprestimo == 1) {
                            emprestimo(pociçãoUsuario, livros.get(i).getIdLivro(), livros.get(i));
                        }
                    }
                }
                break;

        }

    }

    static void emprestimo(int posiçãousuario, int idlivro, Livro l) {
        contadoemprestimo++;
        String data = "21/01/2025";
        String datadevo = "daqui ha sete dias";
        Emprestimo e = new Emprestimo(contadoemprestimo, us.get(posiçãousuario).idusuario, idlivro, data, datadevo, false, l);
    }

    static void removerusuario() {
        System.out.println("Usuario");
        for (int i = 0; i < us.size(); i++) {
            us.get(i).exibir();
            System.out.println("Quer excluir esse Usuario 1 para sim");
            int escolharex = cafe.nextInt();
            if (escolharex == 1) {
                us.remove(i);
            }
        }
    }

    static void adicionarlivro() {
        int cont;
        do {
            Livro l = new Livro(cafe);
            System.out.println("quer adicionar mais um livro se sim digite 1");
            cont = cafe.nextInt();
        } while (cont == 1);
    }

    static void removerlivro() {
        System.out.println("qual livro deseja renover");
        for (int i = 0; i < livros.size(); i++) {
            livros.get(i).exibir();
            System.out.println("quer remover esse livro se sim digite 1");
            int escolharemover = cafe.nextInt();
            if (escolharemover == 1) {
                livros.remove(i);
            }
        }
    }

    static void removerbibliotecario() {
        System.out.println("bibliotecario");
        for (int i = 0; i < bli.size(); i++) {
            us.get(i).exibir();
            System.out.println("Quer excluir esse bibliotecario 1 para sim");
            int escolharex = cafe.nextInt();
            if (escolharex == 1) {
                bli.remove(i);
            }
        }
    }

}
