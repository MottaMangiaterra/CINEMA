package CINE;

import java.util.Objects;

public class Producto {
    private double precio;
    private String nombre;

    public Producto(double precio, String nombre, int cantidad) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Double.compare(producto.precio, precio) == 0 && Objects.equals(nombre, producto.nombre);
    }
    @Override
    public int hashCode() {
        return Objects.hash(precio, nombre);
    }

}
