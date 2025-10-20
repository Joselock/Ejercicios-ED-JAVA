
import java.util.ArrayList;
import java.util.Iterator;

public class Ejemplo1 {

    public static void main(String[] args) {
        
        // Crear una lista
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add("C++");

        // Crear un iterador
        Iterator<String> iterador = lista.iterator();

        // Recorrer la lista usando el iterador
        while (iterador.hasNext()) {
            String elemento = iterador.next();
            System.out.println(elemento);

            // Ejemplo de eliminación
            if (elemento.equals("Python")) {
                iterador.remove();
            }
        }

        System.out.println("Lista después de eliminar: " + lista);
    }

}
