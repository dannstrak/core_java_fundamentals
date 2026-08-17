package Capitulo_09_Collections.Exercise_01_LInkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class HistorialNavegador {

    static void main() {
        List<String> historial = new LinkedList<>();
        historial.add("Google");
        historial.add("StackOverflow");
        historial.add("GitHub");
        // Insertamos elementos en la primera posicion de la lista.
        historial.addFirst( "NuevaPestana");
        historial.addLast("Cierre de Sesion");
        // Creamos una listIterator.
        ListIterator<String> iterador = historial.listIterator();
        while(iterador.hasNext()){
            var elemento = iterador.next();
            System.out.print(elemento + "->");
        }
        System.out.println(" ");
        while(iterador.hasPrevious()){
            var elemento = iterador.previous();
            System.out.print(elemento + "<-");
        }
        // Reiniciamos el cursor
        ListIterator<String> iteradorModificado = historial.listIterator();
        // Damos dos pasos exactos hacia adelante
        iteradorModificado.next();
        iteradorModificado.next();
        // Insertamos en esa posición usando el iterador
        iteradorModificado.add("YouTube");
        while(iteradorModificado.hasNext()){
            var valor = iteradorModificado.next();
            if(valor.equals("StackOverflow")){
                iteradorModificado.remove();
            }
        }
    }
}
