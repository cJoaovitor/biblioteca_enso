package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class tblLivrosTitulo extends AbstractTableModel {
    
    private List<Object[]> dados;
    private String[] colunas = {"ID", "Título", "Autor", "Ano de Publicação", "Gênero", "Editora", "Descrição"};

    public tblLivrosTitulo() {
        this.dados = new ArrayList<>();
    }

    public void adicionarLivro(LivroModel livro) {
        Object[] novaLinha = {
            livro.getIdLivro(),
            livro.getTitulo(),
            livro.getAutor(),
            livro.getAnoPublicacao(),
            livro.getGenero(),
            livro.getEditora(),
            livro.getDescricao()
        };
        this.dados.add(novaLinha);
        fireTableDataChanged();
    }

    public void removerLivro(int index) {
        this.dados.remove(index);
        fireTableDataChanged();
    }

    public void limparTabela() {
        this.dados.clear();
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return this.dados.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.dados.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
                return String.class;
            case 3:
                return Integer.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public AbstractTableModel getTableModel() {
        return this;
    }
}
