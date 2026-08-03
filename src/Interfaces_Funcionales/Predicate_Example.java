package Interfaces_Funcionales;

import java.util.ArrayList;
import java.util.List;

public class Predicate_Example {
    public static void main(String[] args) {
        List<torneoAlgoritmico.Participante> competidores = new ArrayList<>();
        competidores.add(new torneoAlgoritmico.Participante("Carlos", 150, true));
        competidores.add(new torneoAlgoritmico.Participante("Alejandro", 300, true));
        competidores.add(new torneoAlgoritmico.Participante("Jacob", 500, false));
        // Utilizamos Interfaces_Funcionales.Predicate
        java.util.function.Predicate<torneoAlgoritmico.Participante> resolucionFinal = participante -> participante.isResolvioProblemaAvanzado() == true;
        java.util.function.Predicate<torneoAlgoritmico.Participante> puntajeAceptable = (participante -> participante.getPuntaje() > 150);
        // 1. Utilizando method default and.
        java.util.function.Predicate<torneoAlgoritmico.Participante> reglaAnd = resolucionFinal.and(puntajeAceptable);
        // 2. Utilizando method default or.
        java.util.function.Predicate<torneoAlgoritmico.Participante> reglaOr = resolucionFinal.or(puntajeAceptable);
        // 3. Utilizando method default negate.
        java.util.function.Predicate<torneoAlgoritmico.Participante> negatePredicate = resolucionFinal.negate();
        // 4. Utilizando el metodo statico de isEqual.
        java.util.function.Predicate<torneoAlgoritmico.Participante> esAlejandro = java.util.function.Predicate.isEqual("Alejandro");
        // Impresión:
        for(torneoAlgoritmico.Participante p: competidores){
            if(reglaAnd.test(p)){
                System.out.println("Participante aceptado: "+p);
            }
        }
    }
}
