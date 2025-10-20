import java.util.ArrayDeque;
import java.util.Queue;


public class ColaEnteros {

    private int N;
    Queue<Integer>cola=new ArrayDeque<>(); 

    public ColaEnteros(int N, Queue<Integer> cola) {
        this.N = N;
        this.cola = cola;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }
    

    //Suma de los primeros n valores de la cola
    public int sumaN(int N){
        int suma = 0;
        int tamanio = 0;
        Queue<Integer>aux=new ArrayDeque<>(cola);

        tamanio = cola.size();

        if (!cola.isEmpty()) {          
            if(tamanio<=N){
                suma = -1;
            }else{
                for (int i = 0; i < N; i++) {
                suma+=aux.poll();
                } 
            }                
        }

        return suma;
    }


    //Eliminar elementos mayores que una valor dado
    public void eliminarElementos(int valor){
        int tamanio = cola.size();
        for (int i=0;i<tamanio;i++) {
            int elemento = cola.poll();
            if(elemento<=valor){
                cola.offer(elemento);
            }
        }
    }
     
}
