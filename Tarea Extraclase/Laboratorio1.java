import java.util.LinkedList;

public class Laboratorio1 {

    private LinkedList<Integer> list;

    public Laboratorio1() {
        this.list = new LinkedList<>();
    }

    // Método a implementar por el estudiante: ORDENAMIENTO
    public void sortList(boolean ascending) {
        // TODO: Implementar según el algoritmo asignado
        // 1. Quick Sort
        // 2. Insertion Sort
        // 3. Shell Sort
        // 4. Merge Sort
        // Usar 'ascending' para decidir si es ascendente o descendente 
        throw new UnsupportedOperationException("Método sortList() no implementado");
    }

    // Método a implementar por el estudiante: BÚSQUEDA
    public int searchElement(int value) {
        // TODO: Implementar según el algoritmo asignado
        // 1. Búsqueda Lineal en listas ordenadas
        // 2. Hash
        // 3. Búsqueda Interpolada
        // 4. Búsqueda Binaria
        // IMPORTANTE: retornar la posición (índice empezando en 0) si se encuentra,
        // o -1 si el valor no está en la lista.
        throw new UnsupportedOperationException("Método searchElement() no implementado");
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

        // Imprimir lista original
        System.out.println("Lista original:");
        list.printList();

        // Intentar ordenar
        try {
            list.sortList(true);
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
            int result = list.searchElement(value);
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
