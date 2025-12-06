public class Estudiante {
    private String nombre;
    private char sexo;
    private String direccion;
    private boolean militancia;

    public Estudiante(String nombre, char sexo, String direccion, boolean militancia) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.direccion = direccion;
        this.militancia = militancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isMilitancia() {
        return militancia;
    }

    public void setMilitancia(boolean militancia) {
        this.militancia = militancia;
    }
    
    
    

}
