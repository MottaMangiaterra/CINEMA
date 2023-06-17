package CINE;

import java.util.HashMap;

public class Sala {
    private int numeroSala; //1-2-3
    private int cantButacas;

    public Sala(int numeroSala, int cantButacas) {
        this.numeroSala = numeroSala;
        this.cantButacas = cantButacas;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public int getCantButacas() {
        return cantButacas;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "numeroSala=" + numeroSala +
                ", cantButacas=" + cantButacas +
                '}';
    }
}
