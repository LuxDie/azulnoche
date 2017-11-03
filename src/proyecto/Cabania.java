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
public class Cabania {
    private Personaje pers;
        
    public Personaje getPers() {
        return pers;
    }

    //Sector 1: delante de la cabaña, 2: dentro de la cabaña. 3: detrás de la cabaña
    //Sector 0: volver al bosque, sector 9: ir al final
    private int sector;

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        this.sector = sector;
    }
    
    public Cabania (Personaje pers) {
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
                case 1: ret = delanteCabania(textoUsuario);break;
                case 2: ret = dentroCabania(textoUsuario);break;
                case 3: ret = detrasCabania(textoUsuario);break;
                default: ret = textos(999);break;
            }
        } while (getSector()!=0 && getSector()!=9);
        
        switch (getSector()) {
            case 0: pers.setUbicacion("bosque"); break;
            case 9: pers.setUbicacion("final");break;
            default: /*ERROR*/ ret = textos(999); break;
        }
        
        return ret;
    }
    
    private String delanteCabania (String textoUsuario) {
    	String ret = "";
        if (pers.getCabania_matePerro()==true) {
        	ret = textos(14);
        } else if (pers.getCabania_visiteCabania() == false && pers.getCabania_tengoArmaPerro()==false) {
        	ret = textos(10);
            setSector(0);
        } else if (pers.getCabania_visiteCabania() == false && pers.getCabania_tengoArmaPerro()==true) {
        	ret = textos(11);
        } else if (pers.getCabania_visiteCabania() == true && pers.getCabania_tengoArmaPerro()==false) {
        	ret = textos(12);
            setSector(0);
        } else if (pers.getCabania_visiteCabania() == true && pers.getCabania_tengoArmaPerro()==true) {
        	ret = textos(13);
        } else {
        	ret = textos(999);
        }

        while (getSector()==1) {
            switch (textoUsuario) {
                case "mirar": ret = textos(14);break;
                case "mirar cabaña": ret = textos(20);
                	pers.setCabania_mireCabania(true);break;
                case "mirar puerta":
                    if (pers.getCabania_mireCabania()==true && pers.getCabania_puertaAbierta()==false) {
                    	ret = textos(21);
                    	pers.setCabania_mirePuerta(true);
                    } else if (pers.getCabania_mireCabania()==true && pers.getCabania_puertaAbierta()==true) {
                    	ret = textos(22);
                    } else {
                    	ret = textos(91);
                    } break;
                case "mirar cerradura":
                    if (pers.getCabania_mirePuerta()==true && pers.getCabania_tengoLlave()==false) {
                    	ret = textos(23);
                    } else if (pers.getCabania_mirePuerta()==true && pers.getCabania_tengoLlave()==true) {
                    	ret = textos(24);
                    	pers.setCabania_puertaAbierta(true);
                    } else {
                    	ret = textos(92);
                    } break;
                case "entrar": setSector(2);break;
                case "ir a bosque": setSector(0);break;
                default:ret = textos(0);break;
            }
        }

        return ret;
    }
    
    private String dentroCabania (String textoUsuario) {
    	String ret = "";
        if (pers.getCabania_entreCabania() == false) {
        	ret = textos(40);
        } else {
        	ret = textos(41);
        }
        
        while (getSector()==2) {
            switch (textoUsuario) {
                case "mirar": ret = textos(40);break;
                case "mirar anafe": ret = textos(42);break;
                case "mirar cuerpo": ret = textos(47);break;
                case "mirar cama": ret = textos(43);break;
                case "mirar ventana": ret = textos(44);
                	pers.setCabania_mireVentana(true);break;
                case "mirar mesa": ret = textos(45);
                	pers.setCabania_mireMesa(true);break;
                case "tomar llaves":
                    if (pers.getCabania_mireMesa()==true && pers.getCabania_tomeLlaves()==false) {
                    	ret = textos(46);
                    	pers.setCabania_tomeLlaves(true);
                    } else if (pers.getCabania_mireMesa()==true && pers.getCabania_tomeLlaves()==true) {
                    	ret = textos(95);
                    } else {
                    	ret = textos(94);
                    } break;
                case "tomar papel":
                    if (pers.getCabania_mireMesa()==true && pers.getCabania_tomePapel()==false) {
                    	ret = textos(48);
                    	pers.setCabania_tomePapel(true);
                    } else if (pers.getCabania_mireMesa()==true && pers.getCabania_tomePapel()==true) {
                    	ret = textos(96);
                    } else {
                    	ret = textos(97);
                    } break;
                case "ir a puerta sur": setSector(1);break;
                case "ir a muelle": case "ir a puerta norte": 
                    if (pers.getCabania_mireVentana()==true) {
                    	ret = textos(60);
                    } else {
                    	ret = textos(93);
                    } setSector(3);break;
                default:ret = textos(0);break;
            }
        }

        return ret;
    }
    
    private String detrasCabania (String textoUsuario) {
    	String ret = "";
        if (pers.getCabania_entreMuelle() == false) {
            ret = textos(70);
        } else {
        	ret = textos(71);
        }
        
        while (getSector()==3) {
            switch (textoUsuario) {
                case "mirar": ret = textos(70);break;
                case "ir a cabaña": ret = textos(72);
                	setSector(2);break;
                case "mirar lancha": ret = textos(73);break;
                case "ir a lancha":
                    if (pers.getCabania_tomeLlaves()==true) {
                    	ret = textos(74);
                    } else {
                    	ret = textos(75);
                    } break;
                case "ir a casa": ret = textos(80);
                	setSector(9);break;
            }
        }
        
        return ret;
    }
    
    private String textos (int indice) {
    	String ret = "";
        
        switch (indice) {
            //10: intro fuera de la cabaña, si es la primera vez que está en la cabaña, no mató al perro, y no tiene el arma
            case 10: ret = "Llegué a una cabaña, aunque no recuerdo que haya habido algo en este lugar. Hay un perro custodiándola, mejor me vuelvo.";break;
            
            //11: intro fuera de la cabaña, si es la primera vez que está en la cabaña, no mató al perro, y sí tiene el arma
            case 11: ret = "Llegué a una cabaña, aunque no recuerdo que haya habido algo en este lugar. Hay un perro bastante agresivo custodiándola, pero por suerte tengo un arma y pude matarlo.";break;
            
            //12: intro fuera de la cabaña, si no es la primera vez que está en la cabaña, no mató al perro, y no tiene el arma
            case 12: ret = "Me encuentro nuevamente en las inmediaciones de la cabaña. Aun está el perro custodiándola, mejor me vuelvo.";break;
            
            //13: intro fuera de la cabaña, si no es la primera vez que está en la cabaña, no mató al perro, y sí tiene el arma
            case 13: ret = "Me encuentro nuevamente en las inmediaciones de la cabaña. Aun está el perro custodiándola, pero por suerte tengo un arma y pude matarlo.";break;
            
            //14: intro fuera de la cabaña, si no es la primera vez que está en la cabaña, y ya mató al perro
            case 14: ret = "Me encuentro nuevamente en las inmediaciones de la cabaña.";break;
            
            //20: mirar la cabaña desde afuera
            case 20: ret = "La cabaña tiene una puerta.";break;
            
            //21: mirar puerta, si está cerrada
            case 21: ret = "La puerta está cerrada con llave. La cerradura parece reciente.";break;
            
            //22: mirar puerta, si está abierta
            case 22: ret = "La puerta está abierta.";break;
            
            //23: mirar cerradura, si no tiene la llave
            case 23: ret = "Podría intentar abrir la puerta si tuviera alguna llave.";break;
            
            //24: mirar cerradura, si tiene la llave
            case 24: ret = "Meto la llave en la cerradura. Coincide. Al abrir la puerta, un olor nauseabundo invade todo el lugar. Conozco este olor, y nunca trae nada bueno.";break;
            
            //40: intro dentro de la cabaña, si es la primera vez que entró a la cabaña
            case 40: ret = "En una silla hay una hombre sentado. En realidad, sentado es una forma de decir. Tiene la cabeza destrozada y un revólver en una mano. Sobre una de las paredes hay una mesada con un anafe, y una ventana detrás. En un rincón de la pared opuesta una cama, y en el medio, una mesa con un par de sillas. Sobre la pared del norte hay otra puerta, me pregunto qué habrá del otro lado.";break;
            
            //41: intro dentro de la cabaña, si ya estuvo adentro de la cabaña
            case 41: ret = "Estoy nuevamente dentro de la cabaña.";break;
            
            //42: mirar anafe
            case 42: ret = "No hay nada sobre el anafe.";break;
            
            //43: mirar cama
            case 43: ret = "No hay nada (ni nadie) sobre la cama.";break;
            
            //44: mirar ventana
            case 44: ret = "Puedo ver el lago, aunque por la inundación nunca lo vi tan alto. Hay una especie de muelle improvisado.";break;
            
            //45: mirar mesa
            case 45: ret = "Sobre la mesa hay un papel escrito. Encima hay un llavero, que parecería ser de algún auto.";break;
            
            //46: tomar llaves, si miré mesa
            case 46: ret = "Tomé las llaves. El llavero tiene un ancla, ¿será de una lancha?";break;
            
            //47: mirar cuerpo
            case 47: ret = "Al mirar bien, noto que se trata de Don Carlo' (o como se llame el tipo).";break;
            
            //48: tomar papel
            case 48: ret = "Es una confesión del suicida. Me di cuenta porque comienza con \"Señor Juez\"";break;
            
            //60: salir al muelle
            case 60: ret = "La puerta de la pared norte también está cerrada con llave. Intento abrirla con la llave, y, ¡funciona!.";break;
            
            //70: primera vez que está en el muelle
            case 70: ret = "Me llama la atención que haya un muelle construido, ya que el lago nunca estuvo tan alto. Amarrado al muelle hay una lancha. Cruzando el lago, a lo lejos, veo una casa..";break;
            
            //71: si ya estuvo en el muelle
            case 71: ret = "Estoy nuevamente en el muelle.";break;
            
            //72: volver a la cabaña desde el muelle
            case 72: ret = "Decido entrar nuevamente a la cabaña.";break;
            
            //73: mirar lancha desde el muelle
            case 73: ret = "Esta lancha podría servirme para cruzar el lago.";break;
            
            //74: ir a lancha, si tengo las llaves
            case 74: ret = "Las llaves que encontré en la mesa podrían ser de la lancha. Las pruebo, y efectivamente, la lancha funciona.";break;
            
            //75: ir a lancha, sin las llaves
            case 75: ret = "Si tan solo tuviera las llaves para arrancar la lancha, podría usarla para cruzar el lago.";break;
            
            //80: cruzar el lago
            case 80: ret = "Me decido a cruzar el lago para ir a la casa que está del otro lado.";break;
            
            //91: mirar puerta, si no miró cabaña
            case 91: ret = "No sé si existe alguna puerta cerca para poder verla.";break;
            
            //92: mirar cerradura, si no miró puerta
            case 92: ret = "No sé si existe alguna cerradura cerca para poder verla.";break;
            
            //93: ir al muelle, si no miré por la ventana
            case 93: ret = "A qué muelle podría ir, si aquí no veo ninguno.";break;
            
            //94: tomar llaves, si no miré mesa
            case 94: ret = "No veo qué llaves podría tomar.";break;
            
            //95: tomar llaves, si ya las tomé
            case 95: ret = "Eh... ya las tomé.";break;
            
            //96: tomar papel, si ya lo tomé
            case 96: ret = "Eh... ya lo tomé.";break;
            
            //97: tomar papel, si no miré mesa
            case 97: ret = "No veo qué papel podría tomar";break;
            
            //99: vuelve al bosque
            case 99: ret = "Vuelvo al bosque.";break;
            
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
