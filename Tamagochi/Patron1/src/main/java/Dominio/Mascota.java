package Dominio;

import Exepciones.NoPuedeJugar;

public class Mascota {
    private int nivelDeFelicidad;
    private Estado estado;

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setNivelDeFelicidad(int nivelDeFelicidad) {
        this.nivelDeFelicidad = nivelDeFelicidad;
    }

    public int getNivelDeFelicidad() {
        return nivelDeFelicidad;
    }

    public void comer(){
        this.estado.comer();
    };
    public void jugar() throws NoPuedeJugar {
        this.estado.jugar();
    }
    public boolean puedeJugar(){
        return this.estado.puedeJugar();
    }

}
