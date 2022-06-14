/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.logic;

/**
 *
 * @author Ville
 */
public class Usuario {
    
    String id;
    String clave;

    public Usuario() {
    }

    public Usuario(String id, String clave) {
        this.id = id;
        this.clave = clave;
    }

    public String getCedula() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
