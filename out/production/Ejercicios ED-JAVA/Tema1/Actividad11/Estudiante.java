package Actividad11;

public class Estudiante {
    private String nombre;
    private String grupo;
    private int edad;
    private char sexo;
    
    public Estudiante(String nombre, String grupo, int edad, char sexo) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.edad = edad;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public boolean vacunar() {

        throw new UnsupportedOperationException("Unimplemented method 'vacunadas'");
    }

    

}
