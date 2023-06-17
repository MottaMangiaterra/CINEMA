package CINE;

import java.util.HashMap;
import java.util.Objects;

/**
 * Clase que define el comportamiento de una pelicula
 *
 * @author MottaMangiaterra
 * @see <a href= "https://trello.com/c/KcUWgno3/2-crear-clase-pelicula-getters-setters-tostring-y-constructor" /> Heeramienta Agil </a>
 */
public class Pelicula {
    private String nombre;
    private String genero;
    private int duracion;
    private String clasificacion;
    private HashMap<String,Sala> salas;

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
}
