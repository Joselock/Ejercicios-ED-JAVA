package Actividad25.Implementacion;

public class Solicitud {
    private String nombreCliente;
    private CentroTuristico centroTuristico;
    private float presupuestoMax;
    
    public Solicitud(String nombreCliente, CentroTuristico centroTuristico, float presupuestoMax) {
        this.nombreCliente = nombreCliente;
        this.centroTuristico = centroTuristico;
        this.presupuestoMax = presupuestoMax;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public CentroTuristico getCentroTuristico() {
        return centroTuristico;
    }

    public void setCentroTuristico(CentroTuristico centroTuristico) {
        this.centroTuristico = centroTuristico;
    }

    public float getPresupuestoMax() {
        return presupuestoMax;
    }

    public void setPresupuestoMax(float presupuestoMax) {
        this.presupuestoMax = presupuestoMax;
    }

    

}
