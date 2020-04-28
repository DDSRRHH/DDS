package dominio;

import Exepciones.NoPuedeJugar;

public abstract class Estado {

    public void comer(Mascota mascota){}
    public void jugar(Mascota mascota) throws NoPuedeJugar {}
    public boolean puedeJugar(Mascota mascota){return true;}
}
