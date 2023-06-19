package CINE;

import java.util.Objects;

public class Ticket extends Producto {
    private int numeroSala;
    private Integer horario;

    public Ticket(String nombrePeli, int numeroSala, Integer horario, double precio) {
        super(precio, nombrePeli);
        this.numeroSala = numeroSala;
        this.horario = horario;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public Integer getHorario() {
        return horario;
    }
    @Override
    public void promocion(String codigo)
    {
        if(codigo.contains("M")){//si contiene M es un 2x1

        }else if(codigo.contains("INV")){//si contiene INV es una entrada gratis

        }
    }
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), numeroSala, horario);
    }
}
