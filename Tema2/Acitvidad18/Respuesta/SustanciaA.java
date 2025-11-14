package Tema2.Acitvidad18.Respuesta;

public class SustanciaA extends Sustancia{
    private int electronesUN;

    public SustanciaA(String nombre, String estado, int poderReativo, int electronesUN) {
        super(nombre, estado, poderReativo);
        this.electronesUN = electronesUN;
    }

    public int getElectronesUN() {
        return electronesUN;
    }

    public void setElectronesUN(int electronesUN) {
        this.electronesUN = electronesUN;
    }

    

}
