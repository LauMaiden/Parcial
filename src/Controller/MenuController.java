
package Controller;

import Model.ConnectBD;
import Model.MenuBD;
import Model.MenuClass;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class MenuController {
    
    private MenuBD materiaBD;
    
    Connection connection;
    
    public MenuController() {
        connection = new ConnectBD().getConnection();        
        this.materiaBD = new MenuBD(connection);        
    }
    
    public void Insertamenu(MenuClass materia){
        this.materiaBD.InsertaMenu(materia);
    }
     
    public void ActualizaMenu(MenuClass materia){
        this.materiaBD.ActualizaMenu(materia);
    }
    
    
   public void BorraMenu(MenuClass materia){
        this.materiaBD.BorraMenu(materia);
    }
   
    public List<MenuClass> ConsultaMenus(){

        return this.materiaBD.ConsultaMenus();
    } 
    public void ConsultaMenu(MenuClass obj_materia){
        this.materiaBD.ConsultaMenu(obj_materia);
    }
    public void Close() throws SQLException{
        connection.close();
    }
    
}
