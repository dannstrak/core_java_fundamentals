package Capitulo_09_Collections.Exercise_04_ArrayDeque;

import java.util.ArrayDeque;

public class ColaProcesamiento {
    static void main(String[] args) {
        ArrayDeque<String> tareas = new ArrayDeque<>();
        tareas.offerLast("Procesar_Lote_A");
        tareas.offerLast("Procesar_Lote_B");

        tareas.offerFirst("Backup_Urgente");

        while(!tareas.isEmpty()){
            var tarea = tareas.pollFirst();
            System.out.println("Ejecutando: "+tarea);
        }
    }
}
