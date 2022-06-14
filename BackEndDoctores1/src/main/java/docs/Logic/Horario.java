/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.logic;

/**
 *
 * @author Ville
 */
public class Horario {
    
    String dia;
    String desde;
    String hasta;

    public Horario() {
    }

    public Horario(String dia, String desde, String hasta) {
        this.dia = dia;
        this.desde = desde;
        this.hasta = hasta;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }
    
    
    
}
