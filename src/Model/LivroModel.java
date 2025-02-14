package Model;

import dados.Dados;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroModel {
    private String id;
    private String codigo;
    private String titulo;
    private String autor;
    private String genero;
    private String descricao;
    private String anoPublicacao;
    private String editora;
    private boolean disponivel;
    private boolean emprestado;
    private List<String> status;

    // Construtor com Scanner
    public LivroModel(Scanner scanner) {
        this(String.valueOf(Dados.getContadorLivros()), scanner);
    }

    // Construtor com id e Scanner
    public LivroModel(String id, Scanner scanner) {
        this.id = id;
        System.out.print("Digite o código do livro: ");
        this.codigo = scanner.nextLine();
        System.out.print("Digite o título do livro: ");
        this.titulo = scanner.nextLine();
        System.out.print("Digite o autor do livro: ");
        this.autor = scanner.nextLine();
        System.out.print("Digite o gênero do livro: ");
        this.genero = scanner.nextLine();
        System.out.print("Digite a descrição do livro: ");
        this.descricao = scanner.nextLine();
        System.out.print("Digite o ano de publicação: ");
        this.anoPublicacao = scanner.nextLine();
        System.out.print("Digite a editora: ");
        this.editora = scanner.nextLine();
        this.disponivel = true;
        this.emprestado = false;
        this.status = new ArrayList<>();
    }

    // Construtor com parâmetros
    public LivroModel(String codigo, String titulo, String autor, String genero, String descricao, String anoPublicacao, String editora) {
        this.id = String.valueOf(Dados.getContadorLivros()); // Converte o contador para String
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.descricao = descricao;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.disponivel = true;
        this.emprestado = false;
        this.status = new ArrayList<>();
    }

    // Métodos getters
    public String getIdLivro() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public void adicionarStatus(String novoStatus) {
        this.status.add(novoStatus);
    }

    public void atualizarDisponibilidade() {
        this.disponivel = !this.disponivel;
    }

    public void exibir() {
        System.out.println("Código: " + codigo);
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Gênero: " + genero);
        System.out.println("Descrição: " + descricao);
        System.out.println("Ano de Publicação: " + anoPublicacao);
        System.out.println("Editora: " + editora);
        System.out.println("ID: " + id);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("Emprestado: " + (emprestado ? "Sim" : "Não"));
        System.out.println("Status:");
        for (String s : status) {
            System.out.println("- " + s);
        }
    }

    public static LivroModel buscarLivro(List<LivroModel> livros, String id) {
    for (LivroModel livro : livros) {
        if (livro.getIdLivro().equals(id)) {
            return livro;
        }
    }
    return null;
}


    private static LivroModel buscarLivroPorCodigo(List<LivroModel> livros, String codigo) {
        for (LivroModel livro : livros) {
            if (livro.getCodigo().equals(codigo)) {
                return livro;
            }
        }
        return null;
    }

   public static void emprestarLivro(List<LivroModel> livros, Scanner scanner) {
    System.out.print("Digite o código do livro que deseja emprestar: ");
    String codigoLivro = scanner.nextLine();

    LivroModel livro = buscarLivroPorCodigo(livros, codigoLivro);
    if (livro != null) {
        if (livro.isDisponivel() && !livro.isEmprestado()) {
            livro.setEmprestado(true);
            livro.setDisponivel(false); // Atualiza a disponibilidade
            livro.adicionarStatus("Emprestado");
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("O livro não está disponível para empréstimo.");
        }
    } else {
        System.out.println("Livro não encontrado.");
    }
}


   public static void devolverLivro(List<LivroModel> livros, Scanner scanner) {
    System.out.print("Digite o código do livro que deseja devolver: ");
    String codigoLivro = scanner.nextLine();

    LivroModel livro = buscarLivroPorCodigo(livros, codigoLivro);
    if (livro != null) {
        if (livro.isEmprestado()) {
            livro.setEmprestado(false);
            livro.setDisponivel(true); // Atualiza a disponibilidade
            livro.adicionarStatus("Devolvido");
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("O livro não está emprestado.");
        }
    } else {
        System.out.println("Livro não encontrado.");
    }
}

    
    
            
        
        
        
            
        
        
        
    public static void criarLivros(List<LivroModel> livros) {
    String[] titulos = {
        "O Alquimista", "A Culpa é das Estrelas", "O Pequeno Príncipe", "Cem Anos de Solidão",
        "O Código Da Vinci", "Harry Potter e a Pedra Filosofal", "A Cabana", "A Seleção",
        "A Menina que Roubava Livros", "Jogos Vorazes", "O Diário de Anne Frank", "Divergente",
        "A Hospedeira", "O Caçador de Pipas", "O Ladrão de Raios", "A Menina que Tinha Dom",
        "A Escolha", "O Doador de Memórias", "Illuminae", "O Teorema Katherine",
        "Crepúsculo", "O Céu Pode Esperar", "Divergente", "O Menino do Pijama Listrado",
        "Jogos Vorazes", "O Último Dia de um Condenado", "Maze Runner", "O Menino que Desenhava Borboletas",
        "A Seleção", "O Menino que Descobriu o Vento", "Illuminae", "O Menino que Não Queria Ser Rei",
        "O Guia do Mochileiro das Galáxias", "Frankenstein", "A Revolução dos Bichos", "As Veias Abertas da América Latina",
        "A Montanha Mágica", "O Nome da Rosa", "Moby Dick", "O Processo",
        "Ulisses", "O Morro dos Ventos Uivantes", "O Retrato de Dorian Gray", "Orgulho e Preconceito",
        "O Senhor dos Anéis", "1984", "Dom Casmurro", "Hamlet",
        "A Metamorfose", "O Grande Gatsby"
    };

    String[] autores = {
        "Paulo Coelho", "John Green", "Antoine de Saint-Exupéry", "Gabriel García Márquez",
        "Dan Brown", "J.K. Rowling", "William P. Young", "Kiera Cass",
        "Markus Zusak", "Suzanne Collins", "Anne Frank", "Veronica Roth",
        "Stephenie Meyer", "Khaled Hosseini", "Rick Riordan", "Jandy Nelson",
        "Robyn Carr", "Lois Lowry", "Amie Kaufman e Jay Kristoff", "John Green",
        "Stephenie Meyer", "Cecelia Ahern", "Veronica Roth", "John Boyne",
        "Suzanne Collins", "Victor Hugo", "James Dashner", "Keiko Kasza",
        "Kiera Cass", "William Kamkwamba e Bryan Mealer", "Amie Kaufman e Jay Kristoff", "Katherine Rundell",
        "Douglas Adams", "Mary Shelley", "George Orwell", "Eduardo Galeano",
        "Thomas Mann", "Umberto Eco", "Herman Melville", "Franz Kafka",
        "James Joyce", "Emily Brontë", "Oscar Wilde", "Jane Austen",
        "J.R.R. Tolkien", "George Orwell", "Machado de Assis", "William Shakespeare",
        "Franz Kafka", "F. Scott Fitzgerald"
    };

    String[] generos = {
        "Ficção", "Romance", "Infantil", "Realismo Mágico",
        "Suspense", "Fantasia", "Ficção", "Romance",
        "Ficção", "Distopia", "Não Ficção", "Distopia",
        "Ficção Científica", "Ficção", "Fantasia", "Ficção",
        "Romance", "Ficção", "Ficção Científica", "Romance",
        "Romance", "Ficção", "Distopia", "Ficção",
        "Distopia", "Ficção", "Ficção", "Infantil",
        "Romance", "Não Ficção", "Ficção Científica", "Ficção",
        "Ficção Científica", "Horror", "Sátira", "História",
        "Romance", "Mistério", "Aventura", "Ficção",
        "Modernismo", "Romance", "Ficção", "Drama",
        "Ficção", "Romance"
    };

    String[] descricoes = {
        "Um romance sobre um pastor que embarca em uma jornada espiritual em busca de um tesouro.",
        "Uma história sobre o amor e a perda entre dois adolescentes com cânter.",
        "Uma fábula filosófica sobre a essência da vida e as relações humanas.",
        "Uma saga familiar repleta de realismo mágico e elementos fantásticos.",
        "Um thriller sobre a descoberta de um segredo oculto na vida de Jesus.",
        "O primeiro livro da aclamada série Harry Potter, que introduz o mundo mágico.",
        "Um romance sobre um homem que enfrenta uma crise espiritual após a morte de sua filha.",
        "Uma série de romance sobre uma competição para se tornar a próxima princesa.",
        "Uma história sobre uma menina que rouba livros durante a Segunda Guerra Mundial.",
        "Uma trilogia distópica sobre uma sociedade que força os jovens a lutarem até a morte.",
        "Um relato autobiográfico da vida de Anne Frank durante o Holocausto.",
        "Uma trilogia distópica sobre um mundo dividido em facções com base em personalidades.",
        "Um romance de ficção científica sobre uma invasão alienígena na Terra.",
        "Uma história sobre a amizade e a redenção em meio ao conflito no Afeganistão.",
        "O primeiro livro da série Percy Jackson, sobre um garoto que descobre ser filho de Poseidon.",
        "Uma história sobre uma menina com o dom de ver o futuro das pessoas.",
        "Um romance sobre uma mulher que precisa fazer uma escolha entre dois homens.",
        "Uma distopia sobre uma sociedade que controla as memórias das pessoas.",
        "Uma trilogia de ficção científica sobre uma guerra intergalática.",
        "Um romance sobre um garoto que se apaixona por uma menina com o mesmo nome de sua ex.",
        "Uma série de romances sobre vampiros e lobisomens.",
        "Uma história sobre um garoto que descobre seu potencial para mudar o mundo.",
        "Uma trilogia distópica sobre um mundo dividido em facções com base em personalidades.",
        "Um romance sobre a amizade e a lealdade em meio à Segunda Guerra Mundial.",
        "Uma trilogia distópica sobre uma sociedade que força os jovens a lutarem até a morte.",
        "Um romance clássico sobre um homem condenado à morte na França do século XIX.",
        "Uma série de ficção científica sobre um labirinto misterioso e seus sobreviventes.",
        "Uma história infantil sobre um menino que desenha borboletas para ajudar sua família.",
        "Uma série de romances sobre uma competição para se tornar a próxima princesa.",
        "Um relato inspirador sobre um garoto que constrói uma turbina eólica para salvar sua aldeia.",
        "Uma trilogia de ficção científica sobre uma guerra intergalática.",
        "Uma história sobre um menino que não queria ser rei, mas acaba descobrindo seu destino.",
        "Uma sátira hilária e irreverente sobre a vida, o universo e tudo mais.",
        "Um clássico da literatura de terror que explora os limites da ciência e da moralidade.",
        "Uma alegoria política que retrata a luta de animais contra a tirania humana.",
        "Um relato contundente sobre a exploração econômica e política da América Latina.",
        "Uma obra-prima da literatura alemã que explora temas como o tempo, a doença e a filosofia.",
        "Um romance histórico e filosófico ambientado na Idade Média.",
        "Uma épica história sobre a obsessão de um capitão pela caça a uma lendária baleia branca.",
        "Uma narrativa kafkiana sobre a burocracia e a alienação do indivíduo.",
        "Uma obra-prima do modernismo que retrata um dia na vida de Leopold Bloom em Dublin.",
        "Um romance clássico sobre a paixão e a tragédia em um ambiente rural.",
        "Uma história sobre vaidade, hedonismo e as consequências de se vender a alma.",
        "Uma história clássica sobre relacionamentos e sociedade no século XIX.",
        "Uma épica jornada em um mundo fantástico repleto de criaturas mágicas.",
        "Uma obra-prima da literatura distópica que retrata um futuro sombrio e opressivo.",
        "Uma obra-prima da literatura brasileira que explora os temas de ciúme e traição.",
        "Uma das mais famosas tragédias de Shakespeare, explorando temas como loucura, vingança e existencialismo.",
        "Uma narrativa surreal e alegórica sobre a transformação de um homem em um inseto.",
        "Uma obra-prima da literatura americana que retrata a sociedade da década de 1920."
    };

    String[] anos = {
        "1988", "2012", "1943", "1967",
        "2003", "1997", "2007", "2012",
        "2005", "2008", "1947", "2011",
        "2008", "2003", "2005", "2010",
        "2013", "1993", "2015", "2012",
        "2005", "2004", "2011", "2006",
        "2008", "1829", "2009", "2012",
        "2012", "2009", "2015", "2015",
        "1979", "1818", "1945", "1971",
        "1924", "1980", "1851", "1925",
        "1922", "1847", "1890", "1813",
        "1954", "1949", "1899", "1603",
        "1915", "1925"
    };

    String[] editoras = {
        "Rocco", "Intrínseca", "Agir", "Record",
        "Sextante", "Rocco", "Arqueiro", "HarperCollins Brasil",
        "Intrínseca", "Rocco", "Companhia das Letras", "Rocco",
        "Intrínseca", "Alfaguara", "Intrínseca", "Intrínseca",
        "Mira", "Rocco", "Galera Record", "Intrínseca",
        "Intrínseca", "Rocco", "Rocco", "Companhia das Letras",
        "Rocco", "Companhia das Letras", "Rocco", "Brinque-Book",
        "HarperCollins Brasil", "Companhia das Letras", "Galera Record", "Intrínseca",
        "Arqueiro", "Penguin Classics", "Companhia das Letras", "L&PM",
        "Companhia das Letras", "Record", "Landmark", "Companhia das Letras",
        "Objetiva", "Penguin Classics", "Landmark", "Ática",
        "Martins Fontes", "Companhia das Letras", "Nova Fronteira", "Editora 34",
        "Companhia das Letras", "Abril"
    };

    int codigoAtual = 1;

        for (int i = 0; i < titulos.length; i++) {
            String codigo = gerarCodigoLivro(codigoAtual);
            LivroModel livro = new LivroModel(
                codigo, titulos[i], autores[i], generos[i],
                descricoes[i], anos[i], editoras[i]
            );
            livros.add(livro);
            livro.adicionarStatus("Novo");
            codigoAtual++;
        }
    }

    private static String gerarCodigoLivro(int codigo) {
        return String.format("C%03d", codigo);
    }
    
    
    
    
}