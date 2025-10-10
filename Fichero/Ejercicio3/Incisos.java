package Fichero.Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import Fichero.Convert;

public class Incisos{

    Libreria l = new Libreria(null, null);

    File libros = l.getLibros();

    public Libro getLibro()throws IOException,ClassNotFoundException{

        RandomAccessFile raf = new RandomAccessFile(libros, "rw");

        int datos = raf.readInt();
        byte[] datosBytes = new byte[datos];
        raf.read(datosBytes);
        Libro L = (Libro)Convert.toObject(datosBytes);
        raf.close();

        return L; 
    }

    private void addRaf(Libro L)throws IOException{

        RandomAccessFile raf = new RandomAccessFile(libros, "rw");

        byte[] datos = Convert.toBytes(L);
        raf.writeInt(datos.length);
        raf.write(datos);
        raf.close();

    }

}
