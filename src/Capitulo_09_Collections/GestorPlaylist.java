package Capitulo_09_Collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GestorPlaylist {
    public static void agregarExtremos(LinkedList <String> lista, String primero, String ultimo){
        lista.addFirst(primero);
        lista.addLast(ultimo);
    }
    public static void imprimirIdaYVuelta(LinkedList<String> lista){
       ListIterator<String> iterador01 = lista.listIterator();
       while(iterador01.hasNext()){
           System.out.print(iterador01.next());
           System.out.print( "->");
           while(iterador01.hasPrevious()){
               System.out.print(iterador01.previous());
               System.out.print( "<-");
           }
       }
    }
}

