/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author alumno
 */
public class Controlador {
    Personaje pers = new Personaje();

    Cabania cab = new Cabania(pers);
    Bosque bosq = new Bosque(pers);
    SimuCalle calle = new SimuCalle(pers);
    String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    {
    pers.setUbicacion("intro pueblo");
    }

    String ret = "";
    boolean boton = false;
    
    public Controlador () {
        System.out.println("Contr ok");
    }

    public String accion (String texto) {
        if (!pers.getUbicacion().equals("termino")) {
            switch (pers.getUbicacion()) {
                case "intro pueblo" : ret = textoIntroPueblo(pers);
                case "calle": ret = calle.logica(texto);break;
                case "bosque": ret = bosq.logica(texto);break;
                case "cabania": ret = cab.logica(texto);break;
                case "final": ret = textoFinal(pers);break;
                default:break;
            }
        }
        System.out.println(ret);
        
        return ret;
    }
    
    public String textoIntroPueblo(Personaje pers) {
        String ret;
        ret = "Bienvenido al juego.";
        pers.setUbicacion("bosque");
        return ret;
    }
    
    public String textoFinal(Personaje pers) {
        String ret;
        ret = "Y colorín colorado, este cuento ha acabado.";
        pers.setUbicacion("termino");
        return ret;
    }
    
}
