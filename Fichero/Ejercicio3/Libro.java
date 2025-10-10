package Fichero.Ejercicio3;

public class Libro {

    private String id;
    private String titulo;
    private String autores;
    private String anio;
    private int cantEjemplares;

    public Libro(String id, String titulo, String autores, String anio, int cantEjemplares) {
        this.id = id;
        this.titulo = titulo;
        this.autores = autores;
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

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
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

    

    

}
