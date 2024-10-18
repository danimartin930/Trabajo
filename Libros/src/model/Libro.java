package model;
import model.Autor;

public class Libro {
    private Autor autor;
    private String titulo;
    private int ano_publicacion;
    private int num_paginas;
    private double precio;

    public Libro(Autor autor, String titulo, int ano_publicacion, int num_paginas, double precio){
        this.autor = autor;
        this.titulo = titulo;
        this.ano_publicacion = ano_publicacion;
        this.num_paginas = num_paginas; 
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno_publiacion() {
        return ano_publicacion;
    }

    public int getNum_paginas() {
        return num_paginas;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-15d | %-25s | %-10s | %-10d | %-10.2f €", 
            titulo, ano_publicacion, autor.toString(), 
            (autor.isPremioPlaneta() ? "Sí" : "No"), num_paginas, precio);
    }       
}
