/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.resources;
import docs.logic.Doctores;
import docs.logic.Horario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Ville
 */
public class Conexion {
      DBExecutor executor;

    public Conexion() {
        executor = new DBExecutor("progra4", "citas");
    }
    
     public boolean verificarExistencia(String msj){
        ResultSet rs = executor.ejecutaQuery(msj);
        try {
            return rs.next();
        } catch (SQLException ex) {
            return false;
        }
    }

      public void insertarRegistro(String [] valores)throws Exception {
          executor.prepareStatement(valores);
    }
     
      public Doctores recuperaDoc(String q){
       Doctores d = new Doctores();
          try{
             ResultSet rs = executor.ejecutaQuery(q);
             
             while(rs.next()){
            
             d.setCedula(rs.getString("id"));
             d.setClave(rs.getString("clave"));
             d.setCostoConsulta(rs.getString("costo_cita"));
             d.setDuracion(rs.getString("duracion"));
             d.setEspecialidad(rs.getString("especialidad"));
             d.setLocalidad(rs.getString("localidad"));
             d.setEstado(rs.getString("estado"));
             d.setTipo(rs.getString("tipo"));
             d.setNombre(rs.getString("nombre"));
             
             
             
             }
             
             
          }catch(Exception ex){
            return null;
        }
             return d;
      }
      
       public ArrayList<Horario> recuperHorario(String q){
           ArrayList<Horario> h = new ArrayList<>();
           
           try{
            ResultSet rs = executor.ejecutaQuery(q);
            while(rs.next()){
                
                Horario d = new Horario();
                d.setDesde(rs.getString("desde"));
                d.setHasta(rs.getString("hasta"));
                d.setDia(rs.getString("dia"));
                h.add(d);
                
            }
            }catch(Exception ex){
                return null;
            }
            return h;
           
           
       }
}
