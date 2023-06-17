package Excepciones;

public class ClaveNotFoundException extends Exception{
    public ClaveNotFoundException() {
        super("horario no existe");
    }

    public ClaveNotFoundException(String message) {
        super(message);
    }
}
