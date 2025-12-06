package Busqueda;

import java.util.ArrayList;

public class Binaria {


    public void binaria(ArrayList<Integer>lista){

        int inicio=0,mitad=0,dato=5;
        boolean bandera=false;

        int fin=lista.size()-1;

        while (inicio<=fin && !bandera) {
            mitad = (inicio+fin)/2;
            if(lista.get(mitad)==dato){
                bandera = true;
            }else if (lista.get(mitad)>dato) {
                fin = mitad-1;
            }else if (lista.get(mitad)<dato) {
                inicio = mitad+1;
            }
        }

        if (!bandera) {
            System.out.println("El numero "+ dato +"no existe");
        }else{
            System.out.println("El numero "+dato+" existe en la posicion "+mitad+" de la lista.");
        }

    }




}
