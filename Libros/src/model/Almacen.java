package model;
import model.Libro;
import model.Autor;

public class Almacen {
    private Libro[] libros;
    private int cantidadLibros;
    private int ritmoLectura;

    public Almacen(int NUM_LIBROS){
        libros = new Libro[NUM_LIBROS];
        cantidadLibros = 0;
        ritmoLectura = 1;
    }

    public void setRitmoLectura(int ritmoLectura) {
        this.ritmoLectura = ritmoLectura;
    }

    public boolean agregarLibro(Libro libro) {
        if (cantidadLibros < libros.length) {
            libros[cantidadLibros++] = libro;
            return true;
        }
        return false;  // No hay espacio
    }

    public void mostrarLibros(){

        if(cantidadLibros == 0){
            System.out.println("No hay libros en el almacen");
        }

        String s="""
                |-----------------------------------------------------------------------------------------------------------------------|
                | LIBROS EN EL ALMACÉN |
                |-----------------------------------------------------------------------------------------------------------------------|
                | Título | Año Publicación | Autor | Premio planeta | Páginas | Tiempo lectura minutos | Precio|
                |-----------------------------------------------------------------------------------------------------------------------|
                """;
        System.out.printf("%s", s);

        int totalPaginas = 0;
        double valorTotal = 0.0;

        for(int i=0; i<libros.length; i++){
            Libro libro = libros[i];
            System.err.println(libro.toString());
            totalPaginas = libro.getNum_paginas();
            valorTotal = libro.getPrecio();
        }


        System.err.println("|-----------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("Tiempo de lectura total del almacén:                                      %d min|                                   |", totalPaginas/ritmoLectura);                                                         
        System.out.printf("Valor total del almacén:                                                  %.2f €|                                     |", valorTotal);                                                             
        System.err.println("|-----------------------------------------------------------------------------------------------------------------------|");


    }

    

}
