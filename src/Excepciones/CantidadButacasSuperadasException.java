package Excepciones;

public class CantidadButacasSuperadasException extends Exception{//cambie el nombre porque esta mal decir que es un Error, es otro concepto aparte
    public CantidadButacasSuperadasException (){
        super("Capacidad superada de butacas disponibles");
    }
    public CantidadButacasSuperadasException(String message){
        super(message);
    }
}
