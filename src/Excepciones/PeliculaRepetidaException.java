package Excepciones;

public class PeliculaRepetidaException extends Exception{
    public PeliculaRepetidaException() {
        super("pelicula repetida");
    }

    public PeliculaRepetidaException(String message) {
        super(message);
    }
}
