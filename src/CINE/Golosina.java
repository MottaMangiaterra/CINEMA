package CINE;

import java.util.Objects;

public class Golosina extends Producto{
    private String marca;
    private String sinTacc;

    public Golosina(String marca, String sinTacc, String nombre,double precio) {
        super(precio, nombre);
        this.marca = marca;
        this.sinTacc = sinTacc;
    }

    public String getMarca() {
        return marca;
    }

    public String getSinTacc() {
        return sinTacc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Golosina golosina = (Golosina) o;
        return Objects.equals(marca, golosina.marca) && Objects.equals(sinTacc, golosina.sinTacc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), marca, sinTacc);
    }
}
