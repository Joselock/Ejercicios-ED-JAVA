package Busqueda;

import java.util.ArrayList;

public class Lineal {

    

    

    public boolean estaOrdenado(ArrayList<Integer>lista,int tamanio){
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

    public int busquedaLineal(ArrayList<Integer>lista,int tamanio,int n){
        int posicion = 0;
        int i = 0;
        boolean encontrado=false;

        if(estaOrdenado(lista, tamanio)){
            while(i<tamanio && !encontrado ){
                if (lista.get(i)==n) {
                    encontrado = true;
                    posicion=i;
                }else if(lista.get(i)>n){
                    posicion = -1;
                }else{
                    posicion = -1;
                }
                i++;
            }
        }else{
            while (i<tamanio && !encontrado) {
                if (lista.get(i)==n) {
                    encontrado = true;
                    posicion=i;
                }else{
                    posicion = -1;
                }
                i++;
            }
        }

        return posicion;
    }

    

}
