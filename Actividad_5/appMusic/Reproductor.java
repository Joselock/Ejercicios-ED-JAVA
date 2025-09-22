package appMusic;


import java.util.ArrayDeque;
import java.util.Deque;



public class Reproductor {

      private  Deque<Cancion>lista = new ArrayDeque<>();
      private  Deque<Cancion>pendientes = new ArrayDeque<>();

      // Inciso b: reproducir las proximas n canciones
      public void reproducirN(int n){
            int i = 0;

            while (!pendientes.isEmpty() && i<n) {
                  Cancion actual = pendientes.pollFirst();
                  //Asumimos que ya esta creado el metodo playSong
                  //playSong(actual);
                  lista.push(actual);
            }
      }



}
