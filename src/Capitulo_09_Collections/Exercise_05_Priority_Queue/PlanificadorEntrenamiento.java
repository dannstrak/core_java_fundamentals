package Capitulo_09_Collections.Exercise_05_Priority_Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PlanificadorEntrenamiento {
    static void main(String[] args) {
        Queue<Integer> tiemposMinutos = new PriorityQueue<>();

        tiemposMinutos.offer(45);
        tiemposMinutos.offer(15);
        tiemposMinutos.offer(60);
        tiemposMinutos.offer(10);

        while(!tiemposMinutos.isEmpty()){
            var elemento = tiemposMinutos.poll();
            System.out.println(elemento);
        }
    }
}
