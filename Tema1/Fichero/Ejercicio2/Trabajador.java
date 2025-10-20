package Fichero.Ejercicio2;

import java.io.Serializable;

public class Trabajador implements Serializable{

    private static final long serialVersionUID = 1L;

    private String numId;
    private String nombre;
    private String dpto;
    private float salario;

    public Trabajador(String numId, String nombre, String dpto, float salario) {
        super();
        this.numId = numId;
        this.nombre = nombre;
        this.dpto = dpto;
        this.salario = salario;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    

    

    

}
