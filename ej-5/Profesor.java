
public class Profesor {

    private String nombre;
    private int edad;
    private CategoriaD cient;

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

    public CategoriaD getCient(){
        return cient;
    }

}
