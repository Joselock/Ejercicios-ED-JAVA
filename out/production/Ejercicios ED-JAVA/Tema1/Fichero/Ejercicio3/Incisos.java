package Fichero.Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import Fichero.Convert;

public class Incisos{

    Libreria l = new Libreria(null, null);

    File libros = l.getLibros();
    File actualizacion = l.getActualizacion();

   //Inciso b
   public void actualizarExistencia()throws IOException,ClassNotFoundException{

    RandomAccessFile fichLib = new RandomAccessFile(libros, "rw");
    RandomAccessFile fichActua = new RandomAccessFile(actualizacion, "r");

    //Leo la cantidad de libros
    int cantLibros = fichLib.readInt();
    //No tiene encabezamiento
    long cantBytes = fichActua.length();
    int i = 0;

    LibroActualizacion libroA = null;

    while (fichLib.getFilePointer()<cantBytes) {   //Mientras no se acabe el actualizar
        boolean terminado = false;

        while (i<cantLibros && !terminado) {  //Mientras haya libros y no haya leido el ultimo actualizar
            //convierto el libro del fichero original
            long  posLibro = fichLib.getFilePointer();
            int tamLibro = fichLib.readInt();
            byte[] libroBytes = new byte[tamLibro];
            fichLib.read(libroBytes);
            Libro libro = (Libro)Convert.toObject(libroBytes);

            if (libroA==null) {  //implica que no es la primera vez que se entra  
                //o aun no se ha encontrado el elemento en el fichero

                //leo el elemento de la actualizacion
                int tamActua = fichActua.readInt();
                byte[] actuaBytes = new byte[tamActua];
                fichActua.read(actuaBytes);
                libroA = (LibroActualizacion)Convert.toObject(actuaBytes);

            }

            /*Si son el mismo identificador ,actualiza la cantidad, y se valida
          que si se va a restar la cantidad en actualizacion no sea mayor que 
          la cantidadque hay */

          if (libro.getId().equals(libroA.getId())) {
            if (libroA.getTipoMovimiento()=='A') {
                libro.setCantEjemplares(libro.getCantEjemplares()+libroA.getCantMovimiento());
            }else if(libro.getCantEjemplares()>=libroA.getCantMovimiento()){
                libro.setCantEjemplares(libro.getCantEjemplares()-libroA.getCantMovimiento());
            }

            fichLib.seek(posLibro);
            libroBytes = Convert.toBytes(libro);
            fichLib.write(libroBytes);
            fichLib.write(libroBytes);
            libroA=null;

            //este if se añadió para que pare de recorrer los libros originales si ya no hay mas nada en actualización
            if (fichActua.getFilePointer()== cantBytes) {
                terminado = true;
            }
          }
          i++;
        }
    }
    fichActua.close();
    fichLib.close();
    
   }

}
