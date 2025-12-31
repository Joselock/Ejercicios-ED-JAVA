package Actividad25.Implementacion;

public class Sugerencia {
    private CentroTuristico destino;
    private Carretera carretera;
    
    public Sugerencia(CentroTuristico destino, Carretera carretera) {
        this.destino = destino;
        this.carretera = carretera;
    }

    public CentroTuristico getDestino() {
        return destino;
    }

    public void setDestino(CentroTuristico destino) {
        this.destino = destino;
    }

    public Carretera getCarretera() {
        return carretera;
    }

    public void setCarretera(Carretera carretera) {
        this.carretera = carretera;
    }

    
}
