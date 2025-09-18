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
        
        // Restaurar la cola para la siguiente prueba
        colaEnteros.cola.clear();
        colaEnteros.cola.add(5);
        colaEnteros.cola.add(12);
        colaEnteros.cola.add(8);
        colaEnteros.cola.add(3);
        colaEnteros.cola.add(15);
        colaEnteros.cola.add(7);
        colaEnteros.cola.add(10);
        
        // Prueba del método eliminarElementos
        System.out.println("\n2. Prueba de eliminarElementos:");
        System.out.println("Cola antes de eliminar (valor límite: 9): " + colaEnteros.cola);
        colaEnteros.eliminarElementos(9);
        System.out.println("Cola después de eliminar elementos > 9: " + colaEnteros.cola);
        
        // Prueba con diferentes valores
        System.out.println("\n3. Pruebas adicionales:");
        
        // Crear otra cola para más pruebas
        Queue<Integer> otraCola = new ArrayDeque<>();
        otraCola.add(2);
        otraCola.add(6);
        otraCola.add(11);
        otraCola.add(4);
        otraCola.add(9);
        
        ColaEnteros cola2 = new ColaEnteros(3, otraCola);
        System.out.println("Otra cola: " + cola2.cola);
        
        int suma2 = cola2.sumaN(3);
        System.out.println("Suma de los primeros 3 elementos: " + suma2);
        
        cola2.eliminarElementos(5);
        System.out.println("Después de eliminar elementos > 5: " + cola2.cola);
        
        // Prueba con casos límite
        System.out.println("\n4. Pruebas de casos límite:");
        Queue<Integer> colaVacia = new ArrayDeque<>();
        ColaEnteros cola3 = new ColaEnteros(0, colaVacia);
        System.out.println("Suma con cola vacía (N=2): " + cola3.sumaN(2));
        
        Queue<Integer> colaCorta = new ArrayDeque<>();
        colaCorta.add(1);
        colaCorta.add(2);
        ColaEnteros cola4 = new ColaEnteros(2, colaCorta);
        System.out.println("Suma con N mayor que tamaño de cola (N=5): " + cola4.sumaN(5));
    }
}