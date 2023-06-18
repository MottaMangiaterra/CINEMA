package CINE;

import Colecciones.ManejadorHashSet;
import Excepciones.HorarioImposibleException;
import Excepciones.SalaNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Cine implements ManejadorHashSet<Pelicula> {
    private Candy candy;
    private ArrayList<Producto> carrito;
    private HashSet<Pelicula> peliculas;
    private String nombre;
    private String direccion;

    public Cine(String nombre, String direccion, Candy candy) {
        this.candy = candy;
        this.direccion = direccion;
        this.nombre = nombre;
        this.carrito = new ArrayList<>();
        this.peliculas=new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<Producto> getCarrito() { //para que sirve?
        ArrayList<Producto> listaCarrito = new ArrayList<>(carrito);
        return listaCarrito;
    }

    public Candy getCandy() {
        return candy;
    }

    public HashSet<Pelicula> getPeliculas() {
        return peliculas;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Cine{" +
                "candy=" + candy +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    /**
     * recorre el set, guarda en p y vamos guardando en el string
     * @return String con todos los datos de las pelis
     */
    @Override
    public String mostrar(){
        String mostrarPelis = new String("");
        for (Pelicula p: peliculas)
        {
            mostrarPelis+="Nombre: "+p.getNombre()+" / Clasificacion: "+p.getClasificacion()+
                          " / Genero: "+p.getGenero()+" / Duracion:"+p.getDuracion()+" minutos"+"\n"+p.obtenerLlaves();
        }
        return mostrarPelis;

    }

    /**
     * agrega la peli al set si tiene horario, si no lo tiene obliga al usuario a darselo asignando salas
     * @param pelicula
     */
    @Override
    public void agregar (Pelicula pelicula){
        if (pelicula.obtenerTamaño()==0) //si no tiene ninguna funcion
        {
            try {
                asignarHorario(pelicula);
            }catch (SalaNotFoundException | HorarioImposibleException e)
            {
                System.out.println(e.getMessage());
            }
        }
        peliculas.add(pelicula);
    }
    /**
     * para asignar el horario y crear la sala del hashmap al mismo tiempo
     * @throws SalaNotFoundException si no existe la sala papu
     * @throws HorarioImposibleException si el horario no es realista
     * @author laucha
     */
    public void asignarHorario(Pelicula dato) throws SalaNotFoundException, HorarioImposibleException {
        int desicion=1;
        Scanner sc=new Scanner(System.in);
        while(desicion==1)
        {
            System.out.println("Ingrese hora de funcion, presione enter e ingrese los minutos de la funcion");
            int keyHora=sc.nextInt();
            if(keyHora<00 || keyHora>23){//entre las 0 horas y las 23 horas
                throw new HorarioImposibleException("horario no realista");
            }
            int keyMinutos=sc.nextInt();
            if(keyMinutos<0 || keyMinutos>59){//entre los 0 minutos y los 59 minutos
                throw new HorarioImposibleException("horario no realista");
            }
            if(keyHora!=0) {
                keyHora *= 100; //si es mayor a cero queda por ejemplo 1600
            }
            Integer key=keyHora+keyMinutos; //+ minutos queda 1630, si es 0 queda 0030
            System.out.println("Ingrese numero de sala");
            int numSala=sc.nextInt();
            if(numSala>3 && numSala<1){
                throw new SalaNotFoundException("Sala inexistente");
            }else {
                int cantButacas = 0;
                switch (numSala) {
                    case 1:
                        cantButacas = 50;
                        break;
                    case 2:
                        cantButacas = 60;
                        break;
                    case 3:
                        cantButacas = 70;
                        break;
                }
                Sala value = new Sala(numSala, cantButacas);
                boolean pausible=disponibilidadSala(value,key);
                if(pausible==true)
                {
                    dato.agregarElemento(key, value);
                }
                else {
                    System.out.println("elija otra combinacion de sala y horario");
                }

            }
            System.out.println("de querer agregar otra funcion presione 1");
            sc.nextInt();
            desicion=sc.nextInt();
        }
    }

    /**
     * Transforma la duracion de la peli al sistema utilizado en horas en formato 1545 (15 horas 45 minutos)
     *
     * Si existe una sala en el mapa durante la duracion (checkea minuto a minuto) de la peli y
     * el id de sala es el mismo que el que buscamos: boolean=false
     *
     * @param sala
     * @param horario
     * @return un boolean que comparo toda toda la duracion de la peli con el resto de las peliculas
     */
    public boolean disponibilidadSala(Sala sala, Integer horario)
    {
        boolean res=true;
        for(Pelicula p: peliculas)
        {
            Integer comparador=horario;
            double d=p.getDuracion();
            d /= 60; //pasaje a a hora
            int  i = (int) (d*100); //va a dar numero redondo siempre la hora queda en formato (2.30->230)
            Integer finalizacionPeli=i+horario;
            while(comparador<=finalizacionPeli)
            {
                Sala s = p.obtenerElemento(comparador);
                if(s!=null && sala.getNumeroSala()==s.getNumeroSala())
                {
                    res=false;
                }
                comparador++;
            }
        }
        return res;
    }

}
