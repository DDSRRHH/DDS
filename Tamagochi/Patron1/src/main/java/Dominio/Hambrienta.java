package Dominio;

import Exepciones.NoPuedeJugar;

public class Hambrienta extends Estado{

    public Hambrienta(Mascota mascota) {
        super(mascota);
    }

    @Override
    public void comer() {
        Estado nuevoEstado = new Contenta(mascota);
        mascota.setEstado(nuevoEstado);
    }

    @Override
    public void jugar() throws NoPuedeJugar {
        throw new NoPuedeJugar("No se puede jugar estando Hambriento");
    }

    @Override
    public boolean puedeJugar() {
        return false;
    }
}
