package CINE;

import Excepciones.CodigoIncorrectoException;

import java.util.Objects;

public class Ticket extends Producto {
    private int numeroSala;
    private double horario;

    public Ticket(String nombrePeli, int numeroSala, double horario, double precio) {
        super(precio, nombrePeli);
        this.numeroSala = numeroSala;
        this.horario = horario;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public double getHorario() {
        return horario;
    }
    @Override
    public void promocion(String codigo, int uso) throws CodigoIncorrectoException
    {
        if(codigo.contains(Character.toString('M')) || uso != 2){//si contiene M es un 2x1
            double precio = getPrecio();
            setPrecio(precio/2);

        }else if(codigo.contains("INV")|| uso != 1){//si contiene INV es una entrada gratis
            setPrecio(0);
        }else if(!codigo.contains(Character.toString('M')) ||!codigo.contains("INV")){
            throw new CodigoIncorrectoException();
        }
    }
    @Override
    public int hashCode(){
        return Objects.hash(super.hashCode(), numeroSala, horario);
    }
}
