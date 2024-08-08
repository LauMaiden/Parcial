package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuBD {
    
    private Connection conn;
    
    public MenuBD(Connection connexion) {
        conn = connexion;    

    }
    
    public void InsertaMenu(MenuClass menu){
        try {
             
            String sql = "INSERT INTO menus(cod_menu, nombremenu" 
             + ") VALUES(?,?)";
            try(
                 PreparedStatement stm = conn.prepareStatement(sql)){
                 stm.setString(1, menu.getCod_mat());
                 stm.setString(2,menu.getNom_mat());
                 stm.execute();
                if(stm != null)
                    stm.close();                             
            }
        }   catch (SQLException e) {
             throw new RuntimeException();
            }
     }
     
    public void ActualizaMenu(MenuClass menu){
        
             
        String sql = "UPDATE menus SET cod_menu=?, nombremenu=? WHERE cod_menu=?";
        try(PreparedStatement stm = conn.prepareStatement(sql)){
            stm.setString(1, menu.getCod_mat());                
            stm.setString(2,menu.getNom_mat());            
            stm.setString(3, menu.getCod_mat());

            stm.execute();
        }
        catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR MENU NO EXISTE");
            throw new RuntimeException(e);
        }
    }

    
   public void BorraMenu(MenuClass menu){
        
             
        String sql = "DELETE FROM menus WHERE cod_menu=?";
       
        try (PreparedStatement stm = conn.prepareStatement(sql)){
            stm.setString(1, menu.getCod_mat());            
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public List<MenuClass> ConsultaMenus(){
        
        List<MenuClass> menus = new ArrayList<MenuClass>();
        try {
            String sql = "SELECT * FROM menus";
            try(PreparedStatement stm = conn.prepareStatement(sql)){
                stm.execute();
                transformResultado(menus, stm);
            }
            
            return menus;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
       
    }   
    
     
    public void transformResultado(List<MenuClass> menus, PreparedStatement statement) throws SQLException{
        try(ResultSet result = statement.executeQuery()) {
            while(result.next()){
                String codigo = result.getString("cod_menu");                
                String nombremat = result.getString("nombremenu");

                MenuClass obj = new MenuClass(codigo);
                obj.setNom_mat(nombremat);
                menus.add(obj);
                
            }
        } catch (Exception e) {
        }
    }
    
    public void ConsultaMenu(MenuClass obj_menu){
        
        String sql = "SELECT * FROM materias WHERE cod_menu = '" + obj_menu.getCod_mat() + "'";
        try(PreparedStatement stm = conn.prepareStatement(sql)){
            stm.execute();
            ResultSet result = stm.executeQuery();
            while(result.next()){
                String nombre = result.getString("nombremat");                
                obj_menu.setNom_mat(nombre);
                
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }            

}
