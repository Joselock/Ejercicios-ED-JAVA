import java.util.ArrayDeque;
import java.util.Deque;

public class ListaEnteros {

    Deque<Integer>pila = new ArrayDeque<>();


    public void reorganizar(){
        Deque<Integer>par=new ArrayDeque<>();
        Deque<Integer>impar=new ArrayDeque<>();

        for(int i=0;i<pila.size();i++){
             int top = pila.peek();
            if (top%2==0) {
                par.push(pila.pop());
            }else{
                impar.push(pila.pop());;
            }
        }

        while (!par.isEmpty()) {
            pila.push(par.pop());
        }
        while (!impar.isEmpty()) {
            pila.push(impar.pop());
        }
    }
    

}
