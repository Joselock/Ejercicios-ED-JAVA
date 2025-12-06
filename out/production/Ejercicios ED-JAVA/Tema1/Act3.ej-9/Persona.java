

public class Persona {

    private String nombre;
    private String numId;
    private String tipo;
    private String categoria;
    private String cargo;
    
    public Persona(String nombre, String numId, String tipo, String categoria, String cargo) {
        this.nombre = nombre;
        this.numId = numId;
        this.tipo = tipo;
        this.categoria = categoria;
        this.cargo = cargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumId() {
        return numId;
    }

    public void setNumId(String numId) {
        this.numId = numId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    

}
