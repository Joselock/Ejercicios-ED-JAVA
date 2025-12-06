package appMusic;

public class Autor {

    private String nombre;
    private String pais;
    private String fechaN;

    public Autor(String nombre,String pais,String fechaN){
        this.nombre = nombre;
        this.pais = pais;
        this.fechaN = fechaN;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFechaN() {
        return fechaN;
    }

    public void setFechaN(String fechaN) {
        this.fechaN = fechaN;
    }

    

}
