package Actividad10;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Facultad {

    LinkedList<Clase>clases = new LinkedList<>();
    LinkedList<GrupoCientifico>grupos = new LinkedList<>();
    File fichero = new File("profesores.dat");

    //Inciso b
    public LinkedList<Estudiante> obtenerLista(String grupo){
    
        LinkedList<Estudiante>lista = new LinkedList<>();
        Iterator<GrupoCientifico>iterator = grupos.iterator();

        while (iterator.hasNext()) {
            GrupoCientifico g = iterator.next();
            if(g.getTema().equals(grupo)){
                lista = g.getLista();
            }
        }

        return lista;
    }


    //Inciso d
    public ArrayList<String> obtenerNombres(String asignatura, int edad) throws ClassNotFoundException, IOException{

        ArrayList<String>devolver = new ArrayList<>();
        RandomAccessFile raf = new RandomAccessFile(fichero, "r");

        int cantP = raf.readInt();

        for (int i = 0; i < cantP; i++) {
            int tamP = raf.readInt();
            byte[] ProfeArray = new byte[tamP];
            raf.read(ProfeArray);
            Profesor p = (Profesor)Convert.toObject(ProfeArray);

            if(p.getAsignatura().equals(asignatura) && p.getEdad()==edad){
                devolver.add(p.getNombre());
            }
        }
        raf.close();

        return devolver;
    }


    //Inciso e
    public boolean verificarExistencia(RandomAccessFile raf,Profesor a) throws IOException, ClassNotFoundException{
        boolean existe = false;
        int i = 0;

        int cantP = raf.readInt();

        while(i < cantP && !existe) {
            int tamPr = raf.readInt();
            byte[] tam = new byte[tamPr];
            raf.read(tam);
            Profesor p = (Profesor)Convert.toObject(tam);

            if (p.getNombre().equals(a.getNombre())) {
                existe = true;
            }

            i++;
        }
        raf.close();

        return existe;
    }


    public boolean anadirProfe(Profesor a) throws ClassNotFoundException, IOException{
        boolean hecho = true;
        RandomAccessFile raf = new RandomAccessFile(fichero, "rw");

        raf.seek(0);
        int cant = raf.readInt();

        if(!verificarExistencia(raf, a)){
            raf.seek(raf.length());
            byte[] profe = Convert.toBytes(a);
            raf.writeInt(profe.length);
            raf.write(profe);
            raf.seek(0);
            raf.write(cant++);
        }else{
            hecho = false;
        }

        return hecho;
    }

}
