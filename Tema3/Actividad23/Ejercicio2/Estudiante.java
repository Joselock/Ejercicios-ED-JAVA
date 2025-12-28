package Actividad23.Ejercicio2;

public class Estudiante {
    private String identificador;
    private String nombre;
    private String fechaNacimiento;
    private boolean militante;
    
    public Estudiante(String identificador, String nombre, String fechaNacimiento, boolean militante) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.militante = militante;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isMilitante() {
        return militante;
    }

    public void setMilitante(boolean militante) {
        this.militante = militante;
    }

    

}
