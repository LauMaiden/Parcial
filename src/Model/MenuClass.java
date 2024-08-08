
package Model;

import java.util.ArrayList;

public class MenuClass {
    private String cod_menu;
    private String nom_mat;
    
    
    public ArrayList<ComidaClass> List_Grupos = new ArrayList<ComidaClass>();       

    
    public MenuClass(String cod_mat) {
        this.cod_menu = cod_mat;
    }

    public String getCod_mat() {
        return cod_menu;
    }

    public void setCod_mat(String cod_mat) {
        this.cod_menu = cod_mat;
    }

    public String getNom_mat() {
        return nom_mat;
    }

    public void setNom_mat(String nom_mat) {
        this.nom_mat = nom_mat;
    }

}
