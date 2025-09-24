package Busqueda;

import java.util.ArrayList;

public class Lineal {

    ArrayList<Integer>lista = new ArrayList<>();

    int tamanio = lista.size();

    public boolean estaOrdenado(){
        boolean cumple = true;
        int i=0;

        while(i < tamanio-1 && cumple) {
            if (lista.get(i)>lista.get(i+1)) {
                cumple = false;
            }
            i++;
        }
        return cumple;
    }

    public int busquedaLineal(int n){
        int posicion = 0;
        int i = 0;
        boolean encontrado=false,noEsta=false;

        if(estaOrdenado()){
            while(i<tamanio && (!encontrado || !noEsta)){
                if (lista.get(i)==n) {
                    encontrado = true;
                    posicion=i;
                }else if (lista.get(i)>n) {
                    noEsta = true;
                    posicion = -1;
                }
                i++;
            }
        }
        return posicion;
    }

    

}
