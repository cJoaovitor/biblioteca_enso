
package biblioteca;


public class Administrardor extends Bibliotecario{
    private String codigoAdd;

    public Administrardor(String codigoAdd, String codigoBibliotecario, int idusuario) {
        super(codigoBibliotecario, idusuario);
        this.codigoAdd = codigoAdd;
    }

    public String getCodigoAdd() {
        return codigoAdd;
    }
   
    
}

