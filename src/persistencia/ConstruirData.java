/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.Empleado;
import vistas.Herramienta;

/**
 *
 * @author gassani
 */
public class ConstruirData {
       private static Connection con = null;
       
       public ConstruirData(miConexion conexion){
           this.con = conexion.buscarConexion();
       }
       
       public void guardarHerramienta(Herramienta h) throws SQLException{
        String query = "INSERT INTO herramienta(nombre, descripcion, stock, estado) VALUES (?,?,?,?)";  
        
        try{
           PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, h.getNombre());
           ps.setString(2, h.getDescripcion());
           ps.setInt(3, h.getStock());
           ps.setBoolean(4, h.getEstado());
           ps.executeUpdate();
           
          ResultSet rs = ps.getGeneratedKeys();
          if(rs.next()){
              h.setId(rs.getInt(1));
          }else{
              System.out.println("No se pudo obtener ID");
        } 
          ps.close();
            System.out.println("Herramienta registrada");
       } catch(SQLException ex){
            Logger.getLogger(ConstruirData.class.getName()).log(Level.SEVERE,null,ex);
       }
       }    
       public Herramienta buscarHerramienta(int stock){
         Herramienta h = null;
         String sql = "SELECT + FROM herramienta WHERE, id = ?";
         
         PreparedStatement ps;
         try{
             ps= con.prepareStatement(sql);
             ps.setInt(1, stock);
             ResultSet rs = ps.executeQuery();
             while (rs.next()){
                 h = new Herramienta();
                 h.setId(rs.getInt("id"));
                 h.setNombre(rs.getString("nombre"));
                 h.setDescripcion(rs.getString("descripcion"));
             }
             ps.close();
         }catch(SQLException ex){
             System.out.println("ups!");
         }
         return h;
       }
       public List<Herramienta> listarHerramienta(){
        Herramienta h = null;
       List<Herramienta> herramienta = new ArrayList<>();          
         String query = "SELECT * FROM herramienta";
         
         PreparedStatement ps;
         try{
             ps= con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
             while (rs.next()){
                 h = new Herramienta();
                 h.setId(rs.getInt("id"));
                 h.setNombre(rs.getString("nombre"));
                 h.setDescripcion(rs.getString("descripcion"));
                 h.setEstado(rs.getBoolean("estado"));  
                 herramienta.add(h);        
             }
             ps.close();
         }catch(SQLException ex){
             System.out.println("ups!");
         }
         return (List<Herramienta>) h;
       }


        public void guardarEmpleado(Empleado e){
        String query = "INSERT INTO empleado(dni,apellido,nombre,acceso,estado) VALUES (?,?,?,?,?)";
        try{ 
            PreparedStatement ps = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, e.getDni());
            ps.setString(2, e.getApellido());
            ps.setString(3, e.getNombre());
            ps.setInt(4, e.getAcceso());
            ps.setBoolean(5, e.getEstado());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
          if(rs.next()){
              e.setId(rs.getInt(1));
          }else{
              System.out.println("No se pudo obtener ID");
        } 
          ps.close();
            System.out.println("Empleado registrado");
}       catch(SQLException ex){
            Logger.getLogger(ConstruirData.class.getName()).log(Level.SEVERE,null,ex);
            
       }
}
        }