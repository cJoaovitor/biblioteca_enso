package biblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {
    private int idEmprestimo;
    private Usuario usuario; // Referência ao usuário que fez o empréstimo
    private Livro livro; // Referência ao livro emprestado
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;
    private List<Usuario> reservas; // Lista de usuários que reservaram o livro

    // Construtor
    public Emprestimo(int idEmprestimo, Usuario usuario, Livro livro) {
    this.idEmprestimo = idEmprestimo;
    this.usuario = usuario;
    this.livro = livro;
    this.dataEmprestimo = LocalDate.now();
    this.dataDevolucao = dataEmprestimo.plusDays(14); // 14 dias para devolução
    this.devolvido = false;
    this.reservas = new ArrayList<>(); // Inicializa a lista de reservas
}

    // Construtor alternativo (caso necessário)
    public Emprestimo(int idEmprestimo, int idUsuario, int idLivro, String dataEmprestimo, String dataDevolucao, boolean devolvido) {
        // Aqui você pode implementar a lógica para criar um empréstimo a partir de IDs
        // Por exemplo, buscar o usuário e o livro a partir dos IDs se necessário
        this.idEmprestimo = idEmprestimo;
        // Lógica para buscar usuário e livro deve ser implementada aqui
        this.dataEmprestimo = LocalDate.parse(dataEmprestimo, DateTimeFormatter.ofPattern("yyyy-MM-dd")); // Formato esperado
        this.dataDevolucao = LocalDate.parse(dataDevolucao, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.devolvido = devolvido;
        this.reservas = new ArrayList<>();
    }

    // Métodos Getters
    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public List<Usuario> getReservas() {
        return reservas;
    }

    // Método para devolver o empréstimo
    public void devolverEmprestimo() {
        this.devolvido = true;
        System.out.println("Empréstimo devolvido com sucesso!");
        notificarReservas(); // Notifica usuários que reservaram o livro
    }

    // Método para renovar o empréstimo
    public void renovarEmprestimo() {
        if (!devolvido) {
            this.dataDevolucao = this.dataDevolucao.plusDays(7); // Renova por mais 7 dias
            System.out.println("Empréstimo renovado. Nova data de devolução: " + dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } else {
            System.out.println("Não é possível renovar um empréstimo já devolvido.");
        }
    }

    // Método para calcular a multa
    public float calcularMulta() {
        LocalDate hoje = LocalDate.now();
        if (hoje.isAfter(dataDevolucao) && !devolvido) {
            long diasAtraso = hoje.toEpochDay() - dataDevolucao.toEpochDay();
            float multaPorDia = 1.5f; // Exemplo: R$ 1,50 por dia de atraso
            return diasAtraso * multaPorDia;
        }
        return 0; // Sem multa
    }

    // Método para exibir informações do empréstimo
    public void exibirEmprestimo() {
        System.out.println("=== Informações do Empréstimo ===");
        System.out.println("ID do Empréstimo: " + idEmprestimo);
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Título do Livro: " + livro.getTitulo());
        System.out.println("Data de Empréstimo: " + dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data de Devolução: " + dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Status: " + (devolvido ? "Devolvido" : "Não devolvido"));
    }

    // Método para reservar o livro
    public void reservar(Usuario usuarioReserva) {
        if (devolvido) {
            System.out.println("O livro já está disponível para empréstimo.");
        } else {
            reservas.add(usuarioReserva);
            System.out.println("Usuário " + usuarioReserva.getNome() + " reservado o livro " + livro.getTitulo() + " com sucesso.");
        }
    }

    // Método para notificar usuários quando o livro é devolvido
    private void notificarReservas() {
        if (!reservas.isEmpty()) {
            for (Usuario usuarioReserva : reservas) {
                System.out.println("Notificação: O livro " + livro.getTitulo() + " foi devolvido e está disponível para empréstimo.");
            }
            reservas.clear(); // Limpa as reservas após a notificação
        }
    }
}
