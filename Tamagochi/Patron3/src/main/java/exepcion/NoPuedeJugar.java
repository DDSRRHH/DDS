package exepcion;

public class NoPuedeJugar extends Exception {
    public NoPuedeJugar(String message) {
        super(message);
    }
}
