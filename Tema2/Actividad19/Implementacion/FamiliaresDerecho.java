public class FamiliaresDerecho {

    private String nombreReino;
    private int cantConDerecho;

    public FamiliaresDerecho(String nombreReino, int cantConDerecho) {
        this.nombreReino = nombreReino;
        this.cantConDerecho = cantConDerecho;
    }

    public String getNombreReino() {
        return nombreReino;
    }

    public void setNombreReino(String nombreReino) {
        this.nombreReino = nombreReino;
    }

    public int getCantConDerecho() {
        return cantConDerecho;
    }

    public void setCantConDerecho(int cantConDerecho) {
        this.cantConDerecho = cantConDerecho;
    }

}
