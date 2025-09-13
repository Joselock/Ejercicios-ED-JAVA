public class Registro {

    private CategoriaD cat;
    private int cantidad;


    public Registro(CategoriaD cat,int cantidad){
        this.cat=cat;
        this.cantidad=cantidad;
    }

    public CategoriaD getCategoria(){
        return cat;
    }

    public int getCantidad(){
        return cantidad;
    }

    public void incrementar(){
        cantidad++;
    }


}
