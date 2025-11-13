import java.util.ArrayList;
import java.util.LinkedList;

import cu.edu.cujae.ceis.tree.binary.BinaryTreeNode;
import cu.edu.cujae.ceis.tree.general.GeneralTree;
import cu.edu.cujae.ceis.tree.iterators.general.InBreadthIterator;

public class PersonalFacultad {

    private String nombre;
    private String extension;
    private String nombreDecano;
    private GeneralTree<Object>personalTree;
    
    public PersonalFacultad(String nombre, String extension, String nombreDecano) {
        this.nombre = nombre;
        this.extension = extension;
        this.nombreDecano = nombreDecano;
        personalTree = new GeneralTree<Object>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNombreDecano() {
        return nombreDecano;
    }

    public void setNombreDecano(String nombreDecano) {
        this.nombreDecano = nombreDecano;
    }


    //Inciso a
    public LinkedList<Grupo> matriculaDada(int m){
        LinkedList<Grupo>ret = new LinkedList<Grupo>();

        if (!personalTree.isEmpty()) {
            InBreadthIterator<Object>iter = personalTree.inBreadthIterator();
            BinaryTreeNode<Object>nodo = iter.nextNode();

            while (!(nodo.getInfo() instanceof Estudiante)) {
                if (nodo.getInfo() instanceof Grupo) {
                    if (personalTree.getSons(nodo).size() == m) {
                        ret.add((Grupo)nodo.getInfo());
                    }
                }
                nodo = iter.nextNode();
            }
        }

        return ret;
    }


    //Inciso b
    public LinkedList<Estudiante> buscar(String id){
        LinkedList<Estudiante>ret = new LinkedList<Estudiante>();
        InBreadthIterator<Object>iter = personalTree.inBreadthIterator();

        while (!personalTree.isEmpty()) {
            BinaryTreeNode<Object>nodo = iter.nextNode();

            if (nodo.getInfo() instanceof Grupo) {
                Grupo g = (Grupo)nodo.getInfo();
                if (g.getIdentificador().equals(id)) {
                    ArrayList<BinaryTreeNode<Object>>sons = (ArrayList<BinaryTreeNode<Object>>)personalTree.getSons(nodo);

                    for (Object stud : sons) {
                        if (((Estudiante)stud).getSexo() == 'F' && ((Estudiante)stud).isMilitancia()) {
                            ret.add(((Estudiante)stud));
                        }
                    }
                }
            }
        }


        return ret;
    }

}
