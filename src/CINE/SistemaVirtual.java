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

        //aca abajo va todo el menu
        boolean menuContinuar=true;
        while(menuContinuar==true) {

            int opcion = 0;
            Scanner sc = new Scanner(System.in);
            String password = "";
            System.out.println("1. Sistema cine  " + '\'' + "2. Administracion");//ver si es necesario modo admin
            String res = null;
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("1. Entradas" + '\'' + "2. Candy" + '\'' + " 3. Carrito");
                    opcion = sc.nextInt();
                    switch (opcion)
                    {
                        case 1:
                            System.out.println(cine.mostrar());
                            System.out.println("ingrese nombre de la pelicula");
                            sc.nextLine();
                            res = sc.nextLine();

                            Pelicula peli = new Pelicula();
                            try{
                                peli = cine.seleccionarPelicula(res);
                            }catch(PeliculaNotFoundException e)
                            {
                                System.out.println(e.getMessage());
                            }

                            System.out.println(peli.mostrarHorario());
                            System.out.println("ingrese el horario");
                            double horario = sc.nextDouble();
                            System.out.println("Por ultimo, ingrese la cantidad de tickets");
                            int cantTickets = sc.nextInt();
                            Sala sala = new Sala();
                            try{
                                sala = peli.seleccionarHorario(horario, cantTickets);
                            }catch(SalaNotFoundException | CantidadButacasSuperadasException e){
                                System.out.println(e.getMessage());
                            };
                            comprarTicket(peli, cantTickets, horario, sala, res);
                            break;
                        case 2:
                            System.out.println(candy.mostrar());
                            sc.nextLine();
                            System.out.println("ingrese nombre de producto a agregar al carrito");
                          /*  res = sc.nextLine();
                            try {
                                comprarCandy(res, );
                            } catch (ProductoNotFoundException e) {
                                e.getMessage();
                            }
                            break;
                        case 3:
                            System.out.println(cine.mostrarCarrito());
                            break;
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
                        opcion =sc.nextInt();
                        switch (opcion){
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
        int uso = 0;
        if(res==null) {
            throw new ProductoNotFoundException(); //tiramos exception si no existe}else{
        }
        /*if(codigo != null)
        {
            try{
                res.promocion(codigo, uso);
            }catch (CodigoIncorrectoException e){
                System.out.println(e.getMessage());
            }
        }*/
      //  cine.agregarAlcarrito(res);


    }}}}
    public void comprarTicket(Pelicula pelicula, int cantTickets, double horario, Sala sala, String codigo){

        double precio = 0;//en proceso
        int uso = 0;
        if(pelicula.getNombre().contains("3D"))
        {
            precio = 1600;
        }else if(pelicula.getNombre().contains("2D"))
            precio = 1400;
        for(int i = 0; i < cantTickets; i++)
        {
            Producto ticket = new Ticket(pelicula.getNombre(), sala.getNumeroSala(), horario, precio);
            if(codigo != null) {
                try{
                    ticket.promocion(codigo, uso);
                }catch(CodigoIncorrectoException e)
                {
                    System.out.println(e.getMessage());
                }

                uso++;
            }
            cine.agregarAlcarrito(ticket);
        }





    }
}
