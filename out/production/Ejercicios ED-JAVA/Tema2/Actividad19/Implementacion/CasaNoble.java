import java.util.ArrayList;

public class CasaNoble {
    private String nombre;
    private String fechaFundacion;
    private int batallasGanadas;
    private ArrayList<Familiar>familiares = new ArrayList<Familiar>();

    public CasaNoble(String nombre, String fechaFundacion, int batallasGanadas) {
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.batallasGanadas = batallasGanadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(String fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public int getBatallasGanadas() {
        return batallasGanadas;
    }

    public void setBatallasGanadas(int batallasGanadas) {
        this.batallasGanadas = batallasGanadas;
    }

    public ArrayList<Familiar> getFamiliares() {
        return familiares;
    }

    public void setFamiliares(ArrayList<Familiar> familiares) {
        this.familiares = familiares;
    }

    

}
