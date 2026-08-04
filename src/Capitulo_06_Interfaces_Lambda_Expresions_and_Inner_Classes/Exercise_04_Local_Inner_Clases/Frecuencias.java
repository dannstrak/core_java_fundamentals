package Capitulo_06_Interfaces_Lambda_Expresions_and_Inner_Classes.Exercise_04_Local_Inner_Clases;

import java.util.*;

public class Frecuencias {

    public static void procesarFrecuencias(int[] ids) {

        // Debe tener dos atributos: int id, int count.
        // Escribe tu código aquí:
        class Nodo{
            int id;
            int count;

            public Nodo(int id, int count) {
                this.id = id;
                this.count = count;
            }
        }

        List<Nodo> lista = new ArrayList<>();

        // Simulamos agregar un dato usando la clase local
        lista.add(new Nodo(ids[0], 5));

        // Imprime el id del primer nodo insertado
        System.out.println(lista.get(0).id);
    }

    public static void main(String[] args) {
        procesarFrecuencias(new int[]{10, 20, 30});
    }
}