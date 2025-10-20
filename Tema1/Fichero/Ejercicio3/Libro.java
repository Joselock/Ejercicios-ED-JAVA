package Fichero.Ejercicio3;

import java.io.Serializable;
import java.util.List;

public class Libro implements Serializable{

    private String id;
    private String titulo;
    private List<Autor> autores;
    private String anio;
    private int cantEjemplares;

    private static final long serialVersionIUD = 2L;

    public Libro(String id, String titulo, String autores, String anio, int cantEjemplares) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.cantEjemplares = cantEjemplares;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public int getCantEjemplares() {
        return cantEjemplares;
    }

    public void setCantEjemplares(int cantEjemplares) {
        this.cantEjemplares = cantEjemplares;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    

    

}
