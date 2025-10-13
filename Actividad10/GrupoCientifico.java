package Actividad10;

import java.util.LinkedList;

public class GrupoCientifico{
    private String tema;
    private LinkedList<Estudiante>lista;

    public GrupoCientifico(String tema) {
        this.tema = tema;
        this.lista = new LinkedList<>();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public LinkedList<Estudiante> getLista() {
        return lista;
    }

    public void setLista(LinkedList<Estudiante> lista) {
        this.lista = lista;
    }

    
    
}
