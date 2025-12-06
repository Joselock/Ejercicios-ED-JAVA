package Ordenamiento;

import java.util.ArrayList;

public class mainQuickShort {

    public static void main(String[] args) {

        ArrayList<Integer>list = new ArrayList<>();
        QuickShort q = new QuickShort();

        list.add(10);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(9);
        list.add(7);
        list.add(8);
        list.add(6);
        list.add(1);
        list.add(3);

        int tamanio = list.size();
    
    int inicio = 0;
    int fin = tamanio-1;


        q.quickShort(list,inicio,fin);

        System.out.println("Lista ordenada "+list);
    }

}
