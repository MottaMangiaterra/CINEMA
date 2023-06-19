package CINE;

import Excepciones.HorarioImposibleException;
import Excepciones.SalaNotFoundException;
import JSON.ConsumoAPI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase envoltorio vacia que contine todas las clases pertenecientes a un CINE
 */
public class SistemaVirtual {
    private Candy candy;
    private Cine cine;
    public SistemaVirtual() {//necesito usar las variables fuera de inicioSistema para poder hacer metodos
        candy=new Candy(); //el candy inicia vacio
        cine=new Cine("Ambassador","Belgrano 321",candy);//!
    }

    public void inicioSistema()
    {
        ConsumoAPI consumoAPI=new ConsumoAPI();
        consumoAPI.consumirlaAPI(cine.getPeliculas()); //cargamos el arreglo de pelis, se podria mover al constructor de cine y que se haga solo
        for(Pelicula p: cine.getPeliculas()) //asignamos horarios a cada peli
        {
            try {
                cine.asignarHorario(p);
            } catch (SalaNotFoundException | HorarioImposibleException e) { //salas 1, 2 o 3 - horario entre 00.00 a 23.59
                System.out.println(e.getMessage());
            }
        }
        //aca abajo va todo el menu
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        String password = "";//sin terminar
        System.out.println("1. Sistema cine  "+ '\'' + "2. Administracion");//ver si es necesario modo admin
        opcion = sc.nextInt();
        switch (opcion)
        {
            case 1:
                System.out.println("1. Entradas" + '\'' + "2. Candy");
                opcion = sc.nextInt();
                switch (opcion)//faltaria opcion para ver el carrito
                {
                    case 1:
                        System.out.println(cine.mostrar());
                        //comprarTicket
                        break;
                    case 2:
                        System.out.println(candy.mostrar());
                        //comprarCandy
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                System.out.println("Contrasena: ");
                password = sc.nextLine();
                //if()
                break;
            default:
                break;
        }
    }
    public void cargarGolosinasCandy(Cine cine)//mover a cine
    {
        int decision=1;
        Scanner sc=new Scanner(System.in);
        while(decision==1) {
            System.out.println("ingrese nombre de la golosina"); //es necesario usar souts para cargar
            String nombre=sc.nextLine();
            System.out.println("ingrese marca de la golosina");
            String marca=sc.nextLine();
            System.out.println("la golosina es sin tacc?");
            String st=sc.nextLine();
            System.out.println("ingrese precio de la golosina");
            double precio= sc.nextDouble();
            Golosina g=new Golosina(marca,st,nombre,precio);
            cine.getCandy().agregar(g);//funcion que agrega 1 golosina al candy
        }
    }
    public void comprarCandy(){//falta metodo selec candy

    }
    public void comprarTicket(){//metodo selec peli y selec horario

    }
}
