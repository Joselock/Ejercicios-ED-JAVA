package Actividad23.Implementacion;

public class Embalse {
    private String id;
    private int capacidadMax;
    private int capacidadMin;
    private float cantidadEmbalsada;
    
    public Embalse(String id, int capacidadMax, int capacidadMin, float cantidadEmbalsada) {
        this.id = id;
        this.capacidadMax = capacidadMax;
        this.capacidadMin = capacidadMin;
        this.cantidadEmbalsada = cantidadEmbalsada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public int getCapacidadMin() {
        return capacidadMin;
    }

    public void setCapacidadMin(int capacidadMin) {
        this.capacidadMin = capacidadMin;
    }

    public float getCantidadEmbalsada() {
        return cantidadEmbalsada;
    }

    public void setCantidadEmbalsada(float cantidadEmbalsada) {
        this.cantidadEmbalsada = cantidadEmbalsada;
    }

    public boolean riesgoDeDesbordamiento(){

        return false;
    }


}
