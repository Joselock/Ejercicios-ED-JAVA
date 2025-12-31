package Actividad25.Implementacion;

public class Carretera {
    private float costo;
    private float tiempo;
    private float distancia;

    public Carretera(float costo, float tiempo, float distancia) {
        this.costo = costo;
        this.tiempo = tiempo;
        this.distancia = distancia;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getTiempo() {
        return tiempo;
    }

    public void setTiempo(float tiempo) {
        this.tiempo = tiempo;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    
    

}
