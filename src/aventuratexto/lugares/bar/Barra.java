/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aventuratexto.lugares.bar;

import aventuratexto.lugares.bar.Botella;
import aventuratexto.lugares.bar.Copa;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Barra {
    private ArrayList<Copa> copas = new ArrayList<Copa>();
    private ArrayList<Botella> botellas = new ArrayList<Botella>();
    
    public void agregarBotella(Botella botella) {
        this.botellas.add(botella);
    }
    
    public void agregarCopa(Copa copa) {
        this.copas.add(copa);
    }
}
