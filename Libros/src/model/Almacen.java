package model;

public class Almacen {
    private Libro[] libros;
    private int cantidadLibros=0;
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
            libros[cantidadLibros] = libro;
            cantidadLibros++;
            return true;
        }
        return false;  
    }

    public void mostrarLibros(){

        if(cantidadLibros == 0){
            System.out.println("No hay libros en el almacen");
            return;
        }

        String s="""
                |-----------------------------------------------------------------------------------------------------------------------|
                | LIBROS EN EL ALMACÉN |
                |-----------------------------------------------------------------------------------------------------------------------|
                | Título        | Año Publicación       | Autor          | Premio planeta       | Páginas      | Tiempo lectura minutos      | Precio          |

                |-----------------------------------------------------------------------------------------------------------------------|
                """;
        System.out.printf("%s", s);

        int totalPaginas = 0;
        double valorTotal = 0.0;

        for(int i=0; i<libros.length; i++){
            Libro libro = libros[i];
            if (libro != null) {
           
                System.out.printf("| %-20s | %-15d | %-20s | %-14s | %-7d | %-22d | %.2f € |\n", 
                    libro.getTitulo(), 
                    libro.getAno_publiacion(), 
                    libro.getAutor().toString(), 
                    (libro.getAutor().isPremioPlaneta() ? "Sí" : "No"),
                    libro.getNum_paginas(), 
                    libro.getNum_paginas() / ritmoLectura, 
                    libro.getPrecio()
                );

                totalPaginas += libro.getNum_paginas();
                valorTotal += libro.getPrecio();
            }
        }


        System.err.println("|-----------------------------------------------------------------------------------------------------------------------|");
        System.out.printf("Tiempo de lectura total del almacén:       %d min|                                   |", totalPaginas/ritmoLectura);                                                         
        System.out.printf("Valor total del almacén:                   %.2f €|                                     |", valorTotal); 
        System.out.println("");                                                            
        System.err.println("|-----------------------------------------------------------------------------------------------------------------------|");
    }

    public void reiniciarAlmacen(int tamaño) {
        libros = new Libro[tamaño];
        cantidadLibros = 0;
    }

    

}
