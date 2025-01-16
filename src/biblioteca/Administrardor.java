
package biblioteca;


public class Administrardor extends Bibliotecario{
    private String codigoAdd;

    public Administrardor(String codigoAdd, int idusuario,  String cpf) {
        super("não tem", idusuario, cpf);
        this.codigoAdd = codigoAdd;
    }

    public String getCodigoAdd() {
        return codigoAdd;
    }
   
    
}

