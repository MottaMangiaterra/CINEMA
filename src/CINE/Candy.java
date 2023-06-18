package CINE;

import Colecciones.ManejadorHashSet;

import java.util.HashSet;
import java.util.Iterator;

public class Candy implements ManejadorHashSet<Producto> {
    private double ventas;
    private HashSet<Producto> productos; //conviene manejarlo en productos para enviar todo al carrito despues(en cine)

    public Candy(HashSet<Producto> productos) {
        this.ventas=0;
        this.productos = productos;
    }

    public Candy() {
        this.ventas=0;
        this.productos=new HashSet<>();
    }

    /**
     * @param "nombre del producto"
     * @return el objeto buscado
     */
    public Producto vender(String nombreProducto) {
        Producto aux = null;
        if (productos.contains(nombreProducto) == true) {
            Iterator<Producto> it = productos.iterator();
            while (it.hasNext()) {
                Producto temp = it.next();
                if (temp.getNombre().equals(nombreProducto) == true) {
                    aux = temp;
                    this.ventas += aux.getPrecio();
                }
            }
        }
        return aux;
    }

    /**
     * el string es 1: String del producto
     *
     * @return un string que concateno el hashset
     */
    public String mostrarCandy() {
        String res = new String();
        int i = 1;
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            res += i + ": " + it;
            i++;
        }
        return res;
    }

    @Override
    public String mostrar() {
        return null;
    }

    @Override
    public void agregar(Producto dato) {

    }
}
