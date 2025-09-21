package Busqueda;

import java.util.LinkedList;

public class Binaria {

    public static void main(String[] args) {

    LinkedList<Integer>lista = new LinkedList<>();
        int i=0,mitad=0,dato=5;
        boolean bandera=false;


        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        lista.add(7);
        lista.add(8);
        lista.add(9);
        lista.add(10);

        int tamanio=lista.size()-1;

        while (i<=tamanio && !bandera) {
            mitad = (i+tamanio)/2;
            if(lista.get(mitad)==dato){
                bandera = true;
            }else if (lista.get(mitad)>dato) {
                tamanio = mitad-1;
            }else if (lista.get(mitad)<dato) {
                i = mitad+1;
            }
        }

        if (!bandera) {
            System.out.println("El numero no existe");
        }else{
            System.out.println("El numero "+dato+" existe en la posicion "+mitad+" de la lista.");
        }

        

    }

}
