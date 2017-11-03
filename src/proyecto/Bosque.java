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
public class Bosque {
    private Personaje pers;

    public Personaje getPers() {
        return pers;
    }

    //Sector 1: entrada al bosque, 2: bosque cercano. 3: bosque profundo
    //Sector 0: volver al pueblo, sector 9: ir a la cabaña
    private int sector;

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }
    
    public Bosque (Personaje pers) {
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
    	do {
            switch (getSector()) {
                case 1: ret = entradaBosque(textoUsuario);break;
                case 2: ret = bosqueCercano(textoUsuario);break;
                case 3: ret = bosqueProfundo(textoUsuario);break;
                default: ret = textos(999);break;
            }
        } while (getSector()!=0 && getSector()!=9);
        
        switch (getSector()) {
            case 0: pers.setUbicacion("calle");setSector(1);break;
            case 9: pers.setUbicacion("cabania");setSector(3);break;
            default: /*ERROR*/ ret = textos(999); break;
        }
        
        return ret;
    }
    
    private String entradaBosque(String textoUsuario) {
    	String ret = "";
        if (pers.getBosque_visiteBosque() == false) {
        	ret = textos(10);
            pers.setBosque_visiteBosque(true);
        } else {
        	ret = textos(11);
        }
        
        while (getSector()==1) {
            switch (textoUsuario) {
                case "mirar": ret = textos(10);break;
                case "mirar al norte": ret = textos(20);break;
                case "mirar al oeste": ret = textos(21);break;
                case "mirar al este":
                    if (pers.getBosque_tomeArdilla()==false) {
                    	ret = textos(22);pers.setBosque_mireEste1(true);
                    } else {
                    	ret = textos(30);pers.setBosque_mireEste2(true);
                    } break;
                case "mirar al sur": ret = textos(23);break;
                case "mirar ardilla": ret = textos(24);break;
                case "tomar ardilla": 
                    if (pers.getBosque_mireEste1()==true) {
                    	ret = textos(25);
                        pers.setBosque_tomeArdilla(true);
                    } else {
                    	ret = textos(90);
                    } break;
                case "tomar cuchillo":
                    if (pers.getBosque_mireEste2()==true) {
                    	ret = textos(31);
                    	pers.setBosque_tomeCuchillo(true);
                    } else {
                    	ret = textos(91);
                    } break;
                case "ir al sur": setSector(2);break;
                case "ir al norte": setSector(0);break;
                default:ret = textos(0);break;
            }
        }
        
        return ret;
    }
    
    private String bosqueCercano(String textoUsuario) {
    	String ret = "";
        if (pers.getBosque_visiteBosque() == false) {
        	ret = textos(40);
        } else {
        	ret = textos(41);
        }
        
        while (getSector()==2) {
            switch (textoUsuario) {
                case "mirar": ret = textos(40);break;
                case "mirar al norte": ret = textos(51);break;
                case "mirar al sur":
                    if (pers.getBosque_mireMapa()==true) {
                    	ret = textos(55);
                    } else {
                    	ret = textos(52);
                    } break;
                case "mirar al este": ret = textos (53);break;
                case "mirar al oeste": ret = textos (54);break;
                case "ir al norte": setSector(1);break;
                case "ir al sur":
                    if (pers.getBosque_mireMapa()==true) {
                        setSector(3);
                    } else {
                    	ret = textos(93);
                    } break;
                case "mirar mapa":
                    if (pers.getBosque_tengoMapa()==true) {
                    	ret = textos(50);
                    	pers.setBosque_mireMapa(true);
                    } else {
                    	ret = textos(92);
                    } break;
                default:ret = textos(0);break;
            }
        }
        
        return ret;
    }
    
    private String bosqueProfundo(String textoUsuario) {
    	String ret = "";
        if (pers.getBosque_matePuma()==true) {
            ret = textos(74);
        } else if (pers.getBosque_visiteBosque() == false && pers.getBosque_tengoArmaPuma()==false) {
        	ret = textos(70);
            setSector(2);
        } else if (pers.getBosque_visiteBosque() == false  && pers.getBosque_tengoArmaPuma()==true) {
        	ret = textos(71);
        } else if (pers.getBosque_visiteBosque() == true  && pers.getBosque_tengoArmaPuma()==false) {
        	ret = textos(72);
            setSector(2);
        } else if (pers.getBosque_visiteBosque() == true  && pers.getBosque_tengoArmaPuma()==true) {
        	ret = textos(73);
        } else {
        	ret = textos(999);
        }
        
        while (getSector()==3) {
            switch (textoUsuario) {
                case "mirar": ret = textos(74);break;
                case "ir al norte": setSector(2);break;
                case "ir al sur": setSector(9);break;
                default:ret = textos(0);break;
            }
        }
        
        return ret;
    }
    
    private String textos (int indice) {
    	String ret = "";
        
        switch (indice) {
            //10: intro entrada del bosque, si es la primera vez que está en el bosque
            case 10: ret = "Me encuentro en un camino rodeado completamente por árboles. Al norte, veo mis huellas en el polvo del camino, que continúa hacia el sur, perdiéndose en el horizonte. Al este y al oeste, mis ojos se pierden en la espesura del bosque, y tengo la sensación de que la frase \"El árbol que tapa el bosque\" es un completo delirio.";break;
            
            //11: intro entrada del bosque, si ya estuvo
            case 11: ret = "Estoy nuevamente en el bosque.";break;
            
            //20: mirar norte
            case 20: ret = "El camino por el que vine. Desde este lugar, el pueblo queda completamente oculto.";break;
            
            //21: mirar oeste
            case 21: ret = "Los árboles al oeste tienen musgo cubriendo completamente sus troncos.";break;
            
            //22: mirar este, si no miré ardilla
            case 22: ret = "Hay una ardilla en uno de los árboles.";break;
            
            //23: mirar sur
            case 23: ret = "El camino polvoriento parece no haberse recorrido nunca.";break;
            
            //24: mirar ardilla
            case 24: ret = "Es... es una ardilla.";break;
            
            //25: tomar ardilla
            case 25: ret = "Al acercar mi mano, la ardilla salió corriendo, espantada. ¿\"Tomar ardilla\", en qué estaba pensando?";break;
            
            //30: mirar este, si miré ardilla
            case 30: ret = "Ahora que la ardilla no está, me di cuenta de que hay una marca en el árbol. Al mirar detenidamente, se nota que algo impactó en el tronco y desprendió un trozo. Al mirar en la base del árbol, encuentro un cuchillo.";break;
            
            //31: tomar cuchillo
            case 31: ret = "El cuchillo tiene marcas de sangre en el filo.";break;
            
            //40: intro bosque cercano, si primera vez
            case 40: ret = "Me interné en el bosque. El sendero ya no se distingue del resto.";break;
            
            //41: intro bosque cercano, si ya estuve
            case 41: ret = "Nuevamente me interné en el bosque.";break;
            
            //50: mirar mapa, si tengo mapa
            case 50: ret = "En el mapa hay un sendero marcado. La espesura del bosque no me permitía verlo.";break;
            
            //51: mirar norte
            case 51: ret = "Es el sendero por el que vine.";break;
            
            //52: mirar sur, si no tengo mapa
            case 52: ret = "Ya no consigo diferenciar al sendero del bosque espeso.";break;
            
            //53: mirar este
            case 53: ret = "Hacia el este, bosque. Todo bosque.";break;
            
            //54: mirar oeste
            case 54: ret = "Hacia el oeste, bosque. Todo bosque";break;
            
            //55: mirar sur, si tengo mapa
            case 55: ret = "Gracias al mapa puedo ver el sendero.";break;

            //70: intro bosque profundo, si es la primera vez, no maté al puma y no tengo el arma
            case 70: ret = "Estoy en lo más profundo del bosque. Hay un puma, pero no tengo nada para defenderme. Mejor me vuelvo.";break;
            
            //71: intro bosque profundo, si es la primera vez, no maté al puma y sí tengo el arma
            case 71: ret = "Estoy en lo más profundo del bosque. Hay un puma, pero por suerte pude matarlo con el arma.";break;
            
            //72: intro bosque profundo, si no es la primera vez, no maté al puma y no tengo el arma
            case 72: ret = "Estoy nuevamente en lo más profundo del bosque. Aun está el puma, mejor me vuelvo.";break;
            
            //73: intro bosque profundo, si no es la primera vez, no maté al puma y sí tengo el arma
            case 73: ret = "Estoy nuevamente en lo más profundo del bosque. Aun está el puma, pero por suerte pude matarlo con el arma.";break;
            
            //74: intro bosque profundo, si ya maté al puma
            case 74: ret = "Estoy nuevamente en lo más profundo del bosque.";break;
            
            //90: tomar ardilla, si no mire este 1
            case 90: ret = "Eh... ¿qué ardilla?";break;
            
            //91: tomar cuchillo, si no mire este 2
            case 91: ret = "No entiendo qué cuchillo podría tomar.";break;
            
            //92: mirar mapa, si no tengo mapa
            case 92: ret = "No se qué mapa podría mirar, si no tengo ninguno.";break;
            
            //93: ir al sur, si no tengo mapa
            case 93: ret = "El camino termina aquí, no puedo ir más al sur.";break;
            
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
