package Tema2.Actividad18.Respuesta;

public class SustanciaB extends Sustancia{
    private int velocidadD;

    public SustanciaB(String nombre, String estado, int poderReativo, int electronesUN, int velocidadD) {
        super(nombre, estado, poderReativo, electronesUN);
        this.velocidadD = velocidadD;
    }

    public int getVelocidadD() {
        return velocidadD;
    }

    public void setVelocidadD(int velocidadD) {
        this.velocidadD = velocidadD;
    }

    

}
