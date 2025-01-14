
package biblioteca;


public class Bibliotecario extends Usuario{
    protected String cargo;
    protected String codigoBibliotecario;

    public Bibliotecario( String codigoBibliotecario, int idusuario) {
        super(idusuario);
        cargo = "bibliotecario";
        this.codigoBibliotecario = codigoBibliotecario;
    }

    public String getCodigoBibliotecario() {
        return codigoBibliotecario;
    }
      
      
}
