/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

/**
 *
 * @author Nicolas
 */
public class Personaje {
    private String ubicacion="";
    
    //En el bosque
    private boolean bosque_visiteBosque;

    private boolean bosque_mireEste1;
    private boolean bosque_mireEste2;
    private boolean bosque_mireMapa;
    private boolean bosque_tengoMapa;
    private boolean bosque_tomeArdilla;
    private boolean bosque_tomeCuchillo;
    private boolean bosque_tengoArmaPuma;
    private boolean bosque_matePuma;
    
    //En la cabaña
    private boolean cabania_tengoLlave;
    private boolean cabania_visiteCabania;
    private boolean cabania_mireCabania;
    private boolean cabania_mirePuerta;
    private boolean cabania_mireVentana;
    private boolean cabania_mireMesa;
    private boolean cabania_tomeLlaves;
    private boolean cabania_tomePapel;
    private boolean cabania_tengoArmaPerro;
    private boolean cabania_matePerro;
    private boolean cabania_puertaAbierta;
    private boolean cabania_entreCabania;
    private boolean cabania_entreMuelle;

    public Personaje () {
        setUbicacion("");
        setBosque_visiteBosque(false);
        setBosque_mireEste1(false);
        setBosque_mireEste2(false);
        setBosque_mireMapa(false);
        setBosque_tengoMapa(false);
        setBosque_tomeArdilla(false);
        setBosque_tomeCuchillo(false);
        setBosque_tengoArmaPuma(false);
        setBosque_matePuma(false);
        
        setCabania_tengoLlave(false);
        setCabania_visiteCabania(false);
        setCabania_mireCabania(false);
        setCabania_mirePuerta(false);
        setCabania_mireVentana(false);
        setCabania_mireMesa(false);
        setCabania_tomeLlaves(false);
        setCabania_tomePapel(false);
        setCabania_tengoArmaPerro(false);
        setCabania_matePerro(false);
        setCabania_puertaAbierta(false);
        setCabania_entreCabania(false);
        setCabania_entreMuelle(false);
    }
    
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean getBosque_visiteBosque() {
        return bosque_visiteBosque;
    }

    public void setBosque_visiteBosque(boolean bosque_visiteBosque) {
        this.bosque_visiteBosque = bosque_visiteBosque;
    }

    public boolean getBosque_mireEste1() {
        return bosque_mireEste1;
    }

    public void setBosque_mireEste1(boolean bosque_mireEste1) {
        this.bosque_mireEste1 = bosque_mireEste1;
    }

    public boolean getBosque_mireEste2() {
        return bosque_mireEste2;
    }

    public void setBosque_mireEste2(boolean bosque_mireEste2) {
        this.bosque_mireEste2 = bosque_mireEste2;
    }

    public boolean getBosque_mireMapa() {
        return bosque_mireMapa;
    }

    public void setBosque_mireMapa(boolean bosque_mireMapa) {
        this.bosque_mireMapa = bosque_mireMapa;
    }

    public boolean getBosque_tengoMapa() {
        return bosque_tengoMapa;
    }

    public void setBosque_tengoMapa(boolean bosque_tengoMapa) {
        this.bosque_tengoMapa = bosque_tengoMapa;
    }

    public boolean getBosque_tomeArdilla() {
        return bosque_tomeArdilla;
    }

    public void setBosque_tomeArdilla(boolean bosque_tomeArdilla) {
        this.bosque_tomeArdilla = bosque_tomeArdilla;
    }

    public boolean getBosque_tomeCuchillo() {
        return bosque_tomeCuchillo;
    }

    public void setBosque_tomeCuchillo(boolean bosque_tomeCuchillo) {
        this.bosque_tomeCuchillo = bosque_tomeCuchillo;
    }

    public boolean getBosque_tengoArmaPuma() {
        return bosque_tengoArmaPuma;
    }

    public void setBosque_tengoArmaPuma(boolean bosque_tengoArmaPuma) {
        this.bosque_tengoArmaPuma = bosque_tengoArmaPuma;
    }
    
    public boolean getBosque_matePuma() {
        return bosque_matePuma;
    }

    public void setBosque_matePuma(boolean bosque_matePuma) {
        this.bosque_matePuma = bosque_matePuma;
    }

    public boolean getCabania_tengoLlave() {
        return cabania_tengoLlave;
    }

    public void setCabania_tengoLlave(boolean cabania_tengoLlave) {
        this.cabania_tengoLlave = cabania_tengoLlave;
    }

    public boolean getCabania_visiteCabania() {
        return cabania_visiteCabania;
    }

    public void setCabania_visiteCabania(boolean cabania_visiteCabania) {
        this.cabania_visiteCabania = cabania_visiteCabania;
    }

    public boolean getCabania_mireCabania() {
        return cabania_mireCabania;
    }

    public void setCabania_mireCabania(boolean cabania_mireCabania) {
        this.cabania_mireCabania = cabania_mireCabania;
    }

    public boolean getCabania_mirePuerta() {
        return cabania_mirePuerta;
    }

    public void setCabania_mirePuerta(boolean cabania_mirePuerta) {
        this.cabania_mirePuerta = cabania_mirePuerta;
    }

    public boolean getCabania_mireVentana() {
        return cabania_mireVentana;
    }

    public void setCabania_mireVentana(boolean cabania_mireVentana) {
        this.cabania_mireVentana = cabania_mireVentana;
    }

    public boolean getCabania_mireMesa() {
        return cabania_mireMesa;
    }

    public void setCabania_mireMesa(boolean cabania_mireMesa) {
        this.cabania_mireMesa = cabania_mireMesa;
    }

    public boolean getCabania_tomeLlaves() {
        return cabania_tomeLlaves;
    }

    public void setCabania_tomeLlaves(boolean cabania_tomeLlaves) {
        this.cabania_tomeLlaves = cabania_tomeLlaves;
    }

    public boolean getCabania_tomePapel() {
        return cabania_tomePapel;
    }

    public void setCabania_tomePapel(boolean cabania_tomePapel) {
        this.cabania_tomePapel = cabania_tomePapel;
    }

    public boolean getCabania_tengoArmaPerro() {
        return cabania_tengoArmaPerro;
    }

    public void setCabania_tengoArmaPerro(boolean cabania_tengoArmaPerro) {
        this.cabania_tengoArmaPerro = cabania_tengoArmaPerro;
    }
    
    public boolean getCabania_matePerro() {
        return bosque_matePuma;
    }

    public void setCabania_matePerro(boolean cabania_matePerro) {
        this.cabania_matePerro = cabania_matePerro;
    }

    public boolean getCabania_puertaAbierta() {
        return cabania_puertaAbierta;
    }

    public void setCabania_puertaAbierta(boolean cabania_puertaAbierta) {
        this.cabania_puertaAbierta = cabania_puertaAbierta;
    }

    public boolean getCabania_entreCabania() {
        return cabania_entreCabania;
    }

    public void setCabania_entreCabania(boolean cabania_entreCabania) {
        this.cabania_entreCabania = cabania_entreCabania;
    }

    public boolean getCabania_entreMuelle() {
        return cabania_entreMuelle;
    }

    public void setCabania_entreMuelle(boolean cabania_entreMuelle) {
        this.cabania_entreMuelle = cabania_entreMuelle;
    }
    
}
