
package aventuratexto;

import javax.swing.JOptionPane;

public class Hombre {
  
 String nombre;
 int edad = 20;
 int fuerza = 50;
 int peso = 80;
    
 public Hombre(String nombre){
  this.nombre = nombre;
  System.out.println("Se creo un personaje hombre llamado " + this.nombre);
 }   
    
}
