package Actividad11;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import Actividad10.Convert;

public class Incisos {
    Deque<Estudiante>estudiantes = new ArrayDeque<>();
    File fichero = new File("estudiantes.dat");

    //Inciso a
    public LinkedList<Estudiante> buscarMenores(){
        LinkedList<Estudiante>devolver = new LinkedList<>();
        Deque<Estudiante>aux = new ArrayDeque<>();

        while (!estudiantes.isEmpty()) {
            Estudiante e = estudiantes.pop();
            if (e.getSexo()=='F' && e.getEdad()<20) {
                devolver.add(e);
            }
            aux.push(e);
        }

        while (!aux.isEmpty()) {
            estudiantes.push(aux.pop());
        }

        return devolver;
    }

    //Inciso b
     public LinkedList<Estudiante> menoresVcunadas(){
        LinkedList<Estudiante>devolver = new LinkedList<>();
        Deque<Estudiante>aux = new ArrayDeque<>();

        while (!estudiantes.isEmpty()) {
            Estudiante e = estudiantes.pop();
            if (e.getSexo()=='F' && e.getEdad()<20 && !e.vacunar()) {
                devolver.addFirst(e);
            }
            aux.push(e);
        }

        while (!aux.isEmpty()) {
            estudiantes.push(aux.pop());
        }

        return devolver;
    }


    //Inciso c
    public LinkedList<Estudiante> menores() throws IOException, ClassNotFoundException{
        LinkedList<Estudiante>devolver = new LinkedList<>();
        RandomAccessFile raf = new RandomAccessFile(fichero, "r");

        raf.skipBytes(raf.readInt());
        raf.skipBytes(raf.readInt());
        int total = raf.readInt();
        
        for (int i = 0; i < total; i++) {
            int tamEst = raf.readInt();
            byte[] estudiante = new byte[tamEst];
            raf.read(estudiante);
            Estudiante e = (Estudiante)Convert.toObject(estudiante);

            if (e.getSexo()=='F' && e.getEdad()<20) {
                devolver.addFirst(e);
            }
        }

        return devolver;
    }


}
