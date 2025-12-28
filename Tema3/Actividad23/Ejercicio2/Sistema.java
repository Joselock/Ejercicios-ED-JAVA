package Actividad23.Ejercicio2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedDirectedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class Sistema {

    private ILinkedWeightedEdgeDirectedGraph encuesta;

    public Sistema(ILinkedWeightedEdgeDirectedGraph encuesta){
        this.encuesta = new LinkedGraph();
    }

    //Inciso b
    public List<Estudiante> solicitadosPreferencia1(){
        List<Estudiante>estudiantes = new LinkedList<>();
        Iterator<Vertex>it = encuesta.getVerticesList().iterator();
        int mayor = Integer.MIN_VALUE;

        while (it.hasNext()) {
            Vertex current = it.next();
            Estudiante e = (Estudiante)current.getInfo();
            int total = this.countFirstPreferencesForStudent(current);
            if(total > mayor){
                estudiantes.clear();
                estudiantes.add(e);
                mayor = total;
            }else if(total == mayor){
                estudiantes.add(e);
            }
        }

        return estudiantes;
    }


    //Solicitados coon primera preferencia
    public int countFirstPreferencesForStudent(Vertex current){
        int total = 0;
        Estudiante currentEstudiante = (Estudiante)current.getInfo();
        Iterator<Vertex>it = encuesta.getVerticesList().iterator();

        while (it.hasNext()) {
            Vertex vertex = it.next();
            Iterator<Edge>edgeIt = vertex.getEdgeList().iterator();
            boolean edgeFound = false;

            while (edgeIt.hasNext() && !edgeFound) {
                WeightedEdge we = (WeightedEdge)edgeIt.next();
                Vertex adjVertex = we.getVertex();
                Estudiante adjEstudiante = (Estudiante)adjVertex.getInfo();
                int pos = (Integer)we.getWeight();
                if (adjEstudiante.getIdentificador().equals(currentEstudiante.getIdentificador()) && pos == 1) {
                    total++;
                    edgeFound = true;
                }
            }
        }

        return total;
    }


    //Inciso c

}
