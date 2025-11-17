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
    public String mayorCantBatGanadas(String reino){
        String casa = " ";
        boolean encontrado = false;

        InBreadthIterator<Object>iter = ponienteTree.inBreadthIterator();

        while (iter.hasNext() && !encontrado) {
            BinaryTreeNode<Object>nodo = iter.nextNode();
            int mayor = 0;

            if (nodo.getInfo() instanceof Reino) {
                Reino r = (Reino)nodo.getInfo();
                if (r.getNombre().equals(reino)) {
                    encontrado = true;
                    List<Object>sons = ponienteTree.getSonsInfo(nodo);

                    for (Object c : sons) {
                        if (((CasaNoble)c).getBatallasGanadas()>mayor) {
                            casa = ((CasaNoble)c).getNombre();
                        }
                    }
                }
            }
            nodo = iter.nextNode();
        }

        return casa;
    }


    //Inciso c /================================================================
    // Este metodo esta mal, la libreria de arboles tiene los metodos para eliminar y insertar nodos
    // que en este caso seria eliminar e insertar una casa noble
    //////////////////////////////////////////////////////////////////////////////
    /// /////////////////////////////////////////////////////////////////////
    /// /////////////////////////////////////////////////////////////////////
    public boolean traslado(String deja,String recibe){
        boolean hecho = false;
        boolean eliminado ;
        boolean agregado;
        Reino reinoD = null;
        CasaNoble casa = null;

        InBreadthIterator<Object>iter = ponienteTree.inBreadthIterator();

        casa = buscarMayorCantBatallas(iter,deja,reinoD);

        eliminado = eliminarCasa(reinoD,casa);

        agregado = agregarAlNuevoReino(iter, casa, recibe);

        if (eliminado && agregado) {
            hecho = true;
        }


        return hecho;
    }

    //Metodo para buscar la casa con mas batallas
    public CasaNoble buscarMayorCantBatallas(InBreadthIterator<Object>iter,String deja,Reino reinoD){
        CasaNoble ca = null;
        boolean encontrado = false;

        while (iter.hasNext() && !encontrado) {
            BinaryTreeNode<Object>nodo = iter.nextNode();
            int mayor = 0;

            if (nodo.getInfo() instanceof Reino) {
                if(((Reino)nodo.getInfo()).getNombre().equals(deja)){
                    encontrado = true;
                    List<Object>sons = ponienteTree.getSonsInfo(nodo);
                    for (Object c : sons) {
                        if (((CasaNoble)c).getBatallasGanadas()>mayor) {
                            ca = (CasaNoble)c;
                        }
                    }
                    reinoD = ((Reino)nodo.getInfo());

                }
            }
            nodo = iter.nextNode();
        }

        return ca;
    }

    //Metodo para agregar la casa al  nuevo reino
    public boolean agregarAlNuevoReino(InBreadthIterator<Object>iter,CasaNoble casa,String recibe) {
        boolean encontrado = false;
        boolean hecho = false;
        Reino r = null;

        while (iter.hasNext() && !encontrado) {
            BinaryTreeNode<Object>nodo = iter.nextNode();
        
            if (nodo.getInfo() instanceof Reino) {
                if(((Reino)nodo.getInfo()).getNombre().equals(recibe)){
                    encontrado = true;
                    r = (Reino)nodo.getInfo();
                    r.getCasas().add(casa); // agrego la casa al nuevo reino
                }
            }
            nodo = iter.nextNode();
        }

        if (r.getCasas().contains(casa)) {
            hecho = true;
        }

        return hecho;
    }

    //Metodo para eliminar una casa
    public boolean eliminarCasa(Reino reino,CasaNoble casa){
        boolean hecho = false;
        boolean stop = false;
        String nombre;

        Iterator<CasaNoble>iter = reino.getCasas().iterator(); 

        while (iter.hasNext() && !stop) {
            CasaNoble c = iter.next();
            nombre = c.getNombre();
            
            if (casa.getNombre().equals(nombre)){
                iter.remove();
                stop = true;
            }
        }

        if(!(reino.getCasas().contains(casa))){
            hecho = true;
        }

        return hecho;
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
                        if(((CasaNoble)c).getBatallasGanadas() == cantGanadas){
                            cantidad++;
                        }
                    }
                }
            }
            nodo = iter.nextNode();
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
                    cantidad+=((CasaNoble)c).getFamiliares().size();
                }

                FamiliaresDerecho derechosReino = null ;
                derechosReino.setNombreReino(reino.getNombre());
                derechosReino.setCantConDerecho(cantidad);
                
                ret.add(derechosReino);
            }
            nodo = iter.nextNode();
        }
        return ret;
    }


}
