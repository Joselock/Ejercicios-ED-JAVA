package Actividad10;

import java.util.Iterator;
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

    //Inciso c
    public boolean buscarEstudiante(String name){
        boolean encontrado = false;

        Iterator<Estudiante>iterator = lista.iterator();

        while (iterator.hasNext() && !encontrado) {
            Estudiante e = iterator.next();
            if(e.getNombre().equals(name)){
                encontrado = true;
            }
        }
        
        return encontrado;
    }

    
}
