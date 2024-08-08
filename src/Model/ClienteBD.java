package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteBD {
    
    private Connection conn;
    
    public ClienteBD(Connection connexion) {
        conn = connexion;    

    }
    
    public void InsertaUsuario(ClienteClass usuario){
        try {
             
            String sql = "INSERT INTO clientes(usuario, password, nombre" 
             + ") VALUES(?,?,?)";
            try(
                 PreparedStatement stm = conn.prepareStatement(sql)){
                 stm.setString(1, usuario.getUser());
                 stm.setString(2,usuario.getPass());
                 stm.setString(3, usuario.getName());
                 stm.execute();
                if(stm != null)
                    stm.close();                             
            }
        }   catch (SQLException e) {
             throw new RuntimeException();
            }
     }
     
    public void ActualizaUsuario(ClienteClass usuario){
        
             
        String sql = "UPDATE clientes SET usuario=?, password=? , nombre =?  WHERE usuario=?";
        try(PreparedStatement stm = conn.prepareStatement(sql)){
            stm.setString(1, usuario.getUser());                
            stm.setString(2,usuario.getPass());            
            stm.setString(3, usuario.getName());
            stm.setString(4, usuario.getUser());
            stm.execute();
        }
        catch (SQLException e) {
            System.out.println("ERROR AL ACTUALIZAR USUARIO NO EXISTE");
            throw new RuntimeException(e);
        }
    }

    
   public void BorraUsuario(ClienteClass usuario){
        
             
        String sql = "DELETE FROM clientes WHERE usuario=?";
       
        try (PreparedStatement stm = conn.prepareStatement(sql)){
            stm.setString(1, usuario.getUser());            
            stm.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean ValidaUsuario(String user, String pass) throws SQLException{
        
        boolean valida = false;
        
        String sql = "SELECT * FROM clientes WHERE usuario = '" + user + "' AND  password = '" + pass + "'";
        try(PreparedStatement stm = conn.prepareStatement(sql)){
            stm.execute();
            ResultSet result = stm.executeQuery();
            while(result.next()){
                System.out.println(result.getString("usuario") + " " + result.getString("nombre") );
                valida = true;
            }
            if(result != null)
                result.close();
            if(stm != null)
                stm.close();            
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return valida;
    }
    
    public List<ClienteClass> ConsultaUsuarios(){
        
        List<ClienteClass> usuarios = new ArrayList<ClienteClass>();
        try {
            String sql = "SELECT * FROM clientes";
            try(PreparedStatement stm = conn.prepareStatement(sql)){
                stm.execute();
                transformResultado(usuarios, stm);
            }
            
            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        
    }   
    
    public void transformResultado(List<ClienteClass> usuarios, PreparedStatement statement) throws SQLException{
        try(ResultSet result = statement.executeQuery()) {
            while(result.next()){
                String usuario = result.getString("usuario");                
                String password = result.getString("password");
                String nombre = result.getString("nombre");
                ClienteClass obj = new ClienteClass(usuario, password, nombre);
                usuarios.add(obj);
                
            }
        } catch (Exception e) {
        }
    }
         

}
