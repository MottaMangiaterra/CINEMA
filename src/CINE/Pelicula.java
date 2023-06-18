package CINE;

import Colecciones.ManejoHashMap;
import Excepciones.ClaveNotFoundException;
import Excepciones.SalaNotFoundException;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * Clase que define el comportamiento de una pelicula
 *
 * @author MottaMangiaterra
 * @see <a href= "https://trello.com/c/KcUWgno3/2-crear-clase-pelicula-getters-setters-tostring-y-constructor" /> Heeramienta Agil </a>
 */
public class Pelicula implements ManejoHashMap<Integer,Sala> {
    private String nombre;
    private String genero;
    private int duracion; //en minutos
    private String clasificacion;
    private HashMap<Integer,Sala> salas; //hora de inicio-> Integer; solo hay 3 salas

    public Pelicula(String nombre, String genero, int duracion, String clasificacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.salas=new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                ", salas=" + salas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return duracion == pelicula.duracion && Objects.equals(nombre, pelicula.nombre) && Objects.equals(genero, pelicula.genero) && Objects.equals(clasificacion, pelicula.clasificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, genero, duracion, clasificacion);
    }


    @Override
    public void agregarElemento(Integer clave, Sala valor) {
        salas.put(clave,valor);
    }

    @Override
    public Sala obtenerElemento(Integer clave){
        Sala res = null;
        if(salas.containsKey(clave))
        {
            res=salas.get(clave);
            if(res==null)
            {
            }
        }
        return res;
    }


    @Override
    public void eliminarElemento(Integer clave) throws SalaNotFoundException, ClaveNotFoundException {
        if(salas.containsKey(clave))
        {
            Sala res=salas.get(clave);
            if(res==null)
            {
                throw new SalaNotFoundException("no hay ninguna sala asignada a ese horario");
            }
        }
        else {
            throw new ClaveNotFoundException();
        }
    }

    @Override
    public void limpiar() {
        if(!salas.isEmpty()){
            salas.clear();
        }
    }

    @Override
    public int obtenerTamaño() {
        return salas.size();
    }

    @Override
    public String obtenerLlaves() {
        String res="Funciones: ";
        Set<Integer> keys =salas.keySet();
        if(keys.isEmpty())
        {
            res+="proximamente.";
        }else{

        for (Integer i: keys) {
            res +=i+" - ";
        }
        }
        return res;
    }

}
