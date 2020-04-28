package dominio;

import exepcion.NoPuedeJugar;

public interface Estado {

    public void comer(Mascota mascota);
    public void jugar(Mascota mascota) throws NoPuedeJugar;
    public boolean puedeJugar(Mascota mascota);
}
