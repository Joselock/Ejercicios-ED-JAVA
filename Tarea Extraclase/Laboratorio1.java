
import java.util.LinkedList;

public class Laboratorio1 {

    private LinkedList<Integer> list;

    public Laboratorio1() {
        this.list = new LinkedList<>();
    }

    
    // Método a implementar por el estudiante: ORDENAMIENTO QUICK SHORT
    public void sortList(boolean ascending,int inicio,int fin) {
        
        if (inicio<fin) {
           int i = inicio;
           int pivote = list.get(fin);
           
           // colocar menores a la izquierda del pivote
           for (int j = inicio; j < fin; j++) {
            if (list.get(j)<pivote) {
                //intercambiar los elementos
                int aux = list.get(i);
                list.set(i,list.get(j));
                list.set(j, aux);
                i++;
            }
           }

           //colocar el pivote en el lugar correcto
           int temp = list.get(i);
           list.set(i,list.get(fin));
           list.set(fin, temp);


           //se llama recursivamente
           sortList(ascending,inicio,i-1);
           sortList(ascending,i+1, fin);
        }


    }

    //Metodo para saber si esta ordenada la lista para la busqueda lineal
    public boolean estaOrdenado(int tamanio){
        boolean cumple = true;
        int i=0;

        while(i < tamanio-1 && cumple) {
            if (list.get(i)>list.get(i+1)) {
                cumple = false;
            }
            i++;
        }
        return cumple;
    }

    // Método a implementar por el estudiante: BÚSQUEDA LINEAL EN LISTAS ORDENADAS
    public int searchElement(int tamanio,int value) {
        int posicion = 0;
        int i = 0;
        boolean encontrado=false;

        if(estaOrdenado(tamanio)){
            while(i<tamanio && !encontrado ){
                if (list.get(i)==value) {
                    encontrado = true;
                    posicion=i;
                }else if(list.get(i)>value){
                    posicion = -1;
                }else{
                    posicion = -1;
                }
                i++;
            }
        }else{ //en caso de que no este ordenado
            while (i<tamanio && !encontrado) {
                if (list.get(i)==value) {
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

    // Devuelve una copia de la lista
    public LinkedList<Integer> getList() {
        return new LinkedList<>(list);
    }

    // Añadir un elemento
    public void addElement(int n) {
        list.add(n);
    }

    // Verificar si está ordenada de forma ascendente
    public boolean isAscending() {
        LinkedList<Integer> copy = getList();
        boolean ordered = true;

        if (!copy.isEmpty()) {
            int prev = copy.removeFirst();
            while (!copy.isEmpty() && ordered) {
                int current = copy.removeFirst();
                if (prev > current) {
                    ordered = false;
                }
                prev = current;
            }
        }
        return ordered;
    }

    // Verificar si está ordenada de forma descendente
    public boolean isDescending() {
        LinkedList<Integer> copy = getList();
        boolean ordered = true;

        if (!copy.isEmpty()) {
            int prev = copy.removeFirst();
            while (!copy.isEmpty() && ordered) {
                int current = copy.removeFirst();
                if (prev < current) {
                    ordered = false;
                }
                prev = current;
            }
        }
        return ordered;
    }

    // Imprimir la lista
    public void printList() {
        System.out.println(list);
    }

    // --- MAIN PARA PROBAR ---
    public static void main(String[] args) {
        Laboratorio1 list = new Laboratorio1();

        // Insertar 10 números desordenados
        int[] numbers = {42, 7, 19, 3, 25, 14, 8, 31, 50, 2};
        for (int n : numbers) {
            list.addElement(n);
        }

        int tamanio = list.list.size(); ///
        int inicio = 0;            ///Estas tres variable son necesarias para implementar QuickShort
        int fin = tamanio-1;       ///

        // Imprimir lista original
        System.out.println("Lista original:");
        list.printList();

        // Intentar ordenar
        try {
            list.sortList(true,inicio,fin);
            System.out.println("Lista después de ordenar:");
            list.printList();

            if (list.isAscending()) {
                System.out.println("La lista está ordenada ascendentemente.");
            } else if (list.isDescending()) {
                System.out.println("La lista está ordenada descendentemente.");
            } else {
                System.out.println("La lista no quedó ordenada.");
            }

        } catch (UnsupportedOperationException e) {
            System.out.println("El método sortList() aún no está implementado.");
        }

        // Intentar búsqueda
        int value = 25;
        try {
            int result = list.searchElement(tamanio,value);
            if (result != -1) {
                System.out.println("El valor " + value + " fue encontrado en la posición: " + result);
            } else {
                System.out.println("El valor " + value + " no está en la lista.");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("El método searchElement() aún no está implementado.");
        }
    }

}
