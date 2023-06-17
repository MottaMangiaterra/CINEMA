package CINE;

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
}
