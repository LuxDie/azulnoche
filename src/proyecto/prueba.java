/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;
import interfaz.Interfaz;
import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class prueba {
    
    public static void main (String[] args) {
        Personaje pers = new Personaje();
        pers.setUbicacion("intro pueblo");
        //Scanner sc = new Scanner(System.in, "iso-8859-1");
        
        interfaz.Interfaz interfaz = new interfaz.Interfaz();
        Cabania cab = new Cabania(pers);
        Bosque bosq = new Bosque(pers);
        SimuCalle calle = new SimuCalle(pers);
        String ret = "";
        boolean boton = false;
        
        interfaz.setVisible(true);
        
        while (!pers.getUbicacion().equals("termino")) {
            String texto = interfaz.textoUsuario();
            switch (pers.getUbicacion()) {
                case "intro pueblo" : ret = textoIntroPueblo(pers);
                case "calle": ret = calle.logica(texto);break;
                case "bosque": ret = bosq.logica(texto);break;
                case "cabania": ret = cab.logica(texto);break;
                case "final": ret = textoFinal(pers);break;
                default:break;
            }
            
            interfaz.ventanaTexto(ret);
        }
        
    }
    
    public static String textoIntroPueblo(Personaje pers) {
        String ret;
        ret = "Bienvenido al juego.";
        pers.setUbicacion("bosque");
        return ret;
    }
    
    public static String textoFinal(Personaje pers) {
        String ret;
        ret = "Y colorín colorado, este cuento ha acabado.";
        pers.setUbicacion("termino");
        return ret;
    }
    
}
