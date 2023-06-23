package Excepciones;

public class ProductoNotFoundException extends Exception{
    public ProductoNotFoundException(){
        super("Producto no encontrado");
    }
    public ProductoNotFoundException(String message){
        super(message);
    }

}
