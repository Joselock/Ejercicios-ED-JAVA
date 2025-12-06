package Actividad17;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cu.edu.cujae.ceis.graph.LinkedGraph;
import cu.edu.cujae.ceis.graph.interfaces.ILinkedDirectedGraph;
import cu.edu.cujae.ceis.graph.vertex.Vertex;

public class SNB {
    private ILinkedDirectedGraph games;

    public SNB() {
        this.games = new LinkedGraph();
    }

    //Inciso b
    public boolean Lost(Equipo equipo){
        boolean result = false;
        int pos = Find(equipo);

        if (pos!=-1) {
            Vertex vertex = games.getVerticesList().get(pos);
            Iterator<Vertex>it = vertex.getAdjacents().iterator();

            while (it.hasNext() && !result) {
                Vertex v = it.next();
                Equipo e = (Equipo)v.getInfo();
                if (!(e.getZona().equals(equipo.getZona()))) {
                    result = true;
                }
            }
        }

        return result;
    }

    //Metodo para devolver la posicion del vertice
    private int Find(Equipo equipo){
        int pos = -1;
        int i = 0;

        while (i<games.getVerticesList().size() && pos == -1) {
            Vertex vertex = games.getVerticesList().get(i);
            Equipo t = (Equipo)vertex.getInfo();

            if (t.getNombre().equalsIgnoreCase(equipo.getNombre())) {
                pos = i;
            }else{
                i++;
            }
        }

        return pos;
    }


    //Inciso c
    public ArrayList<Aux> Zona(String zona){
        ArrayList<Aux>aux = new ArrayList<Aux>();
        int count = 0;
        Iterator<Vertex>it = games.getVerticesList().iterator();

        while (it.hasNext() && count<4) {
            Vertex vertex = it.next();
            Equipo e = (Equipo)vertex.getInfo();
            if (e.getZona().equals(zona)) {
                count++;
                int pos = Find(e);
                int wonGames = games.inDegreeDG(pos);
                if (wonGames>=10) {
                    aux.add(new Aux(e.getNombre(),wonGames));
                }
            }
        }


        return aux;
    }



}
