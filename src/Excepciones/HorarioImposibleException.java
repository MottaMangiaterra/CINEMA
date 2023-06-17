package Excepciones;

public class HorarioImposibleException extends Exception{
    public HorarioImposibleException() {
    }

    public HorarioImposibleException(String message) {
        super(message);
    }
}
