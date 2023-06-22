package CINE;

import Colecciones.ManejoHashMap;
import Excepciones.CantidadButacasSuperadasException;
import Excepciones.ClaveNotFoundException;
import Excepciones.SalaNotFoundException;

import java.util.*;

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

    public String mostrarHorario(){
        String res = null;
        Iterator it = salas.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, Sala> entry = (Map.Entry<Integer, Sala>)it.next();
            res += "Sala " + entry.getValue() + '\'' + "Horario " + entry.getKey() + '\'';
        }
        return res;
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
        }
        return res;
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
    //metodo seleccionarHorario()

    /**
     * Busca el horario seleccionado y luego analiza el espacio que hay. Descuenta si hay butacas disponibles
     * @param horario
     * @param cantTickets
     * @return retorna la sala en donde se encuentra la pelicula en el horario elegido.
     * @throws SalaNotFoundException no encuentra el horario elegido.
     * @throws CantidadButacasSuperadasException la cantidad de butacas seleccionadas no esta disponible.
     */
    public Sala seleccionarHorario(Integer horario, int cantTickets)throws SalaNotFoundException, CantidadButacasSuperadasException{
        Sala sala = null;
        if(salas.containsKey(horario))
        {
            sala = salas.get(horario);
            if(sala.getButacasDisponibles() >= cantTickets)
            {
                sala.descontarButacas(cantTickets);
            }else
                throw new CantidadButacasSuperadasException("Cantidad superada de butacas disponibles. Restantes para su seleccion: "+ sala.getButacasDisponibles());
        }else
            throw new SalaNotFoundException("No se encontro ninguna funcion en ese horario");

        return sala;
    }

}
