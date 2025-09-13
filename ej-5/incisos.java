import java.util.ArrayList;
import java.util.LinkedList;

public class incisos {

    ArrayList<Profesor>profesores= new ArrayList<>();

    //Inciso a
    public String getNombre(CategoriaD cient,int edad){

        int i=0;
        boolean encontrado=false;
        String nombre=" ";

        while (!encontrado && i<profesores.size())  {
            if(profesores.get(i).getCient()==(cient) && profesores.get(i).getEdad()==edad){
                nombre=profesores.get(i).getNombre();
                encontrado=true;
            }
            i++;
        }
        return nombre;
    }


    //Inciso b
    public LinkedList<Profesor> nameMayorEdad(){

        LinkedList<Profesor>nombres=new LinkedList<>();
        int mayor=0;

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

        Registro inst= new Registro(CategoriaD.INSTRUCTOR,0);
        Registro aux= new Registro(CategoriaD.AUXILIAR,0);
        Registro asis= new Registro(CategoriaD.ASISTENTE,0);


        for(Profesor p:profesores){
            switch (p.getCient()) {
                case INSTRUCTOR:
                    inst.incrementar();
                    break;
                case AUXILIAR:
                    aux.incrementar();
                    break; 
                case ASISTENTE:
                    asis.incrementar();
                    break;
                case :
                    .incrementar();
                    break;           
                default:
                    break;
            }
        }

        reg.add(inst);
        reg.add(aux);

        return reg;
    }


}
