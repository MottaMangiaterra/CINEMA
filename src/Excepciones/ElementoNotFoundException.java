package Excepciones;

public class ElementoNotFoundException extends Exception{
    public ElementoNotFoundException() {
        super("Elemento no existe");
    }

    public ElementoNotFoundException(String message) {
        super(message);
    }
}
