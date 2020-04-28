package dominio;

import exepcion.NoPuedeJugar;

public class Hambriento implements Estado {
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
