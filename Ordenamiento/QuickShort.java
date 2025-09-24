package Ordenamiento;

import java.util.ArrayList;

public class QuickShort {

    ArrayList<Integer>lista = new ArrayList<>();
    int tamanio = lista.size();

    int ini=0;
    int f=tamanio;
    
    int inicio = lista.get(ini);
    int fin = lista.get(f);



    public void quickShort(int inicio,int fin){
        

        if (inicio<fin) {
           int i = inicio;
           int pivote = fin;
           
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
           quickShort(inicio,i-1);
           quickShort(i+1, fin);
        }

    }

}
