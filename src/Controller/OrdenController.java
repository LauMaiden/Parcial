
package Controller;

import Model.ConnectBD;
import Model.Orden;
import Model.ComidaClass;
import Model.ClienteClass;

import java.sql.Connection;

public class OrdenController {
    private Orden est_matgrupBD;
    Connection connection;    
    
    
    public OrdenController() {
        connection = new ConnectBD().getConnection();        
        this.est_matgrupBD = new Orden(connection);        
    }
    
    
    public void InsertaOrden(ComidaClass obj_grupo, String user){
        this.est_matgrupBD.InsertaEstMatGrup(obj_grupo, user);
    }

    public void ConsultaGruposUsuarios(ClienteClass obj_user, String cod_user){
        this.est_matgrupBD.ConsultaGruposUsuarios(obj_user, cod_user);
    }    
    
}
