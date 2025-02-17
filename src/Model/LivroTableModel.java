package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class LivroTableModel extends AbstractTableModel {
    private List<LivroModel> livros;
    private String[] columnNames = {"ID", "Título", "Autor", "Ano de Publicação", "Editora", "Disponível"};

    public LivroTableModel(List<LivroModel> livros) {
        this.livros = livros;
    }

    @Override
    public int getRowCount() {
        return livros.size(); // Retorna o número de livros
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Retorna o número de colunas
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex]; // Retorna o nome da coluna
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LivroModel livro = livros.get(rowIndex); // Obtém o livro na linha especificada
        switch (columnIndex) {
            case 0:
                return livro.getIdLivro(); // ID
            case 1:
                return livro.getTitulo(); // Título
            case 2:
                return livro.getAutor(); // Autor
            case 3:
                return livro.getAnoPublicacao(); // Ano de Publicação
            case 4:
                return livro.getEditora(); // Editora
            case 5:
                return livro.getDisponivel(); // Disponibilidade
            default:
                return null; // Caso inválido
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // As células não são editáveis
    }

    public void setLivros(List<LivroModel> livros) {
        this.livros = livros;
        fireTableDataChanged(); // Notifica que os dados mudaram
    }
}
