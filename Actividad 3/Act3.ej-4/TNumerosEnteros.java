import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class TNumerosEnteros {

    private Queue<Integer>numenteros;

    public numerosEnteros(){
        numenteros = new Queue<Integer>();
    }

    public void numerosOrdenados(Queue<Integer>ascendentes,Queue<Integer>descendentes){
        Deque<Integer>aux=new ArrayDeque<>();

        if(numenteros.size()%2>=0){
            aux=numenteros;

            if(!aux.size%2==0){
                ascendentes.ofert(aux.pollFirst());
            }

            while (!aux.isEmpty()) {
                descendentes.ofert(aux.pollLast());
                ascendentes.ofert(aux.pollFirst());
            }
        }
    }

    public void Ubicar(int valor){
        boolean ok=false;
        Queue<Integer>aux=new ArrayDeque<Integer>();

        while (!numenteros.isEmpty()) {
            int n=numenteros.peek();
            if(n>valor && !ok){
                aux.offer(valor);
                ok=true;
            }
            aux.offer(numenteros.poll());
        }
        if (!ok) {
            aux.offer(valor);
            if(!aux.isEmpty()){
                numenteros=aux;
            }
        }
    }

}
