package Excepciones;

public class CantidadButacasErrorException extends Exception{
    public CantidadButacasErrorException (){
        super("Capacidad superada de butacas disponibles");
    }
    public CantidadButacasErrorException(String message){
        super(message);
    }
}
