/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.logic;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ville
 */
public class Doctores {
      String cedula;
      String nombre;
      String clave;
      String especialidad;
      String costoConsulta;
      String localidad;
      ArrayList<Horario> horario;
      String duracion;
      String estado;
      String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
      
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
      
    public Doctores() {
       horario = new ArrayList<>() ;
    }

    public Doctores(String cedula, String nombre, String clave, String especialidad, String costoConsulta, String localidad, ArrayList<Horario> horario, String duracion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.clave = clave;
        this.especialidad = especialidad;
        this.costoConsulta = costoConsulta;
        this.localidad = localidad;
        this.horario = horario;
        this.duracion = duracion;
    }
    
   

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCostoConsulta() {
        return costoConsulta;
    }

    public void setCostoConsulta(String costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public ArrayList<Horario> getHorario() {
        return horario;
    }

    public void setHorario(ArrayList<Horario> horario) {
        this.horario = horario;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

   
  
    
}
