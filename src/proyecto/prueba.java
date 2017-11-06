/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Alumno
 */
public class prueba {
    
    public static void main (String[] args) {
        Controlador controlador = new Controlador();
        interfaz.Interfaz interfaz = new interfaz.Interfaz(controlador);
        interfaz.setVisible(true);
    }
}