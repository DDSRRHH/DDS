package Dominio;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Aburrida extends Estado{
    LocalDateTime horaQSaburrio;

    public Aburrida(Mascota mascota) {
        super(mascota);
        horaQSaburrio = LocalDateTime.now();
    }

    @Override
    public void comer() {
        long tiempoAburrido = ChronoUnit.MINUTES.between(LocalDateTime.now(),horaQSaburrio);

        if(tiempoAburrido>80){
            Estado nuevoEstado = new Contenta(mascota);
            mascota.setEstado(nuevoEstado);
        }
    }

    @Override
    public void jugar() {
        Estado nuevoEstado = new Contenta(mascota);
        mascota.setEstado(nuevoEstado);
    }

    @Override
    public boolean puedeJugar() {
        return true;
    }
}
