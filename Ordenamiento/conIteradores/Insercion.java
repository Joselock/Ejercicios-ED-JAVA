package Ordenamiento.conIteradores;

import java.util.LinkedList;

public class Insercion {

    public static void main(String[] args) {
     
        LinkedList<Integer>lista = new LinkedList<>();
        int aux,pos;

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

        for (int i = 1; i < tamanio; i++) {
            aux = lista.get(i);
            pos = i;
            
            while ((pos>0) && (aux<lista.get(pos-1))) {
                lista.set(pos, lista.get(pos-1));
                pos--;
            }
            lista.set(pos,aux);
        }

        System.out.println("Lista ordenada:"+lista);

    }

    

}
