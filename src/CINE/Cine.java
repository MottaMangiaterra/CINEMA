import CINE.*;

import java.util.ArrayList;

public class Cine implements MetodoColleccion<Pelicula> {
    private Candy candy;
    private ArrayList<Producto> carrito;
    private ArrayList<Pelicula> peliculas;
    private String nombre;
    private String direccion;

    public Cine(String nombre, String direccion, Candy candy) {
        this.candy = candy;
        this.direccion = direccion;
        this.nombre = nombre;
        this.carrito = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Producto> getCarrito() {
        ArrayList<Producto> listaCarrito = new ArrayList<>(carrito);
        return listaCarrito;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Cine{" +
                "candy=" + candy +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
    @Override
    public String mostrar(){
        String mostrarPelis = new String();
        for(int i = 0; i < peliculas.size(); i++){
            mostrarPelis += peliculas.get(i);
        }
        return mostrarPelis;

    }
    @Override
    public void agregar(Pelicula pelicula){
        peliculas.add(pelicula);

    }
}
