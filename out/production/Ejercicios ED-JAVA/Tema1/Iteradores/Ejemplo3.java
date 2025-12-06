import java.util.LinkedList;
import java.util.ListIterator;

public class Ejemplo3 {

     public static void main(String[] args) {
        LinkedList<Integer> numeros = new LinkedList<>();
        
        // Agregar elementos
        for (int i = 1; i <= 5; i++) {
            numeros.add(i);
        }
        
        ListIterator<Integer> iterator = numeros.listIterator();
        
        // Duplicar números pares
        while (iterator.hasNext()) {
            int numero = iterator.next();
            if (numero % 2 == 0) {
                iterator.add(numero * 10); // Insertar después del actual
            }
        }
        
        System.out.println("Lista modificada: " + numeros);
        
        // Recorrer desde el final
        System.out.println("\nDesde el final:");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
    }

}
