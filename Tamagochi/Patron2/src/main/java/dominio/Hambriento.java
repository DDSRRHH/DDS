package dominio;

import Exepciones.NoPuedeJugar;

public class Hambriento extends Estado{

    @Override
    public void comer(Mascota mascota) {
        Estado nuevoEstado = new Contento();
        mascota.setEstado(nuevoEstado);
    }

    @Override
    public void jugar(Mascota mascota) throws NoPuedeJugar {
        throw new NoPuedeJugar("No se puede jugar estando Hambriento");
    }

    @Override
    public boolean puedeJugar(Mascota mascota) {
        return false;
    }

}
