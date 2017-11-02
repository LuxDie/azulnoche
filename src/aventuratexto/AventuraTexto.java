/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aventuratexto;

import auxiliares.ManipulacionDeTextos;
import aventuratexto.lugares.Bar;
import aventuratexto.lugares.CalleCentro;
import aventuratexto.lugares.CalleEste;
import aventuratexto.lugares.CalleOeste;
import java.util.Scanner;

public class AventuraTexto {
    public static final String ENCONST = "En construcción. Vuelve pronto!";
    public static final String ORDEN_INVALIDA = "No entiendo esa orden.";
    public static final int ANCHO_PANTALLA = 120;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManipulacionDeTextos txt = new ManipulacionDeTextos();
        System.out.println("Deseas crear un personaje?");
        String orden = scanner.nextLine();
        while (!orden.equalsIgnoreCase("si") && !orden.equalsIgnoreCase("no")) {
            System.out.println(ORDEN_INVALIDA);
            orden = scanner.nextLine();
        }

        if(orden.equalsIgnoreCase("si")) {

            System.out.println("Que sexo quieres que sea?");
            String sexo = scanner.nextLine();
            System.out.println("Ingresa el nombre del personaje");
            String nombre = scanner.nextLine();

            if(sexo.equalsIgnoreCase("hombre") || sexo.equalsIgnoreCase("h")) {
              Hombre personaje = new Hombre(nombre);
            }

            if(sexo.equalsIgnoreCase("mujer") || sexo.equalsIgnoreCase("m")){
                Mujer personaje = new Mujer(nombre);
            }
            
            System.out.println("");
            System.out.println("Bienvenido " + nombre + " a esta historia. Estamos en construcción.");
            System.out.println("");
            System.out.println("El camino no se ve bien a través el parabrisas, pero de alguna manera te orientas para llegar al pueblo.");
            System.out.println("Cuando estás a metros de la primer casa, el motor comienza a ahogarse, para luego detenerse. Tus intentos de reivivirlo son inútiles.");
            System.out.println("Resignado, te bajas del auto y comienzas a caminar.");
            System.out.println("");
            CalleEste calleEste = new CalleEste();
            System.out.println("");
            System.out.println(txt.formatearTexto(calleEste.descripcion, ANCHO_PANTALLA));
            System.out.println("");
            orden = scanner.nextLine();
            while (!orden.equalsIgnoreCase("entrar casa izquierda") && !orden.equalsIgnoreCase("avanzar") && !orden.equalsIgnoreCase("entrar casa derecha")) {
                System.out.println(ORDEN_INVALIDA);
                orden = scanner.nextLine();
            }
            switch (orden) {
                default:
                    System.out.println(ENCONST);
                    break;
                case "avanzar":
                    CalleCentro calleCentro = new CalleCentro();
                    System.out.println("");
                    System.out.println(txt.formatearTexto(calleCentro.descripcion, ANCHO_PANTALLA));
                    System.out.println("");
                    orden = scanner.nextLine();
                    while (!orden.equalsIgnoreCase("entrar casa") && !orden.equalsIgnoreCase("avanzar") && !orden.equalsIgnoreCase("volver") && !orden.equalsIgnoreCase("ir bosque")) {
                        System.out.println(ORDEN_INVALIDA);
                        orden = scanner.nextLine();
                    }
                    switch (orden) {
                        default:
                            System.out.println(ENCONST);
                            break;
                        case "avanzar":
                            CalleOeste calleOeste = new CalleOeste();
                            System.out.println("");
                            System.out.println(txt.formatearTexto(calleOeste.descripcion, ANCHO_PANTALLA));
                            System.out.println("");
                            orden = scanner.nextLine();
                            while (!orden.equalsIgnoreCase("entrar casa") && !orden.equalsIgnoreCase("volver") && !orden.equalsIgnoreCase("entrar bar")) {
                                System.out.println(ORDEN_INVALIDA);
                                orden = scanner.nextLine();
                            }
                            switch (orden) {
                                default:
                                    System.out.println(ENCONST);
                                    break;
                                case "entrar bar":
                                    Bar bar = new Bar();
                                    System.out.println("");
                                    System.out.println(txt.formatearTexto(bar.obtenerSecuenciaLectura(0), ANCHO_PANTALLA));
                                    System.out.println("");
                                    orden = scanner.nextLine();
                                    while (!orden.equalsIgnoreCase("tomar") && !orden.equalsIgnoreCase("tomar cerveza") && !orden.equalsIgnoreCase("tomar agua") && !orden.equalsIgnoreCase("salir")) {
                                        System.out.println(ORDEN_INVALIDA);
                                        orden = scanner.nextLine();
                                    }
                                    while (!orden.equalsIgnoreCase("salir")) {
                                        switch (orden) {
                                            default:
                                            System.out.println(ORDEN_INVALIDA);
                                            break;
                                            case "tomar":
                                                System.out.println(bar.obtenerSecuenciaLectura(2));
                                                break;
                                            case "tomar agua":
                                                System.out.println(bar.obtenerSecuenciaLectura(3));
                                                break;
                                            case "tomar cerveza":
                                                System.out.println(bar.obtenerSecuenciaLectura(4));
                                                break;
                                        }
                                        orden = scanner.nextLine();
                                    }
                                    System.out.println(ENCONST);
                            }
                    }
                            
            }
        } else {
            System.out.println("Que tengas un buen día.");
            // ezequiel no quiere que cambie los fuentes :(
        }
    }
    
}
