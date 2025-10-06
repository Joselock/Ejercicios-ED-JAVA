import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class incisos {

    ArrayList<Profesor>profesores= new ArrayList<>();

    //Inciso a
    public String Nombre(CategoriaC cient,int edad){

        int i=0;
        boolean encontrado=false;
        String nombre=" ";

        //Mientras que no se haya encontrado y no haya pasado por todos
        while (!encontrado && i<profesores.size())  {
            //Si se cumple entonces ya fue encontrado
            if(profesores.get(i).getCient()==(cient) && profesores.get(i).getEdad()==edad){
                nombre=profesores.get(i).getNombre();
                encontrado=true;
            }
            i++;
        }
        return nombre;
    }

    //Inciso (a) utilizando iteradores
    /*public String Nombre(CategoriaC cient,int edad){

        Iterator<Profesor> it = profesores.iterator();
        boolean encontrado=false;
        String nombre=" ";

        //Mientras que no se haya encontrado y no haya pasado por todos
        while (!encontrado && it.hasNext()){
            //Si se cumple entonces ya fue encontrado
            Profesor p = it.next();
            if(p.getCient()==(cient) && p.getEdad()==edad){
                nombre=p.getNombre();
                encontrado=true;
            }
            i++;
        }
        return nombre;
    }*/


    //Inciso b
    public LinkedList<Profesor> nameMayorEdad(){

        LinkedList<Profesor>nombres=new LinkedList<>();
        int mayor=0;

        //Recorro todas la edades y verifico cuales cumplen
        for(Profesor p:profesores){
            if(p.getEdad()>mayor){
                mayor=p.getEdad();
                nombres.clear();
                nombres.addFirst(p);
            }else if(p.getEdad()==mayor){
                nombres.addFirst(p);
            }
        }
        return nombres;
    }


    //Inciso c
    public LinkedList<Registro> crear(){

        LinkedList<Registro>reg=new LinkedList<>();

        //En el regitro voy a tener las cantidades de cada categoria docente
        Registro inst = new Registro(CategoriaD.INSTRUCTOR,0);
        Registro aux = new Registro(CategoriaD.AUXILIAR,0);
        Registro asis = new Registro(CategoriaD.ASISTENTE,0);
        Registro tit = new Registro(CategoriaD.INSTRUCTOR, 0);

        //Se podria haber incrementado directamente en los *****
        for(Profesor p:profesores){
            switch (p.getDoc()) {
                case INSTRUCTOR:
                    inst.incrementar();     //***   
                    break;
                case AUXILIAR:
                    aux.incrementar();      //*** 
                    break; 
                case ASISTENTE:
                    asis.incrementar();     //*** 
                    break;
                 case TITULAR:
                    tit.incrementar();      //*** 
                    break;          
                default:
                    break;
            }
        }

        //Agrego las cantidades finales a la lista que voy a mostrar
        reg.add(inst);
        reg.add(aux);
        reg.add(asis);
        reg.add(tit);

        return reg;
    }


}
