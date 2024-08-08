package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ComidaBD {
    
    private Connection conn;
    
    public ComidaBD(Connection connexion) {
        conn = connexion;    

    }
    
    public void InsertaComida(ComidaClass comida){
        try {
             
            String sql = "INSERT INTO comidas(cod_menu, cod_comida, sabor, precio" 
             + ") VALUES(?,?,?,?)";
            try(
                 PreparedStatement stm = conn.prepareStatement(sql)){
                 stm.setString(1, comida.getCod_mat());
                 stm.setString(2,comida.getCodigo_comida());
                 stm.setString(3,comida.getSabor());
                 stm.setString(4,comida.getPrecio());
                 stm.execute();
                if(stm != null)
                    stm.close();                             
            }
        }   catch (SQLException e) {
             throw new RuntimeException();
            }
     }
     
    public void ActualizaComida(ComidaClass comida){
        String sql = "UPDATE comidas SET sabor=?, profesor=? WHERE cod_menu=? and cod_comida=?";
        
        try(PreparedStatement stm = conn.prepareStatement(sql)){
                    
            stm.setString(1, comida.getSabor());
            stm.setString(2, comida.getPrecio());
            stm.setString(3, comida.getCod_mat());                
            stm.setString(4,comida.getCodigo_comida());   
            stm.execute(); 
        }
        catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR MATERIA NO EXISTE");
            throw new RuntimeException(e);
        }
    }

     
    public void BorraComida(ComidaClass comida){
        
             
        String sql = "DELETE FROM comidas WHERE cod_menu=? and cod_comida=?";
       
        try (PreparedStatement stm = conn.prepareStatement(sql)){
            stm.setString(1, comida.getCod_mat());   
            stm.setString(2, comida.getCodigo_comida());   
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public void ConsultaComidas(MenuClass obj_materia){
        
        String sql = "SELECT * FROM comidas WHERE cod_menu =?";
        try(PreparedStatement stm = conn.prepareStatement(sql)){
            stm.setString(1, obj_materia.getCod_mat());  
            stm.execute();
            ResultSet result = stm.executeQuery();
            while(result.next()){
                String codmat= result.getString("cod_menu");
                String codgrupo= result.getString("cod_comida");
                String horario = result.getString("sabor");                
                String profesor = result.getString("precio");

                ComidaClass obj = new ComidaClass(codmat, codgrupo);
                obj.setSabor(horario);
                obj.setPrecio(profesor);
                obj_materia.List_Grupos.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }   
    public void ConsultaComida(ComidaClass obj_comida){
        
        String sql = "SELECT * FROM comidas WHERE cod_menu = '" + obj_comida.getCod_mat() + "' AND cod_comida = '"+ obj_comida.getCodigo_comida() + "'";
        try(PreparedStatement stm = conn.prepareStatement(sql)){
            stm.execute();
            ResultSet result = stm.executeQuery();
            while(result.next()){
                String horario = result.getString("sabor");                
                String profesor = result.getString("precio");
                obj_comida.setSabor(horario);
                obj_comida.setPrecio(profesor);
                
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }   
}
