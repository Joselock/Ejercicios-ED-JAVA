import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;

public class Mundo {
    GeneralTree<Object>ponienteTree;

    public Mundo(GeneralTree<Object> ponienteTree) {
        this.ponienteTree = new GeneralTree<>();
    }

    //Inciso b /================================================================
    public CasaNoble mayorCantBatGanadas(String reino){
        CasaNoble casa = null;
        boolean encontrado = false;
        int mayor;

        InBreadthIterator<Object>iter = ponienteTree.inBreadthIterator();

        while (iter.hasNext() && !encontrado) {
            BinaryTreeNode<Object>nodo = iter.nextNode();
            mayor = 0;

            if (nodo.getInfo() instanceof Reino) {
                Reino r = (Reino)nodo.getInfo();
                if (r.getNombre().equals(reino)) {
                    encontrado = true;
                    List<Object>sons = ponienteTree.getSonsInfo(nodo);

                    for (Object c : sons) {
                        if(c instanceof CasaNoble){
                            if (((CasaNoble)c).getBatallasGanadas()>mayor) {
                            casa = ((CasaNoble)c);
                            mayor = ((CasaNoble)c).getBatallasGanadas();
                            }
                        }            
                    }
                }
            }
        }

        return casa;
    }


    //===========================================================
    /////////////////////////////////////////////////////////////
    /// /////////////////////////////////////////////////////////
    /// ////////////////////////////////////////////////////////


    //Inciso c /======================================================
    
    public boolean traslado(String deja,String recibe){
        boolean hecho = false;
        boolean agregado;
        BinaryTreeNode<Object> reino = null;
        BinaryTreeNode<Object> casa = null;

        InBreadthIterator<Object>iter = ponienteTree.inBreadthIterator();

        casa = buscarCasaMayorCantBatallas(iter,deja); // Buscar la casa con la mayor cantidad de batallas ganadas
        reino = dondeVoyAnadirCasa(iter, recibe);  // Buscar el reino a donde voy a anadir la casa con la mayor cantidad

        //Metodo que agrega la casa al reino que me pasan (recibe)
        agregado = ponienteTree.insertNode(casa, reino);
        
        //Metodo que borra la casa del reino que me pasan (deja)
        ponienteTree.deleteNode(casa);


        if (agregado) { //Si se agrego la casa al reino
            hecho = true;
        }

        return hecho;
    }

    //Metodo para buscar la casa con mas batallas
    public BinaryTreeNode<Object> buscarCasaMayorCantBatallas(InBreadthIterator<Object>iter,String deja){
        BinaryTreeNode<Object> ca = null;
        boolean encontrado = false;
        int mayor;

        while (iter.hasNext() && !encontrado) {
            BinaryTreeNode<Object>nodo = iter.nextNode();
            mayor = 0;

            if (nodo.getInfo() instanceof Reino) {
                if(((Reino)nodo.getInfo()).getNombre().equals(deja)){
                    encontrado = true;
                    List<Object>sons = ponienteTree.getSonsInfo(nodo);
                    for (Object c : sons) {
                        if(c instanceof CasaNoble){
                            if(((CasaNoble)c).getBatallasGanadas()>mayor) {
                            mayor = ((CasaNoble)c).getBatallasGanadas();
                            ca = (BinaryTreeNode<Object>)c;
                            }
                        }   
                    }
                }
            }
        }

        return ca;
    }

    // Buscar el reino donde voy a agregar el la casa
    public BinaryTreeNode<Object> dondeVoyAnadirCasa(InBreadthIterator<Object>iter,String recibe){
        BinaryTreeNode<Object>r = null;
        boolean encontrado = false;

        while (iter.hasNext() && !encontrado) {
            BinaryTreeNode<Object>nodo = iter.nextNode();

            if (nodo.getInfo() instanceof Reino) {
                if(((Reino)nodo.getInfo()).getNombre().equals(recibe)){
                    encontrado = true;
                    r = nodo;
                }
            }
        }
       
        return r;
    }


    //===========================================================
    /////////////////////////////////////////////////////////////
    /// /////////////////////////////////////////////////////////
    /// ////////////////////////////////////////////////////////


    //Inciso d /====================================================
    
    public int cantCasasNobles(int cantGanadas){
        int cantidad = 0;

        InBreadthIterator<Object>iter = ponienteTree.inBreadthIterator();

        while (iter.hasNext()) {
            BinaryTreeNode<Object>nodo = iter.nextNode();

            if (nodo.getInfo() instanceof Reino) {
                if (((Reino)nodo.getInfo()).getGobernatesPasados().size() >=3) {
                    List<Object>casas = ponienteTree.getSonsInfo(nodo);
                    
                    for (Object c : casas) {
                        if(c instanceof CasaNoble){
                            if(((CasaNoble)c).getBatallasGanadas() == cantGanadas){
                            cantidad++;
                            }
                        }
                        
                    }
                }
            }
        }

        return cantidad;
    }


    //Inciso e /======================================================

    public LinkedList<FamiliaresDerecho> obtenerFamiliares(){
        LinkedList<FamiliaresDerecho>ret = new LinkedList<>();
        InBreadthIterator<Object>iter = ponienteTree.inBreadthIterator();

        while (iter.hasNext()) {
            BinaryTreeNode<Object>nodo = iter.nextNode();
            int cantidad = 0;

            if (nodo.getInfo() instanceof Reino) {
                Reino reino = (Reino)nodo.getInfo();
                List<Object>casas = ponienteTree.getSonsInfo(nodo);
                
                for (Object c : casas) {
                    if (c instanceof CasaNoble) {
                        cantidad+=((CasaNoble)c).getFamiliares().size();
                    }         
                }

                FamiliaresDerecho derechosReino = null ;
                derechosReino.setNombreReino(reino.getNombre());
                derechosReino.setCantConDerecho(cantidad);
                
                ret.add(derechosReino);
            }
        }
        return ret;
    }


}
