package Ordenamiento.conIteradores;


import java.util.LinkedList;

public class Burbuja {
     
    public static void main(String[] args) {
        
        LinkedList<Integer>listaN = new LinkedList<>();
        int aux;

        listaN.add(10);
        listaN.add(2);
        listaN.add(5);
        listaN.add(4);
        listaN.add(9);
        listaN.add(7);
        listaN.add(8);
        listaN.add(6);
        listaN.add(1);
        listaN.add(3);
        
        int tamanio = listaN.size();

        for (int i = 0; i < tamanio-1; i++) {
            for (int j = 0; j < tamanio-1; j++) {
             if (listaN.get(j)>listaN.get(j+1)) {
                 aux = listaN.get(j);
                 listaN.set(j, listaN.get(j+1));
                 listaN.set(j+1,aux);
              }
        }
        }

        System.out.println("Lista ordenada"+listaN);
        
    }
    
}
