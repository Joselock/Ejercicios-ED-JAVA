import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class IntegerNum {

    private Deque<Integer>stackIntegerNum;

    public IntegerNum(){
        this.stackIntegerNum= new ArrayDeque<>();
    }
    
    public boolean UpOrder(){
        LinkedList<Integer>auxList=new LinkedList<>();
        int mayor=!stackIntegerNum.isEmpty() ? stackIntegerNum.peek();
        boolean fail=false;

        while (!stackIntegerNum.isEmpty() && !fail) {
            if(mayor>=stackIntegerNum.peek()){
                auxList.add(stackIntegerNum.pop());
            }else{
                fail=false;
            }
            if(fail){
                while (!auxList.isEmpty()) {
                    stackIntegerNum.push(auxList.removeLast());
                }
            }else{
                while (!auxList.isEmpty()) {
                    stackIntegerNum.push(auxList.removeFirst());
                }
            }
           return !fail; 
        }

    }

}
