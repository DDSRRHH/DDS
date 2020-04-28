package dominio;

import exepcion.NoPuedeJugar;

public class Contento implements Estado {
    private int vecesQueJugo = 0;

    @Override
    public void comer(Mascota mascota) {
        mascota.setNivelDeFelicidad(mascota.getNivelDeFelicidad()+1);
    }

    @Override
    public void jugar(Mascota mascota) throws NoPuedeJugar {
        mascota.setNivelDeFelicidad(mascota.getNivelDeFelicidad()+2);
        vecesQueJugo += 1;

        if(vecesQueJugo > 5){
            Estado nuevoEstado = new Hambriento();
            mascota.setEstado(nuevoEstado);
        }
    }

    @Override
    public boolean puedeJugar(Mascota mascota) {
        return true;
    }
}
