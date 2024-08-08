
package Model;

public class ComidaClass extends MenuClass{
    private String codigo_comida;
    private String Sabor;
    private String precio;

    public ComidaClass(String cod_mat, String codigo_comida ) {
        super(cod_mat);
        this.codigo_comida = codigo_comida;
    }

    public String getCodigo_comida() {
        return codigo_comida;
    }

    public void setCodigo_comida(String codigo_comida) {
        this.codigo_comida = codigo_comida;
    }

    public String getSabor() {
        return Sabor;
    }

    public void setSabor(String Sabor) {
        this.Sabor = Sabor;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }


 
}
    
    

