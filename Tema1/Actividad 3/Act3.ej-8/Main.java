import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // Crear una cola de ejemplo con algunos valores
        Queue<Integer> colaEjemplo = new ArrayDeque<>();
        colaEjemplo.add(5);
        colaEjemplo.add(12);
        colaEjemplo.add(8);
        colaEjemplo.add(3);
        colaEjemplo.add(15);
        colaEjemplo.add(7);
        colaEjemplo.add(10);
        
        // Crear instancia de ColaEnteros
        ColaEnteros colaEnteros = new ColaEnteros(5, colaEjemplo);
        
        System.out.println("=== PRUEBA DE LA CLASE COLAENTEROS ===");
        System.out.println("Cola original: " + colaEnteros.cola);
        
        // Prueba del método sumaN
        System.out.println("\n1. Prueba de sumaN:");
        int suma = colaEnteros.sumaN(4);
        System.out.println("Suma de los primeros 4 elementos: " + suma);
        System.out.println("Cola después de sumaN: " + colaEnteros.cola);
        
        // Prueba del método eliminarElementos
        System.out.println("\n2. Prueba de eliminarElementos:");
        System.out.println("Cola antes de eliminar (valor límite: 9): " + colaEnteros.cola);
        colaEnteros.eliminarElementos(9);
        System.out.println("Cola después de eliminar elementos > 9: " + colaEnteros.cola);
        
    }
}