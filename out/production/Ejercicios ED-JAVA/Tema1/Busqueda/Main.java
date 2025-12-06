package Busqueda;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer>lista = new ArrayList<>();
        Lineal l = new Lineal();
        Binaria b = new Binaria();

        lista.add(1);
        lista.add(24);
        lista.add(32);
        lista.add(45);
        lista.add(55);
        lista.add(66);
        lista.add(75);
        lista.add(89);
        lista.add(90);
        lista.add(103);

        int tamanio = lista.size();
        int n = 24;

        int p = l.busquedaLineal(lista, tamanio, n);
        b.binaria(lista);

        System.out.println("El numero "+n+" esta en la posicion: "+p);
        
    }

}
