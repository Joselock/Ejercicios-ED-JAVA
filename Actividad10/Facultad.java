package Actividad10;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;

public class Facultad {

    LinkedList<Clase>clases = new LinkedList<>();
    LinkedList<GrupoCientifico>grupos = new LinkedList<>();
    File fichero = new File("profesores.dat");

    //Inciso b
    public LinkedList<Estudiante> obtenerLista(String grupo){
    
        LinkedList<Estudiante>lista = new LinkedList<>();
        Iterator<GrupoCientifico>iterator = grupos.iterator();

        while (iterator.hasNext()) {
            GrupoCientifico g = iterator.next();
            if(g.getTema().equals(grupo)){
                lista = g.getLista();
            }
        }

        return lista;
    }

}
