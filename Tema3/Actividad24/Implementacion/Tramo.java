package Actividad24.Implementacion;

public class Tramo {
    private float longitud;
    private float radio;
    private int tiempo;

    public Tramo(float longitud, float radio, int tiempo) {
        this.longitud = longitud;
        this.radio = radio;
        this.tiempo = tiempo;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public float getRadio() {
        return radio;
    }

    public void setRadio(float radio) {
        this.radio = radio;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    
}
