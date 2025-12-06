package Actividad17;

public class Equipo {

    private String nombre;
    private int cantJugadores;
    private String provincia;
    private String zona;
    
    public Equipo(String nombre, int cantJugadores, String provincia, String zona) {
        this.nombre = nombre;
        this.cantJugadores = cantJugadores;
        this.provincia = provincia;
        this.zona = zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    

}
