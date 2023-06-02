package CINE;

/**
 * Clase que define el comportamiento de una pelicula
 * @author MottaMangiaterra
 * @see <a href= "https://trello.com/c/KcUWgno3/2-crear-clase-pelicula-getters-setters-tostring-y-constructor" /> Heeramienta Agil </a>
 */
public class Peliculaa {
    private String nombre;
    private String genero;
    private int duracion;
    private String clasificacion;

    public Peliculaa(String nombre, String genero, int duracion, String clasificacion) {
        this.nombre = nombre;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
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
}
