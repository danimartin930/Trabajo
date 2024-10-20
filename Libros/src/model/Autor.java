package model;

public class Autor {
    private String nombre;
    private String apellidos;
    private Boolean premioPlaneta;

    public Autor(String nombre, String apellidos, boolean premio_planeta){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.premioPlaneta = premio_planeta;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellidos;
    }

    public boolean isPremioPlaneta() {
        return premioPlaneta;
    }

    @Override
    public String toString() {
        return getNombreCompleto() + (premioPlaneta ? " " : "");
    }

    
}
