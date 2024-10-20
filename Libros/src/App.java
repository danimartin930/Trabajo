import java.util.InputMismatchException;
import java.util.Scanner;

import model.Almacen;
import model.Libro;
import model.Autor;

public class App {

    private static Scanner scan = new Scanner(System.in);
    private static Almacen almacen;

    public static void main(String[] args) throws Exception {
       
        int opcion;
        do{
            mostrarMenu();
            opcion = solicitarOpcion();
            procesarOpcion(opcion);
        }while(opcion!=5);

        System.out.println("FIN DEL PROGRAMA");

    }


    public static void mostrarMenu()  
    {
        String s = """
                |---------------------------------------------------|
                |MIS LIBROS                                         |
                |---------------------------------------------------|
                  1) Nuevo almacen de libros
                  2) Establecer ritmo de lectura (paginas por minuto)
                  3) Añadir un nuevo libro al almacen
                  4) Mostrar información actual de libros
                  5) Salir (se borrara toda la informacion)
                |---------------------------------------------------|
                  Seleccione una opción (1-5):
                """;
        System.out.printf("%s", s);
    }

    private static int solicitarOpcion() {
        int opcion = -1;
        try {
            opcion = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Por favor, introduzca un número válido.");
            scan.next(); 
        }
        return opcion;
    }


    public static void procesarOpcion(int opcion){

        switch (opcion) {
            case 1: crearNuevoAlmacen();
                break;

            case 2: establecerRitmoLectura();
                break;

            case 3: agregarNuevoLibro();
                break;

            case 4: mostrarLibrosAlmacen();
               break;
            
            case 5:
                System.out.println("Saliendo del programa...");
                break;

            default:
                System.out.println("Opción no válida.");
        }
}

    public static void crearNuevoAlmacen(){
        System.out.println("Por favor, introduzca el numero total de libros: ");
     
        try { int tamaño = scan.nextInt();
            almacen = new Almacen(tamaño);
            System.out.println("Se ha creado un nuevo almacen con capacidad de "+tamaño+" libros");
        }catch (InputMismatchException e) {
            System.out.println("Tamaño inválido. Intente de nuevo.");
            scan.next(); 
        }
    }

    public static void establecerRitmoLectura(){

        System.out.println("Por favor, introduzca el ritmo de lectura (Páginas por minuto): ");
        
        try {int ritmoL = scan.nextInt();
            almacen.setRitmoLectura(ritmoL);
            System.out.println("Se ha actualizado el ritmo de lectura a "+ritmoL+" páginas por minuto");
        } catch (InputMismatchException e) {
            System.out.println("Ritmo inválido. Intente de nuevo.");
            scan.next(); 
        }
    }

    public static void agregarNuevoLibro(){

        if(almacen == null){
            System.err.println("Debes crear un almacen primero: ");
            return;
        }

        try{
        System.out.println("Dime los datos de tu libro: \n");
        
        scan.nextLine(); 
        System.out.println("Título: ");
        String titulo = scan.nextLine();

        System.out.println("Año de publicación: ");
        int ano_publicacion = scan.nextInt();

        scan.nextLine(); 
        System.out.println("Nombre del autor: ");
        String nombreAutor = scan.nextLine();

        System.out.println("Apellidos del autor: ");
        String apellidosAutor = scan.nextLine();

        System.out.println("¿Ha ganado algún Premio Planeta? (true/false): ");
        Boolean premioPlaneta = scan.nextBoolean();

        System.out.println("Número de páginas: ");
        int num_paginas = scan.nextInt();

        System.out.println("Precio: ");
        Double precio = scan.nextDouble();
        

        Autor autor = new Autor(nombreAutor, apellidosAutor, premioPlaneta);
        Libro libro = new Libro(autor, titulo, ano_publicacion, num_paginas, precio);

        if(almacen.agregarLibro(libro))
        {
            System.out.println("Libro agregado con éxito. ");
        }
        else{
            System.out.println("No se pudo agregar el libro. El almacen está lleno");
        }

        } catch (InputMismatchException e) {
         System.out.println("Datos inválidos, por favor intente de nuevo.");
         scan.next(); 
        }
    }

    private static void mostrarLibrosAlmacen() {
        if (almacen != null) {
            almacen.mostrarLibros();
        } else {
            System.out.println("No hay almacén creado.");
        }
    }

}
