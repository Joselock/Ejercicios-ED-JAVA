import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Ejemplo2 {

    public static void main(String[] args) {
        List<String> numeros = new ArrayList<>();
        numeros.add("Uno");
        numeros.add("Dos");
        numeros.add("Tres");
        
        // Obtener ListIterator
        ListIterator<String> listIterator = numeros.listIterator();
        
        // Recorrer hacia adelante
        System.out.println("Recorrido hacia adelante:");
        while (listIterator.hasNext()) {
            String numero = listIterator.next();
            System.out.println(numero);
            
            // Modificar elemento
            if (numero.equals("Dos")) {
                listIterator.set("Dos Modificado");
            }
            
            // Agregar elemento después del actual
            if (numero.equals("Tres")) {
                listIterator.add("Cuatro");
            }
        }
        
        // Recorrer hacia atrás
        System.out.println("\nRecorrido hacia atrás:");
        while (listIterator.hasPrevious()) {
            String numero = listIterator.previous();
            System.out.println(numero);
        }
        
        System.out.println("Lista final: " + numeros);
    }

}
