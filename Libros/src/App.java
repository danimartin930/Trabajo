import java.util.Scanner;

import model.Almacen;
import model.Libro;
import model.Autor;

public class App {

    private static Almacen almacen;

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int opcion=0;
        do{
            mostrarMenu();
            opcion = Integer.parseInt(scan.nextLine());
            procesarOpcion(opcion);
        }while(opcion!=5);

        System.out.println("FIN DEL PROGRAMA");

        scan.close();
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
                  Seleccione una opción (1-4):
                """;
        System.out.printf("%s", s);
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
        }
}

    public static void crearNuevoAlmacen(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor, introduzca el numero total de libros: ");
        int NUM_LIBROS = Integer.parseInt(scan.nextLine());
        Almacen almacen = new Almacen(NUM_LIBROS);
        System.out.println("Se ha creado un nuevo almacen con capacidad de "+NUM_LIBROS+" libros");
        scan.close();
    }

    public static void establecerRitmoLectura(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Por favor, introduzca el ritmo de lectura (Páginas por minuto): ");
        int ritmoL = Integer.parseInt(scan.nextLine());
        almacen.setRitmoLectura(ritmoL);
        System.out.println("Se ha actualizado el ritmo de lectura a "+ritmoL+" páginas por minuto");
        scan.close();
    }

    public static void agregarNuevoLibro(){
    Scanner scan = new Scanner(System.in);
        if(almacen == null){
            System.err.println("Debes crear un almacen primero: ");
        }

        System.out.println("Dime los datos de tu libro: \n");

        System.out.println("Título: ");
        String titulo = scan.nextLine();

        System.out.println("Año de publicación: ");
        int ano_publicacion = scan.nextInt();

        System.out.println("Nombre del autor: ");
        String nombreAutor = scan.nextLine();

        System.out.println("Apellidos del autor: ");
        String apellidosAutor = scan.nextLine();

        System.out.println("¿Ha ganado algún Premio Planeta? (y/n): ");
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

        scan.close();
    }

    private static void mostrarLibrosAlmacen() {
        if (almacen != null) {
            almacen.mostrarLibros();
        } else {
            System.out.println("No hay almacén creado.");
        }
    }

}
