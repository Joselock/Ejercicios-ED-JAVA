import java.util.ArrayList;

public class Reino {
    private String nombre;
    private String fechaFundacion;
    private String casaGobernante;
    private ArrayList<String>gobernatesPasados;
    private ArrayList<CasaNoble>casas;

    public Reino(String nombre, String fechaFundacion, String casaGobernante) {

        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.casaGobernante = casaGobernante;
        this.gobernatesPasados = new ArrayList<>();
        this.casas = new ArrayList<>();
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

    public String getCasaGobernante() {
        return casaGobernante;
    }

    public void setCasaGobernante(String casaGobernante) {
        this.casaGobernante = casaGobernante;
    }

    public ArrayList<String> getGobernatesPasados() {
        return gobernatesPasados;
    }

    public void setGobernatesPasados(ArrayList<String> gobernatesPasados) {
        this.gobernatesPasados = gobernatesPasados;
    }

    public ArrayList<CasaNoble> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<CasaNoble> casas) {
        this.casas = casas;
    }

    

    

}
