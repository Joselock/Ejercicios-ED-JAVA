package Actividad25.Implementacion;

public class CentroTuristico {
    private String nombre;
    private String descripcion;
    private boolean dispone;
    
    public CentroTuristico(String nombre, String descripcion, boolean dispone) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dispone = dispone;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isDispone() {
        return dispone;
    }

    public void setDispone(boolean dispone) {
        this.dispone = dispone;
    }

    

}
