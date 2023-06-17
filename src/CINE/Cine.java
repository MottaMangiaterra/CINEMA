import CINE.Candy;
import CINE.Producto;
import CINE.Sala;

import java.util.ArrayList;

public class Cine {
    private Candy candy;
    private ArrayList<Producto> carrito;
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
}
