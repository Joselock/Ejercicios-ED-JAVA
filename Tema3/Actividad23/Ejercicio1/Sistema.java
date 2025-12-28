package Actividad23.Ejercicio1;

import java.util.LinkedList;
import java.util.List;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedDirectedGraph;

public class Sistema {

    private ILinkedDirectedGraph encuesta;

    public Sistema(ILinkedDirectedGraph encuesta){
        this.encuesta = new LinkedGraph();
    }

    //Inciso b
    public List<Estudiante> trabajarConTodos(){
        List<Estudiante>estudiantes = new LinkedList<>();

        return estudiantes;
    }

}
