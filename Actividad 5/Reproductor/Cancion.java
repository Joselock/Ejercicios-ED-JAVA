

public class Cancion {

    private String titulo;
    private String autor;
    private String lanzamiento;

    public Cancion(String autor,String titulo,String lanzamiento){
        this.titulo = titulo;
        this.autor = autor;
        this.lanzamiento = lanzamiento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    

}
