 
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Incisos<Persona> {

    Deque<Persona>lista = new ArrayDeque<>();

    public LinkedList<Persona> obteneInversa(){
        LinkedList<Persona>devolver = new LinkedList<>();
        Deque<Persona>aux = new ArrayDeque<>();

        while (!lista.isEmpty()) {
            Persona p = lista.removeLast();
            aux.push(p);
            devolver.addLast(p);
        }

        while (!aux.isEmpty()) {
            lista.push(aux.pop());
        }

        return devolver;
    }

}
