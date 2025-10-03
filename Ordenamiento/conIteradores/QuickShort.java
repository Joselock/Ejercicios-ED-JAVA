package Ordenamiento.conIteradores;

import java.util.ArrayList;

public class QuickShort {
    

    public void quickShort(ArrayList<Integer>lista,int inicio,int fin){
        

        if (inicio<fin) {
           int i = inicio;
           int pivote = lista.get(fin);
           
           // colocar menores a la izquierda del pivote
           for (int j = inicio; j < fin; j++) {
            if (lista.get(j)<pivote) {
                //intercambiar los elementos
                int aux = lista.get(i);
                lista.set(i,lista.get(j));
                lista.set(j, aux);
                i++;
            }
           }

           //colocar el pivote en el lugar correcto
           int temp = lista.get(i);
           lista.set(i,lista.get(fin));
           lista.set(fin, temp);

           //se llama recursivamente
           quickShort(lista,inicio,i-1);
           quickShort(lista,i+1, fin);
        }

    }

    

}
