package CINE;

import java.util.HashSet;
import java.util.Iterator;

public class Candy {
    private double ventas;
    private HashSet<Producto> productos;

    public Candy(HashSet<Producto> productos) {
        this.productos = productos;
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
     * el string es 1: toString del producto
     *
     * @return un string que concateno el hashset
     */
    public String mostrarCandy() {
        String res = new String();
        int i = 1;
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            res += i + ": " + it.toString();
            i++;
        }
        return res;
    }
}
