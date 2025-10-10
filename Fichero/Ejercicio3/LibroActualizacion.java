package Fichero.Ejercicio3;

import java.io.Serializable;

public class LibroActualizacion implements Serializable{

    private char tipoMovimiento;
    private String id;
    private int cantMovimiento;

    private static final long serialVersionIUD = 1L;

    public LibroActualizacion(char tipoMovimiento, String id, int cantMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
        this.id = id;
        this.cantMovimiento = cantMovimiento;
    }

    public char getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(char tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCantMovimiento() {
        return cantMovimiento;
    }

    public void setCantMovimiento(int cantMovimiento) {
        this.cantMovimiento = cantMovimiento;
    }

    public static long getSerialversioniud() {
        return serialVersionIUD;
    }

    

}
