package Excepciones;

public class SalaNotFoundException extends Exception{
    public SalaNotFoundException() {
    }

    public SalaNotFoundException(String message) {
        super(message);
    }
}
