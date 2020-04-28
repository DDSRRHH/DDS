package Dominio;

public class Contenta extends Estado{
    private int vecesQueJugo = 0;

    public Contenta(Mascota mascota) {
        super(mascota);
    }

    @Override
    public void comer() {
        mascota.setNivelDeFelicidad(mascota.getNivelDeFelicidad()+1);
    }

    @Override
    public void jugar() {
        mascota.setNivelDeFelicidad(mascota.getNivelDeFelicidad()+2);
        vecesQueJugo += 1;

        if(vecesQueJugo > 5){
            Estado nuevoEstado = new Hambrienta(mascota);
            mascota.setEstado(nuevoEstado);
        }
    }

    @Override
    public boolean puedeJugar() {
        return true;
    }
}
