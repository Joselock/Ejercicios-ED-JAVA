package Tema2.Actividad18.Respuesta;

import java.util.LinkedList;
import java.util.List;

import javax.xml.soap.Node;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;

public class Laboratorio {

    GeneralTree<Object>sustanciasTree = new GeneralTree<>(); 

    public Laboratorio(GeneralTree<Object> sustanciasTree) {
        this.sustanciasTree = sustanciasTree;
    }


    //Inciso a 
    
    public LinkedList<SustanciaC> sonGaseosos(int velocidad){
        LinkedList<SustanciaC>ret = new LinkedList<>();
        InBreadthIterator<Object>iter = sustanciasTree.inBreadthIterator();

        while (iter.hasNext()) {           
            BinaryTreeNode<Object>nodo = iter.nextNode();
          
                if (nodo.getInfo() instanceof SustanciaB) {
                    SustanciaB b = (SustanciaB)nodo.getInfo();
                    if (b.getVelocidadD() == velocidad) {
                        List<Object> hijosC = sustanciasTree.getSonsInfo(nodo);
                        for (Object hijoC : hijosC) {
                            if(hijoC instanceof SustanciaC){
                                SustanciaC sustanciaC = (SustanciaC)hijoC;
                                if (cumple(hijoC)) {
                                    ret.add(sustanciaC);
                                }
                            }                     
                        }
                    }
                }
                nodo = iter.nextNode();
        }

        return ret;
    }

    public boolean cumple(Object hijoC){

        boolean cumple = false;
        List<Object> hijos = sustanciasTree.getSonsInfo((BinaryTreeNode<Object>)hijoC);
        int cont = 0;

        for (Object h : hijos) {
            if (h instanceof SustanciaSimple) {
                SustanciaSimple s = ((SustanciaSimple)h);
                if (s.getEstado().equals(Estado.GASEOSO.name())) {
                    cont++;
                }
            }
        }

        if (cont>=3) {
            cumple = true;
        }

        return cumple;
    }

}
