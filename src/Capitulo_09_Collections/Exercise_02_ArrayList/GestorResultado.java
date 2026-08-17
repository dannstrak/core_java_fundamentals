package Capitulo_09_Collections.Exercise_02_ArrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestorResultado {
    static void main(String[] args) {
        ArrayList<Integer> puntajes = new ArrayList<>();
        puntajes.add(85);
        puntajes.add(92);
        puntajes.add(78);
        puntajes.add(99);
        puntajes.add(65);

        var puntaje4to = puntajes.get(3);
        System.out.println("El puntaje en la posición 3 es:"+ puntaje4to);
        // Utilizacion del set para modificar
        puntajes.set(1, 0);
        //
        puntajes.sort(null);
        System.out.println("Impresión de todos los elementos ordenados:");
        // Usamos el bucle for clásico aprovechando el tamaño de la lista
        for (int i = 0; i < puntajes.size(); i++) {
            // Usamos el superpoder O(1) de ArrayList para acceder al valor
            System.out.println("Posición " + i + " = " + puntajes.get(i));
        }
    }
}
