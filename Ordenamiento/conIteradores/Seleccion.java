package Ordenamiento.conIteradores;

import java.util.LinkedList;

public class Seleccion {


    public static void main(String[] args) {
     
        LinkedList<Integer>lista = new LinkedList<>();
        int aux,min;

        lista.add(10);
        lista.add(2);
        lista.add(5);
        lista.add(4);
        lista.add(9);
        lista.add(7);
        lista.add(8);
        lista.add(6);
        lista.add(1);
        lista.add(3);

        int tamanio = lista.size();

        for (int i = 0; i < tamanio; i++) {
            min = i;
            for (int j = i+1; j < tamanio; j++) {
                if (lista.get(j)<lista.get(min)) {
                    min = j;
                }
            }
            aux = lista.get(i);
            lista.set(i, lista.get(min));
            lista.set(min,aux);
        }

        System.out.println("Lista ordenada:"+lista);

    }


}
