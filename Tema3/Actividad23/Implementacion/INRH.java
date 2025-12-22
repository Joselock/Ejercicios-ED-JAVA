package Actividad23.Implementacion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedDirectedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeNotDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class INRH {

    private ILinkedWeightedEdgeNotDirectedGraph embalses;

    public INRH(ILinkedWeightedEdgeNotDirectedGraph embalses) {
        this.embalses = new LinkedGraph();
    }

    //Inciso b
    public List<Embalse> obtenerEmbalses(Embalse embalse){
        List<Embalse>posiblesEmbalses = new LinkedList<>();
        int pos = obtenerPosicionVertice(embalse);

        if (pos != -1) {
            int i = 0;
            while (i < embalses.getVerticesList().size()) {
                boolean adyacent = embalses.areAdjacents(pos, i);

                if (adyacent) {
                    Vertex vertex = embalses.getVerticesList().get(i);
                    Embalse e = (Embalse)vertex.getInfo();

                    if (e.riesgoDeDesbordamiento()) {
                        posiblesEmbalses.add(e);
                    }
                }
            }
        }

        return posiblesEmbalses;
    }

    //Inciso c
    public List<Trasvase> trasvase(Embalse embalse){
        List<Trasvase>transvases = new LinkedList<>();

        if(embalse.riesgoDeDesbordamiento()){
            int pos = obtenerPosicionVertice(embalse);
            if(pos != -1){
                Vertex embalseVertex = embalses.getVerticesList().get(pos);
                double exceso = embalse.getCantidadEmbalsada() - embalse.getCapacidadMax() * 0.98;
                Iterator<Edge>it = embalseVertex.getEdgeList().iterator();
                
                while (it.hasNext() && exceso>0) {
                    WeightedEdge we = (WeightedEdge)it.next();
                    Embalse destino = (Embalse)we.getVertex().getInfo();
                    double capacidadDisponible = destino.getCapacidadMax() * 9.0 - destino.getCantidadEmbalsada();

                    if(capacidadDisponible  > 0){
                        double cantidadEnviar = Math.min(capacidadDisponible, exceso);
                        Tramo tub = (Tramo)we.getWeight();
                        double tiempoTotal = cantidadEnviar * tub.getTiempo();
                        Trasvase t = new Trasvase(destino,cantidadEnviar,tiempoTotal);
                        transvases.add(t);
                        exceso-=cantidadEnviar;
                    }
                }
            }
        }

        return transvases;
    }

    public int obtenerPosicionVertice(Embalse embalse){
        int pos = -1;
        int i = 0;

        while (i < embalses.getVerticesList().size() && pos == -1) {
            Vertex vertex = embalses.getVerticesList().get(i);
            Embalse e = (Embalse)vertex.getInfo();

            if (e.getId().equals(embalse.getId())) {
                pos = i;
            }else{
                i++;
            }
        }

        return pos;
    }

}
