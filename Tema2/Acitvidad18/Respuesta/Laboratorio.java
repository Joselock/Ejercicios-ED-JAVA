package Tema2.Acitvidad18.Respuesta;

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
    //-Busqueda a lo ancho
    
    public LinkedList<SustanciaC> sonGaseosos(int velocidad){
        LinkedList<SustanciaC>ret = new LinkedList<>();
        InBreadthIterator<Object>iter = sustanciasTree.inBreadthIterator();

        while (iter.hasNext()) {           
            BinaryTreeNode<Object>nodo = iter.nextNode();
          
                if (nodo.getInfo() instanceof SustanciaB) {
                    SustanciaB b = (SustanciaB)nodo.getInfo();
                    if (b.getVelocidadD() == velocidad) {
                        List<BinaryTreeNode<Object>> hijosC = sustanciasTree.getSons(nodo);
                        for (BinaryTreeNode<Object> hijoC : hijosC) {
                            if(hijoC.getInfo() instanceof SustanciaC){
                                SustanciaC sustanciaC = (SustanciaC)hijoC.getInfo();
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

    public boolean cumple(BinaryTreeNode<Object> hijoC){

        boolean cumple = false;
        List<BinaryTreeNode<Object>> hijos = sustanciasTree.getSons(hijoC);
        int cont = 0;

        for (BinaryTreeNode<Object> h : hijos) {
            if (h.getInfo() instanceof SustanciaSimple) {
                SustanciaSimple s = (SustanciaSimple) h.getInfo();
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
