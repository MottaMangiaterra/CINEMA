package CINE;

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
}
