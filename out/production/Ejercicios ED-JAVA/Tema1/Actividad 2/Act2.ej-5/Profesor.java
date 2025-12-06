
public class Profesor {

    private String nombre;
    private int edad;
    private CategoriaC cient;
    private CategoriaD doc;
    private Cargo cargo;

    public Profesor(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
    }

    public String getNombre(){
        return nombre;
    }

    public int getEdad(){
        return edad;
    }

    public CategoriaC getCient(){
        return cient;
    }

    public CategoriaD getDoc(){
        return doc;
    }

    public Cargo getCargo(){
        return cargo;
    }

}
