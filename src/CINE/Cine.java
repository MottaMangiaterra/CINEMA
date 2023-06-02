import CINE.Candy;
import CINE.Producto;
import CINE.Sala;

import java.util.ArrayList;

public class Cine {
    private Candy candy;
    private ArrayList<Sala> salas = new ArrayList<>();
    private ArrayList<Producto> carrito;
    private String nombre;
    private String direccion;

    public Cine(String nombre, String direccion, Candy candy, Sala salas){
        this.candy = candy;
        this.salas= salas;
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
                ", salas=" + salas +//BUSCAR COMO SE MOSTRABAN LAS LISTAS
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
