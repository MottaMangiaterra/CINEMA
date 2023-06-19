package CINE;

import Colecciones.ManejadorHashSet;

import java.util.HashSet;
import java.util.Iterator;

public class Candy implements ManejadorHashSet<Golosina> {
    private double ventas;
    private HashSet<Golosina> productos; //conviene manejarlo en productos para enviar todo al carrito despues(en cine)

    public Candy(HashSet<Golosina> productos) {
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
    public Golosina vender(String nombreProducto) {
        Golosina aux = null;
        if (productos.contains(nombreProducto) == true) {
            Iterator<Golosina> it = productos.iterator();
            while (it.hasNext()) {
                Golosina temp = it.next();
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
    @Override
    public String mostrar() {
        String res = new String();
        int i = 1;
        Iterator<Golosina> it = productos.iterator();
        while (it.hasNext()) {
            res += i + ": " + it;
            i++;
        }
        return res;
    }

    @Override
    public void agregar(Golosina dato) {
        if (!productos.contains(dato))//se podria hacer que pueda guardar mas de uno de la misma cosa pero que se acumulen a la hora de mostrar ej: array 1, gaseo 2, gaseo, 3 gaseo. sout gaseosas: 3
        {
            productos.add(dato);
        }
    }
}
