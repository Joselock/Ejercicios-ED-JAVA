package Fichero.Ejercicio2;

import java.io.File;

public class Empresa {
    private String nombre;
    private int totalT;
    private float totalSalario;
    private File fichero;

    public Empresa(String nombre, int totalT, float totalSalario, File file) {
        this.nombre = nombre;
        this.totalT = totalT;
        this.totalSalario = totalSalario;
        this.fichero = new File("Empresa.DAT");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTotalT() {
        return totalT;
    }

    public void setTotalT(int totalT) {
        this.totalT = totalT;
    }

    public float getTotalSalario() {
        return totalSalario;
    }

    public void setTotalSalario(float totalSalario) {
        this.totalSalario = totalSalario;
    }

    public File getFichero() {
        return fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    

}
