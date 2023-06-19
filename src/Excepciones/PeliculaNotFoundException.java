package Excepciones;

public class PeliculaNotFoundException extends Exception{
    public PeliculaNotFoundException(){
        super("Pelicula no encontrada");
    }
    public PeliculaNotFoundException(String message){
        super(message);
    }
}
