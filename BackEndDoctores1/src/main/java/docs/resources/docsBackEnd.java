/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.resources;
import java.util.List;
import javax.ws.rs.Consumes;
import docs.logic.Horario;
import docs.logic.Doctores;
import docs.logic.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Provider.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.DELETE;
import javax.ws.rs.NotAcceptableException;
import javax.ws.rs.POST;
import javax.ws.rs.core.Context;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author Ville
 */
@Resource(lookup = "jdbc/oracledb")
@Path("/doctores")
public class docsBackEnd {
    String location="C:/images/";
      
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("insertarDoc")
     public void create(Doctores d) {         
        Conexion service = new Conexion();         
        //d.gsonHorario(d.getDias());
        String valores[];
        String valores2[];
       try{
          
         valores = new String[10];
         valores[0] =  "insert into medicos(id,clave,tipo,nombre,estado,costo_cita,duracion,"
                 + "localidad,especialidad) values (?,?,?,?,?,?,?,?,?)";
         valores[1] = d.getCedula();
         valores[2] = d.getClave();
         valores[3] = "1"; //1 doctor
         valores[4] = d.getNombre();
         valores[5] = "0"; //0 sin aprobar
         valores[6] = String.valueOf(d.getCostoConsulta());
         valores[7] = d.getDuracion(); //to do
         valores[8] = d.getLocalidad();
         valores[9] = d.getEspecialidad();
         service.insertarRegistro(valores);
         
         valores2 = new String[5];
                
         for(Horario h: d.getHorario()){
         
            valores2[0] = "insert into horario(id_doc,dia,desde,hasta) values (?,?,?,?)";
            valores2[1] = d.getCedula();
            valores2[2] = h.getDia();
            valores2[3] = h.getDesde();
            valores2[4] = h.getHasta();
            service.insertarRegistro(valores2);
         }
         
       }catch (Exception ex) {
            throw new NotAcceptableException(); 
        }
    }
     
     
    @Context
    HttpServletRequest request;
     
     
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public Doctores login (Usuario u) {
    
        Conexion service = new Conexion();   
        String valores = "select * from medicos where id = '" + u.getCedula() + "' and clave = '" + u.getClave() + "'";
        
        if(service.verificarExistencia(valores)){
            Doctores d;
            d = service.recuperaDoc(valores);
            String mensaje = "select * from horario where id_doc = '" + d.getCedula() + "'";
            d.setHorario(service.recuperHorario(mensaje));
            request.getSession(true).setAttribute("doctor", d);
            return d;
        }else{
            return null;
        } 
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA) 
    @Path("{cedula}/imagen")
    public void addImage(@PathParam("cedula") String cedula, @FormDataParam("imagen") InputStream in) {  
        try{
                OutputStream out = new FileOutputStream(new File(location + cedula));
                in.transferTo(out);
                out.close();
            } catch (Exception ex) {
                throw new NotAcceptableException(); 
            }
    }
}

