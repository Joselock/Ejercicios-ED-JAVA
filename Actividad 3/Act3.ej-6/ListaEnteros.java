import java.util.ArrayDeque;
import java.util.Deque;

public class ListaEnteros {

    Deque<Integer>pila = new ArrayDeque<>();


    public void reorganizar(){
        Deque<Integer>par=new ArrayDeque<>();
        Deque<Integer>impar=new ArrayDeque<>();

        for(Integer v:pila){
            int top = v.pop();
            if (v.pop()%2==0) {
                v.pop(par.push(top));
            }else{
                v.pop(impar.push(top));
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
