/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aventuratexto.lugares;

import aventuratexto.lugares.bar.Barra;
import aventuratexto.lugares.bar.Botella;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Bar {
    private Barra barra;
    
    private ArrayList<String> secuencialectura;

    public Bar() {
        secuencialectura = new ArrayList<String>();
        secuencialectura.add("En el bar se puede ver muy poco, todo esta oscuro... al  NORTE se ve una barra con dos botellas, una de cerveza y otra de agua. Tambien hay una copa...Afuera hace mucho calor y no te importa que las botells no estan frias, solo quieres beber algo...");
        secuencialectura.add("Puedes ir a cualquier lugar, solo tienes que escribir CAMINAR + NORTE (SUR, ETC)");
        secuencialectura.add("Que bebida deseas tomar? agua o cerveza");
        secuencialectura.add("El agua esta caliente pero al menos calma un poco la sed...");
        secuencialectura.add("La cerveza esta re caliente y no te gusta para nada...");
        
        
        Botella botellaAgua = new Botella();
        botellaAgua.definirContenido("Agua");
        
        Botella botellaCerveza = new Botella();
        botellaCerveza.definirContenido("Cerveza");
        
        barra = new Barra();
        
        this.barra.agregarBotella(botellaAgua);
        this.barra.agregarBotella(botellaCerveza);
        
        
    }
    
    public String obtenerSecuenciaLectura(int posicion) {
        return this.secuencialectura.get(posicion);
    }
    
    
    
}
