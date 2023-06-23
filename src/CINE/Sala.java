package CINE;

import java.util.HashMap;

public class Sala {
    private int numeroSala; //1-2-3
    private int cantButacas;
    private int butacasDisponibles;
    public Sala(){
        this.numeroSala = 0;
        this.cantButacas = 0;
        this.butacasDisponibles = 0;
    }
    public Sala(int numeroSala, int cantButacas) {
        this.numeroSala = numeroSala;
        this.cantButacas = cantButacas;
        this.butacasDisponibles = cantButacas;
    }


    public int getNumeroSala() {
        return numeroSala;
    }

    public int getCantButacas() {
        return cantButacas;
    }
    public int getButacasDisponibles(){
        return butacasDisponibles;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "numeroSala=" + numeroSala +
                ", cantButacas=" + cantButacas +
                ", butacasDisponibles=" + butacasDisponibles +
                '}';
    }
    public void descontarButacas(int cantidad){
        butacasDisponibles -= cantidad;
    }
}
