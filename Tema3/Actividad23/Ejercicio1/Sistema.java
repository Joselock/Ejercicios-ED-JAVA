package Actividad23.Ejercicio1;

import java.util.LinkedList;
import java.util.List;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class Sistema {

    private ILinkedDirectedGraph encuesta;

    public Sistema(ILinkedDirectedGraph encuesta){
        this.encuesta = new LinkedGraph();
    }

    //Inciso b
    public List<Estudiante> trabajarConTodos(){
        List<Estudiante>estudiantes = new LinkedList<>();
        int total = encuesta.getVerticesList().size();
        int i = 0;

        while (i<total) {
            Vertex vertex = encuesta.getVerticesList().get(i);
            Estudiante e = (Estudiante)vertex.getInfo();
            int outDegree = encuesta.outDegree(i);
            if (outDegree == total-1) {  //No se encuentra asi mismo
                estudiantes.add(e);
            }
            i++;
        }

        return estudiantes;
    }


    //Inciso c
    public List<Estudiante> militantes(){
        List<Estudiante>estudiantes = new LinkedList<>();
        int total = encuesta.getVerticesList().size();
        int i = 0;

        while (i<total) {
            Vertex vertex = encuesta.getVerticesList().get(i);
            Estudiante e = (Estudiante)vertex.getInfo();
            if (!e.isMilitante()) {
                int grado = encuesta.inDegreeDG(i);
                if (grado == 0) {
                    estudiantes.add(e);
                }
            }
            i++;
        }

        return estudiantes;
    }

}
