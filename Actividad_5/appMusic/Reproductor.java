package appMusic;

import java.util.ArrayDeque;
import java.util.Deque;
public class Reproductor {

      private  Deque<Cancion>listaR = new ArrayDeque<>();//pila
      private  Deque<Cancion>pendientes = new ArrayDeque<>();//cola doble

      // Inciso b: reproducir las proximas n canciones
      public void reproducirN(int n){
            int i = 0;

            while (!pendientes.isEmpty() && i<n) {
                  Cancion actual = pendientes.pollFirst();
                  //Asumimos que ya esta creado el metodo playSong
                  //playSong(actual);
                  listaR.push(actual);
            }
      }

      // Inciso c: reproducir las canciones de un autor primero
      public void reproducirAutor(Autor a){
            Deque<Cancion>aux = new ArrayDeque<>();

            String nombre = a.getNombre();

            while (pendientes.contains(nombre)) {
                  Cancion c = pendientes.pollFirst();
                  if(c.getAutor().getNombre().equals(nombre)){
                        aux.push(c);
                  }else{
                        pendientes.offer(c);
                  }
            }

            while (!aux.isEmpty()) {
                pendientes.offerFirst(aux.pollFirst());  
            }
            
      }


      // Inciso d: obtener cantidad de reproducciones
      public void estadisticaR(){
            Deque<Cancion>aux = new ArrayDeque<>(listaR);

             while (!listaR.isEmpty()) {
                  Cancion c = aux.pop();
                  boolean encontrado = false;
                  int i=0;

                  while (encontrado) {
                        
                  }
            }                       
      

            
      } 


}
