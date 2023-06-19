package CINE;

import Excepciones.*;
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
        ConsumoAPI consumoAPI=new ConsumoAPI(); //carga pelis y candy
        consumoAPI.consumirlaAPI(cine.getPeliculas(),this.candy.getProductos()); //cargamos el arreglo de pelis, se podria mover al constructor de cine y que se haga solo
        for(Pelicula p: cine.getPeliculas()) //asignamos horarios a cada peli
        {
            try {
                cine.asignarHorario(p);
            } catch (SalaNotFoundException | HorarioImposibleException e) { //salas 1, 2 o 3 - horario entre 00.00 a 23.59
                System.out.println(e.getMessage());
            }
        }
        //aca abajo va todo el menu
        boolean menuContinuar=true;
        while(menuContinuar==true) {

            int opcion = 0;
            Scanner sc = new Scanner(System.in);
            String password = "";//sin terminar
            System.out.println("1. Sistema cine  " + '\'' + "2. Administracion");//ver si es necesario modo admin
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("1. Entradas" + '\'' + "2. Candy" + '\'' + " 3. Carrito");
                    opcion = sc.nextInt();
                    switch (opcion)//faltaria opcion para ver el carrito
                    {
                        case 1:
                            System.out.println(cine.mostrar());
                            //comprarTicket
                            break;
                        case 2:
                            System.out.println(candy.mostrar());
                            sc.nextLine();
                            System.out.println("ingrese nombre de producto a agregar al carrito");
                            String res = sc.nextLine();
                            try {
                                comprarCandy(res);
                            } catch (ProductoNotFoundException e) {
                                e.getMessage();
                            }
                            break;
                        case 3:
                            System.out.println(cine.mostrarCarrito());
                        default:
                            System.out.println("ingrese solamente una de las opciones marcadas por el sistema");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Contrasena: ");
                    password = sc.nextLine();
                    if(password.equals("1234"))
                    {
                        sc.nextLine();
                        System.out.println("1. agregar pelicula " + '\'' + "2. agregar golosina"); //añadir guardar ventas candy y cine
                        int res=sc.nextInt();
                        switch (res){
                            case 1:
                                String nombre, genero, clasificacion;
                                int duracion;
                                sc.nextLine();
                                System.out.println("ingrese nombre");
                                nombre=sc.nextLine();
                                sc.nextLine();
                                System.out.println("ingrese genero");
                                genero=sc.nextLine();sc.nextLine();
                                System.out.println("ingrese clasificacion");
                                clasificacion=sc.nextLine();
                                sc.nextLine();
                                System.out.println("ingrese duracion");
                                duracion=sc.nextInt();
                                cine.agregar(new Pelicula(nombre,genero,duracion,clasificacion));
                                break;
                            case 2:
                                String marca,sinTacc;
                                double precio;
                                sc.nextLine();
                                System.out.println("ingrese nombre");
                                nombre=sc.nextLine();
                                sc.nextLine();
                                System.out.println("ingrese marca");
                                marca=sc.nextLine();sc.nextLine();
                                System.out.println("ingrese si el producto es sin tacc");
                                sinTacc=sc.nextLine();
                                sc.nextLine();
                                System.out.println("ingrese precio");
                                precio=sc.nextInt();
                                candy.agregar(new Golosina(marca,sinTacc,nombre,precio));
                        }
                    }
                    else{
                        throw new RuntimeException("Acceso denegado");
                    }
                    break;
                default:
                    break;
            }

            System.out.println("si desea salir del sistema precione 1");
            int salidaDeSistema=sc.nextInt();
            if(salidaDeSistema==1)
            {
                menuContinuar=false;
            }
        }
    }
    public void comprarCandy(String nombreGolosina) throws ProductoNotFoundException {//falta metodo selec candy
            Golosina res=candy.vender(nombreGolosina); //devuelve null si no existe
            if(res==null)
            {
                throw new ProductoNotFoundException(); //tiramos exception si no existe
            }

    }
    public void comprarTicket(String pelicula){//metodo selec peli y selec horario
        Pelicula peli = null;
        Sala sala = null;
        try{
            peli = cine.seleccionarPelicula(pelicula);
        }catch(PeliculaNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            sala = peli.seleccionarHorario(horario, cantTickets);//no se si directamente pasar esto al switch por el tema de los sout y entradas por teclado
            //para mi @laucha la mejor seria un switch con un int que se traiga de la funcion inicio de sistema
        }catch(SalaNotFoundException | CantidadButacasErrorException e){
            System.out.println(e.getMessage());
        }


    }
}
