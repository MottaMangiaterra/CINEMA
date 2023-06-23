package CINE;

import Excepciones.CodigoIncorrectoException;

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
        return Objects.equals(marca, golosina.marca); //modifique el equals para comparar nombres a efectos practicos no nos importa el sintacc
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), marca, sinTacc);
    }
    @Override
    public void promocion(String codigo, int uso) throws CodigoIncorrectoException{
        double precio = 0;
        double descuento = 0;
        if(codigo.contains(Character.toString('Q'))){//si contiene Q es un -%15
            precio = getPrecio();
            descuento = precio*0.15;
            precio -= descuento;
            setPrecio(precio);

        }else if(codigo.contains(Character.toString('V'))){//si contiene V es un -%20
            precio = getPrecio();
            descuento = precio*0.2;
            precio -= descuento;
            setPrecio(precio);

        }else if(!codigo.contains(Character.toString('Q')) ||!codigo.contains(Character.toString('V')))
            throw new CodigoIncorrectoException();
    }
}
