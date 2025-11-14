package Tema2.Acitvidad18.Respuesta;

public class SustanciaC extends SustanciaB{
    private boolean reaccionan;

    public SustanciaC(String nombre, String estado, int poderReativo, int electronesUN, int velocidadD,
            boolean reaccionan) {
        super(nombre, estado, poderReativo, electronesUN, velocidadD);
        this.reaccionan = reaccionan;
    }

    public boolean isReaccionan() {
        return reaccionan;
    }

    public void setReaccionan(boolean reaccionan) {
        this.reaccionan = reaccionan;
    }

    

}
