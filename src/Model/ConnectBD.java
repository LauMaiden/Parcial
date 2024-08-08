package Model;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;



public class ConnectBD {
    
    private static Connection conn;
   
    public ConnectBD(){
        //conexion Casa
        /*
        String driver = "com.mysql.cj.jdbc.Driver";
        String userdb = "root";
        String passdb = "Admin0101";
        String url = "jdbc:mysql://localhost:3306/bdhotel";
        //Conexion Universidad
        */
        
        String driver = "com.mysql.cj.jdbc.Driver";
        String userdb = "root";
        String passdb = "";
        String url = "jdbc:mysql://localhost:3306/test";

        
        try{
            Class.forName(driver);
            
            conn = DriverManager.getConnection(url, userdb, passdb);
            if(conn != null){
                System.out.println("Conexión establecida exitosamente");
            }
            // Connect?
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("Conexión Fallida:\n\n"+ex);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    public void close() throws SQLException{
        conn.close();
    }

}
