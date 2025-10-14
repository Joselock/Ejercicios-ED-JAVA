package Actividad10;

public class Estudiante{

    private String nombre;
    private String numId;
    private String grupoC;
    private String clase;

    public Estudiante(String nombre, String numId, String grupoC, String clase) {
        this.nombre = nombre;
        this.numId = numId;
        this.grupoC = grupoC;
        this.clase = clase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getGrupoC() {
        return grupoC;
    }

    public void setGrupoC(String grupoC) {
        this.grupoC = grupoC;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    
    
}
