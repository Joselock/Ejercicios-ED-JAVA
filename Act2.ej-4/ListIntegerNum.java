import java.util.LinkedList;

public class ListIntegerNum {

    LinkedList<Integer>listIntegerNum;
    
    public ListIntegerNum(){
        this.listIntegerNum = new LinkedList<>();
    }

    public LinkedList<Integer> getList(){
        return listIntegerNum;
    }

    public void add(Integer num){
        listIntegerNum.add(num);
    }

    public boolean UpOrder(){
        LinkedList<Integer>auxList = new LinkedList<Integer>();
        boolean isOrdered=true;//Inicializada como que si está ordenada
        int menor=0;

        if(listIntegerNum.size()>1){
            menor = listIntegerNum.getFirst();
        }

        while (!listIntegerNum.isEmpty() && isOrdered) {
            if(listIntegerNum.getFirst()>=menor){
                menor=listIntegerNum.getFirst();
                auxList.add(auxList.removeFirst());
            }else{
                isOrdered=false;//Encontramos un elemento desordenado
            }
        }

        if(isOrdered){
            listIntegerNum=auxList;//Si está ordenado se mantiene el reverso
        }else{
            //Se restaura la lista original
            while (!auxList.isEmpty()) {
                auxList.add(auxList.removeFirst());
            }
        }
        
        return isOrdered;
    }

}
