package Interfaces_Funcionales;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class Function_Example {
    static void main(String[] args) {
        List<torneoAlgoritmico.Participante> escuadron = new ArrayList<>();
        escuadron.add(new torneoAlgoritmico.Participante("Carlos", 150, true));
        escuadron.add(new torneoAlgoritmico.Participante("Alejandro", 400, true));
        // Entra Participante, Sale String.
        Function<torneoAlgoritmico.Participante,String> extraerNombre = participante -> participante.getNombre();
        // Entra String y sale String.
        Function<String, String> formatoOficial = nombre -> "Reclutar: "+ nombre.toUpperCase();
        // Utilizamos el andThen.
        Function<torneoAlgoritmico.Participante, String> formatoFinal = extraerNombre.andThen(formatoOficial);
        // Imprimimos la informacion.
        for(torneoAlgoritmico.Participante p: escuadron){
            System.out.println(formatoFinal.apply(p));
        }
    }
}
