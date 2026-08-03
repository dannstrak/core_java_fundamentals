package Interfaces_Funcionales;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.function.Predicate;

public class Consumer_Example {
    static void main(String[] args) {
        List<torneoAlgoritmico.Participante> competidores = new ArrayList<>();
        competidores.add(new torneoAlgoritmico.Participante("Carlos", 500, true));
        competidores.add(new torneoAlgoritmico.Participante("Alejandro", 100, true));
        competidores.add(new torneoAlgoritmico.Participante("Jacob", 500, false));

        // Notificar Participante.
        /*
        Utilizamos la Interfaz Funcional consumer para este fin de notificación.
         */
        Consumer<torneoAlgoritmico.Participante> notificacion = participante -> System.out.println("Participante Aceptado: "+participante+" Felicidades");
        Consumer<torneoAlgoritmico.Participante> notificacionAceptacion = participante -> IO.println("Contactesé con cordinación para aceptar sus beneficios.");
        // Utilizamos el metodo default de Consumer
        Consumer<torneoAlgoritmico.Participante> notificacionFinal = notificacion.andThen(notificacionAceptacion);
        // Para mejorar lo lógica utilicemos con Predicate tambien.
        Predicate<torneoAlgoritmico.Participante> esAceptado = participante -> participante.getPuntaje() >150;
        // Finalmente se obtendría lo siguiente.
        for (torneoAlgoritmico.Participante p: competidores){
            if (esAceptado.test(p)){
                notificacionFinal.accept(p);
            }
        }
    }
}
