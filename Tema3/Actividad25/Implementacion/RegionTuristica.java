package Actividad25.Implementacion;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.edge.Edge;
import cu.edu.cujae.ceis.graph.edge.WeightedEdge;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedWeightedEdgeDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class RegionTuristica {
    private ILinkedWeightedEdgeDirectedGraph region;
    private Queue<Solicitud>solicitudes;


    public RegionTuristica(ILinkedWeightedEdgeDirectedGraph region, Queue<Solicitud> solicitudes) {
        this.region = new LinkedGraph();
        this.solicitudes = new ArrayDeque<>();
    }

    //Metodo para obtener la posicion 
    public int obtenerPosicionVerticeTuristico(CentroTuristico centroTuristico){
        int pos = -1;
        int i = 0;
        
        while (i<region.getVerticesList().size() && pos == -1) {
            Vertex vertex = region.getVerticesList().get(i);
            CentroTuristico c = (CentroTuristico)vertex.getInfo();
            if (centroTuristico.getNombre().equalsIgnoreCase(c.getNombre())) {
                pos = i;
            }else{
                i++;
            }
        }

        return pos;
    }

    //Inciso b
    public List<Sugerencia> procesarSiguienteSolicitud(){
        List<Sugerencia>sugerencias = new LinkedList<>();
        Solicitud solicitud = this.solicitudes.poll();

        if(solicitudes != null){
            int pos = obtenerPosicionVerticeTuristico(solicitud.getCentroTuristico());
            if (pos != -1) {
                Vertex vertex = this.region.getVerticesList().get(pos);
                Iterator<Edge>it = vertex.getEdgeList().iterator();
                while (it.hasNext()) {
                    WeightedEdge we = (WeightedEdge)it.next();
                    Carretera carretera = (Carretera)we.getWeight();
                    if (solicitud.getPresupuestoMax()>=carretera.getCosto()) {
                        CentroTuristico destino = (CentroTuristico)we.getWeight();
                        Sugerencia sugerencia = new Sugerencia(destino,carretera);
                        sugerencias.add(sugerencia);
                    }
                }
            }
        }

        return sugerencias;
    }


    //Inciso c
    public List<CentroTuristico> obtenCentroMasCarreteraEntrantes(){
        List<CentroTuristico>centrosTuristicos = new LinkedList<>();
        int mayor = Integer.MIN_VALUE;
        int i = 0;

        while (i<this.region.getVerticesList().size()) {
            Vertex vertex = region.getVerticesList().get(i);
            int cantidad = this.region.inDegreeDG(i);
            if (cantidad > mayor) {
                mayor = cantidad;
                centrosTuristicos.clear();
                centrosTuristicos.add((CentroTuristico)vertex.getInfo());
            }else if (cantidad == mayor) {
                centrosTuristicos.add((CentroTuristico)vertex.getInfo());
            }
            i++;
        }

        return centrosTuristicos;
    }


    //Inciso d
    public List<CentroTuristico> centrosTuristicosDisponen(CentroTuristico centro,float valorTiempo){
        List<CentroTuristico>listaCentros = new LinkedList<>();
        int i = 0;

        for (Vertex vertex : this.region.getVerticesList()) {
            CentroTuristico c = (CentroTuristico)vertex.getInfo();
            if (c.isDispone()) {
                Iterator<Edge>it = vertex.getEdgeList().iterator();
                boolean aristaEncontrada = false;
                while (it.hasNext() && !aristaEncontrada) {
                    WeightedEdge we = (WeightedEdge)it.next();
                    CentroTuristico centroDestino = (CentroTuristico)we.getVertex().getInfo();
                    if (centroDestino.getNombre().equals(centro.getNombre())) {
                        Carretera carretera = (Carretera)we.getWeight();
                        if (carretera.getTiempo()<valorTiempo) {
                            listaCentros.add(centroDestino);
                        }
                        aristaEncontrada = true;
                    }
                }
            }
        }

        return listaCentros;
    }


    //Inciso e
    public List<CentroTuristico> obtenerCentroDescansoMenorCosto(CentroTuristico origen){
        List<CentroTuristico>resultado = new LinkedList<>();
        int posOrigen = obtenerPosicionVerticeTuristico(origen);

        if (posOrigen != -1) {
            float menorCosto = Float.MAX_VALUE;
            Vertex vertexOrigen = region.getVerticesList().get(posOrigen);
            Iterator<Edge>it = vertexOrigen.getEdgeList().iterator();
            while (it.hasNext()) {
                WeightedEdge we = (WeightedEdge)it.next();
                Carretera carretera = (Carretera)we.getWeight();
                CentroTuristico destino = (CentroTuristico)we.getVertex().getInfo();
                if (destino.isDispone()) {
                    if (carretera.getCosto()<menorCosto) {
                        menorCosto = carretera.getCosto();
                        resultado.clear();
                        resultado.add(destino);
                    }else if (carretera.getCosto() == menorCosto) {
                        resultado.add(destino);
                    }
                }
            }
        }

        return resultado;
    }

}

