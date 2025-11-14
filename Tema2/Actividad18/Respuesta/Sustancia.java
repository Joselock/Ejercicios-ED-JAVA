package Tema2.Actividad18.Respuesta;

public class Sustancia {
    private String nombre;
    private String estado;
    private int poderReativo;

    public Sustancia(String nombre, String estado, int poderReativo) {
        this.nombre = nombre;
        this.estado = estado;
        setPoderReativo(poderReativo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPoderReativo() {
        return poderReativo;
    }

    public void setPoderReativo(int poderReativo) {
        if (poderReativo<0 && poderReativo>10) {
            throw new IllegalArgumentException("El poder de reaccion debe estar entre 0 y 100");
        }else{
            this.poderReativo = poderReativo;
        }   
    }

    
    

}
