package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Orden {
    private Connection conn;
    
    public Orden(Connection connexion) {
        conn = connexion;  
    }

    public void InsertaEstMatGrup(ComidaClass obj_grupo, String user){
        try {
             
            String sql = "INSERT INTO orden(cod_cliente, cod_menu, cod_comida" 
             + ") VALUES(?,?,?)";
            try(
                 PreparedStatement stm = conn.prepareStatement(sql)){
                stm.setString(1, user);                                 
                stm.setString(2,obj_grupo.getCod_mat());
                stm.setString(3,obj_grupo.getCodigo_comida());
                 stm.execute();
                if(stm != null)
                    stm.close();                             
            }
        }   catch (SQLException e) {
             throw new RuntimeException();
            }
     }
       
    public void ConsultaGruposUsuarios(ClienteClass obj_user, String cod_user){
        String sql = "SELECT * FROM orden WHERE cod_cliente = '" + cod_user + "'";
        try(PreparedStatement stm = conn.prepareStatement(sql)){
            stm.execute();
            ResultSet result = stm.executeQuery();
            while(result.next()){
                String coduser= result.getString("cod_cliente");                
                String codmat= result.getString("cod_menu");
                String codgrupo= result.getString("cod_comida");

                obj_user.setName(cod_user);
                
                MenuClass obj = new MenuClass(codmat);
                
                obj_user.List_Materias.add(obj);
                
                
                ComidaClass obj1 = new ComidaClass(codmat,codgrupo);
                
                obj_user.List_Materias.get(1).List_Grupos.add(obj1);
                
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }  
}
