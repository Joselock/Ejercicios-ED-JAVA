import java.util.ArrayDeque;
import java.util.Deque;

public class Expresion {

    String text;
    String operator;

    public Expresion(String text, String operator) {
        this.text = text;
        this.operator = "+,-,*,/";
    }

    public String PostToIni(){
        Deque<String>stack=new ArrayDeque<>();

        for (int i = 0; i < text.length; i++) {
            String caracter=text.substring(i, i+1);
            if(operator.contains(caracter)){
                String op2=stack.pop();
                String op1=stack.pop();
                String exp=op1+caracter+op2;
                stack.push(exp);
            }else{
                stack.push(caracter);
            }
        }
        return stack.pop();
    }

}
