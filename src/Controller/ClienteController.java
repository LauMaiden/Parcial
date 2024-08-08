
package Controller;

import Model.ConnectBD;
import Model.ClienteBD;
import Model.ClienteClass;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClienteController {
    private ClienteBD usuarioBD;
    
    Connection connection;
    
    public ClienteController() {
        connection = new ConnectBD().getConnection();        
        this.usuarioBD = new ClienteBD(connection);        
    }
    
    public void InsertaUsuario(ClienteClass usuario){
        this.usuarioBD.InsertaUsuario(usuario);
    }
     
    public void ActualizaUsuario(ClienteClass usuario){
        this.usuarioBD.ActualizaUsuario(usuario);
    }
    
    
   public void BorraUsuario(ClienteClass usuario){
        this.usuarioBD.BorraUsuario(usuario);
    }
    public boolean ValidaUsuario(String user, String pass) throws SQLException {
        
        return this.usuarioBD.ValidaUsuario(user, pass);
    }
    public List<ClienteClass> ConsultaUsuarios(){

        return this.usuarioBD.ConsultaUsuarios();
    } 
    
    public void Close() throws SQLException{
        connection.close();
    }
    
}
