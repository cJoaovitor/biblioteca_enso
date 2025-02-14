package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaModel {
    private static List<ReservaModel> reservas = new ArrayList<>();

    private int codLivro;
    private int codUsuario;
    private String tituloLivro;
    private String nomeUsuario;
    private LocalDate dataDevolucao;

    public ReservaModel(int codLivro, int codUsuario, String tituloLivro, String nomeUsuario, LocalDate dataDevolucao) {
        this.codLivro = codLivro;
        this.codUsuario = codUsuario;
        this.tituloLivro = tituloLivro;
        this.nomeUsuario = nomeUsuario;
        this.dataDevolucao = dataDevolucao;
        reservas.add(this); // Adiciona a reserva à lista de reservas
    }

    // Getters e Setters
    public int getCodLivro() {
        return codLivro;
    }

    public int getCodUsuario() {
        return codUsuario;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public static ReservaModel buscarReserva(int codLivro, int codUsuario) {
        for (ReservaModel reserva : reservas) {
            if (reserva.getCodLivro() == codLivro && reserva.getCodUsuario() == codUsuario) {
                return reserva;
            }
        }
        return null; // Não encontrou a reserva
    }

    public boolean cancelarReserva() {
        // Implementação da lógica de cancelamento de reserva
        reservas.remove(this);
        System.out.println("Reserva cancelada com sucesso!");
        return true;
    }

    public static void listarReservas() {
        for (ReservaModel reserva : reservas) {
            System.out.println("Código do Livro: " + reserva.getCodLivro());
            System.out.println("Código do Usuário: " + reserva.getCodUsuario());
            System.out.println("Título do Livro: " + reserva.getTituloLivro());
            System.out.println("Nome do Usuário: " + reserva.getNomeUsuario());
            System.out.println("Data de Devolução: " + reserva.getDataDevolucao());
            System.out.println("---");
        }
    }
}


