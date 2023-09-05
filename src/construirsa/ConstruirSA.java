
package construirsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.ConstruirData;
import persistencia.miConexion;
import vistas.Empleado;
import vistas.Herramienta;

public class ConstruirSA {


    private Herramienta Herramientas;
    private miConexion conexion;
      

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        Herramienta destornillador = new Herramienta("Destornillador","Phillips",3,true);
//        Herramienta taladro = new Herramienta("Taladro","Bosch",3,true);
//        new ConstruirSA().conectar(destornillador);
//        System.out.println("Herramienta "+destornillador.getNombre()+" ingresada con exito.");
//        new ConstruirSA().conectar(taladro);
//        System.out.println("Herramienta "+taladro.getNombre()+" ingresada con exito.");
//           Empleado castelli = new Empleado(34198540, "Castelli", "Pablo", 1, true);     
//           Empleado robledo = new Empleado(32740825, "Robledo", "Carlos", 0, false);     
//           Empleado miranda = new Empleado(45308862, "Miranda", "Luciana", 1, true);
//           new ConstruirSA().conectar(castelli);
//           new ConstruirSA().conectar(robledo);
//           new ConstruirSA().conectar(miranda);
//           
       
          Class.forName("org.mariadb.jdbc.Driver");
           Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/construirsa", "root", "");
           
//             String sql ="SELECT * FROM herramienta WHERE herramienta.stock >3;";
             String sql ="DELETE  FROM empleado WHERE empleado.idEmpleado = 1;";
            PreparedStatement ps = conn.prepareStatement(sql);
           ResultSet resultado= ps.executeQuery();
           while(resultado.next()){
//               System.out.println("herramientas con stock mayor a 3 : "+resultado.getString("nombre"));
                 System.out.println("Primer empleado llamado: "+resultado.getString("apellido")+" borrado.");
      
           }
    }
   
     
    void conectar(Herramienta tool) throws SQLException{
    conexion = new miConexion(
            
            "jdbc:mariadb://localhost/construirsa","root","");
    ConstruirData conn = new ConstruirData(conexion);
    conn.guardarHerramienta(tool);
}  
    void conectar(Empleado empleado) throws SQLException{
    conexion = new miConexion(
            
            "jdbc:mariadb://localhost/construirsa","root","");
    ConstruirData conn = new ConstruirData(conexion);
    conn.guardarEmpleado(empleado);
}
 
}
