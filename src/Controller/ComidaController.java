
package Controller;

import Model.ConnectBD;
import Model.ComidaBD;
import Model.ComidaClass;
import java.sql.Connection;
import java.sql.SQLException;
import Model.MenuBD;
import Model.MenuClass;

public class ComidaController {
    
    private final ComidaBD grupoBD;
    
    Connection connection;
    
    public ComidaController() {
        connection = new ConnectBD().getConnection();        
        this.grupoBD = new ComidaBD(connection);        
    }
    
    public void InsertaunComida(ComidaClass comida){
        this.grupoBD.InsertaComida(comida);
    }
     
    public void ActualizaComida(ComidaClass comida){
        this.grupoBD.ActualizaComida(comida);
    }
    
    
   public void BorraunComida(ComidaClass comida){
        this.grupoBD.BorraComida(comida);
    }
    public void ConsultaComidas(MenuClass obj_materia){
        this.grupoBD.ConsultaComidas(obj_materia);
    } 
    
   
    public void Close() throws SQLException{
        connection.close();
    }
    public void ConsultaComida(ComidaClass obj_grupo){
        this.grupoBD.ConsultaComida(obj_grupo);
    }
    
}
