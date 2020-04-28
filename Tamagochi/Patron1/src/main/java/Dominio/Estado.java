package Dominio;

import Exepciones.NoPuedeJugar;

public abstract class Estado{
    Mascota mascota;

    public Estado(Mascota mascota) {
        this.mascota = mascota;
    }

    public void comer(){}
    public void jugar() throws NoPuedeJugar {}
    public boolean puedeJugar(){return true;}
}
