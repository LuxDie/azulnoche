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
 * @author Nicolas
 */
public class SimuCalle {
    private Personaje pers;
    
    public Personaje getPers() {
        return pers;
    }

    private int sector;

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }
    
    public SimuCalle (Personaje pers) {
        this.pers=pers;
        setSector(1);
    }
    
    public String logica (String textoUsuario) {
    	String ret = "";
    	ret = sectores(textoUsuario);
    	return ret;
    }
    
    private String sectores (String textoUsuario) {
    	String ret = "";
        
        if (getSector()==0) {
            pers.setUbicacion("bosque");
            setSector(1);
        } else {
            switch (getSector()) {
                case 1: calle(textoUsuario);break;
                default: ret = textos(999);break;
            }
        }
        
        return ret;
    }
    
    private String calle(String textoUsuario) {
    	String ret = "";
    	ret = textos(1);
        
        while (getSector()==1) {
            switch (textoUsuario) {
                case "tomar mapa":
                    if (pers.getBosque_tengoMapa()==false) {
                    	ret = textos(10);
                    } else {
                    	ret = textos(11);
                    } ;break;
                case "tomar arma puma":
                    if (pers.getBosque_tengoArmaPuma()==false) {
                    	ret = textos(20);
                    } else {
                    	ret = textos(21);
                    } ;break;
                case "tomar arma perro":
                    if (pers.getCabania_tengoArmaPerro()==false) {
                    	ret = textos(30);
                    } else {
                    	ret = textos(31);
                    } ;break;
                case "tomar llave cabaña":
                    if (pers.getCabania_tengoLlave()==false) {
                    	ret = textos(40);
                    } else {
                    	ret = textos(41);
                    } ;break;
                case "ir a bosque":
                	ret = textos(50);
                	setSector(0);break;
                default:ret = textos(0);break;
            }
        }
        
        return ret;
    }
    
    private String textos (int indice) {
    	String ret = "";
        
        switch (indice) {
            //1: intro
            case 1: ret = "Acciones: tomar mapa, tomar arma puma, tomar arma perro, tomar llave cabaña.";break;
            
            //10: tomar mapa, si no lo tengo
            case 10: ret = "Tomo el mapa.";break;
            
            //11: tomar mapa, si ya lo tengo
            case 11: ret = "Ya tengo el mapa.";break;
            
            //20: tomar arma puma, si no la tengo
            case 20: ret = "Tomo el arma para matar al puma.";break;
            
            //21: tomar arma puma, si ya la tengo
            case 21: ret = "Ya tengo el arma para matar al puma.";break;
            
            //30: tomar arma perro, si no la tengo
            case 30: ret = "Tomo el arma para matar al perro.";break;
            
            //31: tomar arma perro, si ya la tengo
            case 31: ret = "Ya tengo el arma para matar al perro.";break;
            
            //40: tomar llave cabaña, si no la tengo
            case 40: ret = "Tomo la llave de la cabaña.";break;
            
            //41: tomar llave cabaña, si ya la tengo
            case 41: ret = "Ya tengo la llave de la cabaña.";break;
            
            //50: ir a bosque
            case 50: ret = "Me dirijo al bosque.";break;
            
            //999: este código debería ser inaccesible
            case 999: ret = "Lamentablemente, este texto no debería mostrarse, y sin embargo aquí me encuentro. ¡He fallado a mis ancestros!. harakiri=true";break;
            
            //0: si el jugador escribe un texto que no está en la lista de comandos
            case 0: ret = "Lo siento, no comprendo el texto.";break;
            
            //default: tira error si el código pedido no está en este método
            default: ret = "Error. Código no reconocido.";break;
        }
        
        return ret;
    }

}
