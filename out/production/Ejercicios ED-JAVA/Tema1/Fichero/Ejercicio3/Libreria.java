package Fichero.Ejercicio3;

import java.io.File;

public class Libreria {

    private File libros;
    private File actualizacion;

    public Libreria(File libros, File actualizacion) {
        this.libros = new File("Libros.DAT");
        this.actualizacion = new File("Actualizacion.DAT");
    }

    public File getLibros() {
        return libros;
    }

    public void setLibros(File libros) {
        this.libros = libros;
    }

    public File getActualizacion() {
        return actualizacion;
    }

    public void setActualizacion(File actualizacion) {
        this.actualizacion = actualizacion;
    }

    
    

}
