package Actividad10;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Facultad {

    LinkedList<Clase>clases = new LinkedList<>();
    LinkedList<GrupoCientifico>grupos = new LinkedList<>();
    File fichero = new File("profesores.dat");

    //Inciso b
    public ArrayList<Estudiante> obtenerLista(String grupo){
    
        Iterator<GrupoCientifico>iterator = grupos.iterator();

        while (iterator.hasNext()) {
            GrupoCientifico g = iterator.next();
            if(g.getTema().equals(grupo)){
                ArrayList<Estudiante>lista = new ArrayList<>(g.getLista());
            }
        }


        return lista;
    }

}
