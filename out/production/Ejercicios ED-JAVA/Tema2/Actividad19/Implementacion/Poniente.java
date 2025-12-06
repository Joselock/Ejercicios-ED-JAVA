import cu.edu.cujae.ceis.tree.general.GeneralTree;

public class Poniente {
    private String nombre = "Poniente";
    private String fechaFundacion;
    private int cantReinos;
    

    public Poniente(String nombre, String fechaFundacion, int cantReinos) {
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.cantReinos = cantReinos;
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

    public int getCantReinos() {
        return cantReinos;
    }

    public void setCantReinos(int cantReinos) {
        this.cantReinos = cantReinos;
    }
   

}
