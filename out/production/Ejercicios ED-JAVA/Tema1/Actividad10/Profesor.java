package Actividad10;

import java.io.Serializable;

public class Profesor implements Serializable{
    private String nombre;
    private String id;
    private int edad;
    private String asignatura;

    private static final long serialVersionUID = 1L;
    
    public Profesor(String nombre, String id, int edad, String asignatura) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.asignatura = asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    

}
