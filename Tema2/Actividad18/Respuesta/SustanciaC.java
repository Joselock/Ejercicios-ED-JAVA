package Tema2.Actividad18.Respuesta;

public class SustanciaC extends Sustancia{
    private boolean reaccionan;

    public SustanciaC(String nombre, String estado, int poderReativo, int electronesUN, int velocidadD,
            boolean reaccionan) {
        super(nombre, estado, poderReativo);
        this.reaccionan = reaccionan;
    }

    public boolean isReaccionan() {
        return reaccionan;
    }

    public void setReaccionan(boolean reaccionan) {
        this.reaccionan = reaccionan;
    }

    

}
