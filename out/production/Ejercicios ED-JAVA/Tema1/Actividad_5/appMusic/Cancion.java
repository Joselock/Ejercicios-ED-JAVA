package appMusic;


public class Cancion {

    private String titulo;
    private Autor autor;
    private String lanzamiento;

    public Cancion(Autor autor,String titulo,String lanzamiento){
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    

}
