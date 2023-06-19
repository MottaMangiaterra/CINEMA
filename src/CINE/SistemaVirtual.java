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
    public SistemaVirtual() {
    }

    public void inicioSistema()
    {
        Candy candy=new Candy(); //el candy inicia vacio
        Cine cine=new Cine("Ambassador","Belgrano 321",candy);
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
        String password = "";
        System.out.println("1. Sistema cine  "+ '\'' + "2. Administracion");
        opcion = sc.nextInt();
        switch (opcion)
        {
            case 1:
                System.out.println("1. Entradas" + '\'' + "2. Candy");
                opcion = sc.nextInt();
                switch (opcion)
                {
                    case 1:
                        break;
                    case 2:
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
    public void cargarGolosinasCandy(Cine cine)
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
}
