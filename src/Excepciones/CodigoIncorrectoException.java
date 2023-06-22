package Excepciones;

public class CodigoIncorrectoException extends Exception{
    public CodigoIncorrectoException(){
        super("El codigo es incorrecto");
    }
    public CodigoIncorrectoException(String message){
        super(message);
    }
}
