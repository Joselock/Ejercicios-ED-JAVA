package Actividad10;

import java.util.LinkedList;

public class Clase{
    private String identificador;
    private LinkedList<Estudiante>lista;


    public Clase(String identificador) {
        this.identificador = identificador;
        this.lista = new LinkedList<>();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public LinkedList<Estudiante> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Estudiante> lista) {
        this.lista = lista;
    }

    
    

}
