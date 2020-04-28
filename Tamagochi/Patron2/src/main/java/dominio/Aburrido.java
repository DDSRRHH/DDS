package dominio;

import Exepciones.NoPuedeJugar;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Aburrido extends Estado {
    LocalDateTime horaQSaburrio;

    public Aburrido() {
        horaQSaburrio = LocalDateTime.now();
    }

    @Override
    public void comer(Mascota mascota) {
        long tiempoAburrido = ChronoUnit.MINUTES.between(LocalDateTime.now(),horaQSaburrio);

        if (tiempoAburrido > 80){
            Estado nuevoEstado = new Contento();
            mascota.setEstado(nuevoEstado);
        }
    }

    @Override
    public void jugar(Mascota mascota) throws NoPuedeJugar {
        Estado nuevoEstado = new Contento();
        mascota.setEstado(nuevoEstado);
    }

    @Override
    public boolean puedeJugar(Mascota mascota) {
        return true;
    }

}
