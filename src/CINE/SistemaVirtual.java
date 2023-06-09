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
        consumoAPI.consumirlaAPI(cine.getPeliculas(),candy.getProductos()); //cargamos el arreglo de pelis, se podria mover al constructor de cine y que se haga solo

        //aca abajo va todo el menu
        boolean menuContinuar=true;
        while(menuContinuar==true) {

            int opcion = 0;
            Scanner sc = new Scanner(System.in);
            String password = "";
            System.out.println("1. Sistema cine  \n2. Administracion");
            String res = null;
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("1. Entrada \n2. Candy \n3. Carrito");
                    opcion = sc.nextInt();
                    switch (opcion)
                    {
                        case 1:
                            System.out.println(cine.mostrar());
                            System.out.println("Ingrese nombre de la pelicula (Tenga en cuenta el formato al escribir: peli - tipo idioma).");
                            sc.nextLine();
                            res = sc.nextLine();

                            //comprarTicket
                            Pelicula peli =new Pelicula();
                            try{
                                peli = cine.seleccionarPelicula(res);
                            }catch(PeliculaNotFoundException e)
                            {
                                System.out.println(e.getMessage());
                            }

                            System.out.println(peli.mostrarHorario());
                            System.out.println("Ingrese el horario(con coma).");
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
                            res = sc.nextLine();
                            try {
                                comprarCandy(res);
                            } catch (ProductoNotFoundException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 3:
                            System.out.println(cine.mostrarCarrito());
                            System.out.println("\npara confirmar la compra de su carrito ingrese 1");
                            int comprarCarrito=sc.nextInt();
                            if(comprarCarrito==1)
                            {
                                cine.comprarCarrito();
                            }
                            break;
                        default:
                            System.out.println("ingrese solamente una de las opciones marcadas por el sistema");
                            break;
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Contrasena: ");
                    password = sc.nextLine();
                    if(password.equals("1234"))
                    {
                        System.out.println("1. agregar pelicula " + '\'' + "2. agregar golosina"+
                                '\'' + "3. guardar ventas"+ '\'' + "4. ver ventas"); //añadir guardar ventas candy y cine
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
                                System.out.println("ingrese marca");
                                marca=sc.nextLine();
                                System.out.println("ingrese si el producto es sin tacc");
                                sinTacc=sc.nextLine();
                                System.out.println("ingrese precio");
                                precio=sc.nextInt();
                                candy.agregar(new Golosina(marca,sinTacc,nombre,precio));
                                break;
                            case 3:
                                cine.grabarVentas();
                                break;
                            case 4:
                                System.out.println(cine.mostrarArchivoVentas());
                                break;
                            default:
                                System.out.println("ingrese solamente una de las opciones marcadas por el sistema");
                                break;
                        }
                    }
                    else{
                        throw new RuntimeException("Acceso denegado");
                    }


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
        Golosina res = candy.vender(nombreGolosina); //devuelve null si no existe
        if (res == null) {
            throw new ProductoNotFoundException(); //tiramos exception si no existe}else{
        }else{
        cine.agregarAlcarrito(res);
    }}
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
