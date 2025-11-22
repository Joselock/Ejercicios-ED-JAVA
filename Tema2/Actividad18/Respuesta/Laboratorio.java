package Tema2.Actividad18.Respuesta;

import java.util.LinkedList;
import java.util.List;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;
import cu.edu.cujae.ceis.tree.iterators.general.InDepthIterator;

public class Laboratorio {

    GeneralTree<Object>sustanciasTree; //Para busqueda a lo ancho
    GeneralTree<Sustancia>laboratorio; //Para busqueda en profundidad
    // ESTAS SON DISTINTAS FORMAS DE HACERLO , YA SEA CON OBJECT O SUSTANCIA

    public Laboratorio(GeneralTree<Object> sustanciasTree,GeneralTree<Sustancia>laboratorio) {
        this.sustanciasTree = new GeneralTree<>();
        this.laboratorio = new GeneralTree<>();
    }


    //Inciso a 
    // === BUSQUEDA A LO ANCHO   
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
                            if((SustanciaC)hijoC.getInfo() instanceof SustanciaC){
                                SustanciaC sustanciaC = (SustanciaC)hijoC.getInfo();
                                if (cumple(hijoC)) {
                                    ret.add(sustanciaC);
                                }
                            }                     
                        }
                    }
                }
        }

        return ret;
    }

    public boolean cumple(BinaryTreeNode<Object> hijoC){

        boolean cumple = false;
        List<Object> hijos = sustanciasTree.getSonsInfo(hijoC);
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

    //===BUSQUEDA A LO PROFUNDO
    public LinkedList<SustanciaC> sustanciasC (int velocidad) {

        LinkedList<SustanciaC>sustancias= new LinkedList<SustanciaC> ();
        boolean encontrado=false;
        int cantGaseosas=0;
        InDepthIterator<Sustancia>iterator= laboratorio.inDepthIterator();

        while (iterator.hasNext()&& !encontrado) {
            BinaryTreeNode <Sustancia> cursor = iterator.nextNode();
            if(cursor.getInfo() instanceof SustanciaB){
                if(((SustanciaB)cursor.getInfo()).getVelocidadD()== velocidad){
                 encontrado=true;	
                 List<BinaryTreeNode<Sustancia>>sustanciasCdeB= laboratorio.getSons(cursor);

                    for (BinaryTreeNode<Sustancia> sustancia : sustanciasCdeB) {
                    List <Sustancia> simples= laboratorio.getSonsInfo(sustancia);
                        for (int i = 0; i < simples.size() && cantGaseosas<3; i++){ 	
                            Sustancia s = simples.get(i);	
                            if(s.getEstado().equals(Estado.GASEOSO.name())){
                                cantGaseosas++;	
                            }
                            if (cantGaseosas==3){ 							                
                                sustancias.add((SustanciaC)sustancia.getInfo());
                            }
                            cantGaseosas=0;
                        }
                    }
                }
            }	
        }    
        return sustancias;
    }

}
