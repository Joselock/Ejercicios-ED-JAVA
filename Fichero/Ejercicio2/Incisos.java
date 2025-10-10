package Fichero.Ejercicio2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;

import Fichero.Convert;

public class Incisos {

    Trabajador t = new Trabajador(null, null, null, 0);
    Empresa e = new Empresa(null, 0, 0, null);

    File fichero = e.getFichero();
    String nombre = e.getNombre();

    //Inciso b
    public void crearEncabezamiento()throws IOException{
        
        RandomAccessFile fichTrab = new RandomAccessFile(fichero, "rw");
        

        //Escribir el nombre de la empresa
        byte[] nombreArrayBytes = Convert.toBytes(nombre);
        fichTrab.writeInt(nombreArrayBytes.length);
        fichTrab.write(nombreArrayBytes);

        //Escribir la cantidad de trabajadores inicial 0
        fichTrab.writeInt(0);

        //Ecribor la suma del salario de los trabajadores
        fichTrab.writeFloat(0);
        fichTrab.close();
    }

    //Inciso c
    public boolean darAltaTrabajador(String numId,String nombre,String dpto, float salario)throws IOException{

        RandomAccessFile fichTrab = new RandomAccessFile(fichero, "rw");

        boolean insertar=true;
        long pos=0;
        int cantTrab=0;
        float salarioTotal=0;

        if(fichTrab.length()>0){
            int tamString = fichTrab.readInt();
            fichTrab.skipBytes(tamString);
            pos = fichTrab.getFilePointer();
            cantTrab=fichTrab.read();
            salarioTotal=fichTrab.readFloat();
            int cant= 0;

            while (cant<cantTrab && insertar) {
                int tamTrab = fichTrab.readInt();
                byte[] trabArrayBytes = new byte[tamTrab];
                fichTrab.read(trabArrayBytes);
                Trabajador trab = (Trabajador)Convert.toObject(trabArrayBytes);

                if (trab.getNumId().equals(numId)) {
                    insertar = false;
                }else{
                    cant++;
                }
            }
        }

        if(insertar){
            if (salario>0) {
                Trabajador trab = new Trabajador(numId, nombre, dpto, salario); 

                if (fichTrab.length()==0) {
                    byte[] nombreArrayBytes = Convert.toBytes(this.nombre);
                    fichTrab.writeInt(nombreArrayBytes.length);
                    fichTrab.write(nombreArrayBytes);
                    fichTrab.writeInt(1);
                    fichTrab.writeFloat(salario);
                }

                byte[] trabArrayBytes = Convert.toBytes(trab);
                fichTrab.writeInt(trabArrayBytes.length);
                fichTrab.write(trabArrayBytes);

                if (pos != 0) {
                    fichTrab.seek(pos);
                    fichTrab.writeInt(++cantTrab);
                    fichTrab.writeFloat(salarioTotal+salario);
                }
            }else{
                insertar = false;
            }
        }

        fichTrab.close();

        return insertar; 
    }

    //Inciso d
    public ArrayList<Trabajador> salarioSuperior(String dpto,File fichero){
        ArrayList<Trabajador> devolver = new ArrayList<>();
        RandomAccessFile raf = new RandomAccessFile(fichero, "r");

        raf.seek(0);
        int s = raf.readInt();
        raf.skipBytes(s);
        int tamanio = raf.readInt();
        raf.readDouble();

        for (int i = 0; i < tamanio; i++) {
            Long datos = raf.readLong();
            byte[] datosT = new byte[datos];
            raf.read(datosT);
            Trabajador t = (Trabajador)Convert.toObject(datosT);
            if (t.getDpto().equals(dpto) && t.getSalario()>500) {
                devolver.add(t);
            }
        }
        raf.close();

        return devolver;
    }

}
