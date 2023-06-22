package Excepciones;

public class CantidadButacasSuperadasException extends Exception{
    public CantidadButacasSuperadasException (){
        super("Capacidad superada de butacas disponibles");
    }
    public CantidadButacasSuperadasException(String message){
        super(message);
    }
}
