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
    public boolean darAltaTrabajador(String numId,String nombre,String dpto, float salario)throws IOException,ClassNotFoundException{

        RandomAccessFile fichTrab = new RandomAccessFile(fichero, "rw");

        // Variable para controlar si se puede insertar el trabajador
        boolean insertar=true;

        // Posición en el archivo donde está el contador de trabajadores
        long pos=0;
         // Contador de trabajadores existentes
        int cantTrab=0;
        // Suma total de salarios de todos los trabajadores
        float salarioTotal=0;

        // Verificar si el archivo ya tiene contenido (no está vacío)
        if(fichTrab.length()>0){
            // Leer la longitud del nombre de la empresa (primer int del archivo)
            int tamString = fichTrab.readInt();
            // Saltar los bytes del nombre de la empresa (no nos interesa en esta operación)
            fichTrab.skipBytes(tamString);
            // Guardar la posición actual (donde empieza el contador de trabajadores)
            pos = fichTrab.getFilePointer();
            // Leer la cantidad de trabajadores existentes
            cantTrab=fichTrab.read();
            // Leer el salario total acumulado de todos los trabajadores
            salarioTotal=fichTrab.readFloat();
            // Contador para recorrer los trabajadores existentes
            int cant= 0;

            // Recorrer todos los trabajadores existentes para verificar duplicados
            while (cant<cantTrab && insertar) {
                // Leer la longitud en bytes del siguiente trabajador serializado
                int tamTrab = fichTrab.readInt();
                // Crear array de bytes con la longitud leída
                byte[] trabArrayBytes = new byte[tamTrab];
                // Leer los bytes del trabajador serializado
                fichTrab.read(trabArrayBytes);
                // Deserializar los bytes a objeto Trabajador
                Trabajador trab = (Trabajador)Convert.toObject(trabArrayBytes);

                // Verificar si el ID del trabajador actual coincide con el nuevo
                if (trab.getNumId().equals(numId)) {
                    // Si hay duplicado, marcar que no se puede insertar
                    insertar = false;
                }else{
                     // Si no es duplicado, incrementar contador para siguiente trabajador
                    cant++;
                }
            }
        }

        // Si no hay duplicados y se puede insertar
        if(insertar){
            // Verificar que el salario sea positivo
            if (salario>0) {
                // Crear nuevo objeto Trabajador con los datos proporcionados
                Trabajador trab = new Trabajador(numId, nombre, dpto, salario); 

                // Si el archivo está vacío (primera inserción)
                if (fichTrab.length()==0) {
                    // Serializar el nombre de la empresa a bytes
                    byte[] nombreArrayBytes = Convert.toBytes(this.nombre);
                    // Escribir la longitud del nombre de la empresa
                    fichTrab.writeInt(nombreArrayBytes.length);
                    // Escribir los bytes del nombre de la empresa
                    fichTrab.write(nombreArrayBytes);
                    // Escribir el contador de trabajadores (1, ya que es el primero)
                    fichTrab.writeInt(1);
                    // Escribir el salario total (solo el del primer trabajador)
                    fichTrab.writeFloat(salario);
                }

                // Serializar el objeto Trabajador a bytes
                byte[] trabArrayBytes = Convert.toBytes(trab);
                // Escribir la longitud en bytes del trabajador serializado
                fichTrab.writeInt(trabArrayBytes.length);
                // Escribir los bytes del trabajador serializado
                fichTrab.write(trabArrayBytes);

                // Si el archivo no estaba vacío (ya había trabajadores)
                if (pos != 0) {
                    // Posicionarse en la ubicación del contador de trabajadores
                    fichTrab.seek(pos);
                    // Actualizar el contador de trabajadores (incrementar en 1)
                    fichTrab.writeInt(++cantTrab);
                    // Actualizar el salario total (sumar el nuevo salario)
                    fichTrab.writeFloat(salarioTotal+salario);
                }
            }else{
                // Si el salario no es positivo, no se puede insertar
                insertar = false;
            }
        }

        // Cerrar el archivo
        fichTrab.close();

        return insertar; 
    }

    //Inciso d
    public ArrayList<Trabajador> salarioSuperior(String dpto,File fichero)throws IOException, ClassNotFoundException{
        ArrayList<Trabajador> devolver = new ArrayList<>();
        RandomAccessFile raf = new RandomAccessFile(fichero, "r");

        raf.seek(0);

        //Leer la longitud del nombre de la empresa
        int s = raf.readInt();

        //Saltar el nombre de la empresa
        raf.skipBytes(s);

        //Leer la cantidad de trabajadores
        int tamanio = raf.readInt();

        //Leer salario total
        raf.readFloat();

        //Leer cada trabajador
        for (int i = 0; i < tamanio; i++) {
            int datos = raf.readInt();
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
