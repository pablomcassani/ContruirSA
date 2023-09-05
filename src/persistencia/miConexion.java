
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class miConexion {
    private String url;
    private String usuario;
    private String password;
    
    private static Connection conexion = null;
    
    public miConexion(String url, String usuario, String pass){
        this.url = url;
        this.usuario = usuario;
        password = pass;
    }
    
    public Connection buscarConexion(){
        if(conexion == null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url,usuario, password);
                
            } catch (SQLException | ClassNotFoundException ex){
                Logger.getLogger(miConexion.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        return conexion;
    }
}
