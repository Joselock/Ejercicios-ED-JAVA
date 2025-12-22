package Actividad23.Implementacion;

public class Trasvase {
    private Embalse destino;
    private double enviar;
    private double tiempo;
    
    public Trasvase(Embalse destino, double enviar, double tiempo) {
        this.destino = destino;
        this.enviar = enviar;
        this.tiempo = tiempo;
    }

    public Embalse getDestino() {
        return destino;
    }

    public void setDestino(Embalse destino) {
        this.destino = destino;
    }

    public double getEnviar() {
        return enviar;
    }

    public void setEnviar(double enviar) {
        this.enviar = enviar;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    

}
