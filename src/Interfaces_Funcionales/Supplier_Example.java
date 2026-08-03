package Interfaces_Funcionales;

import java.util.function.Supplier;
import java.util.List;
import java.util.ArrayList;

public class Supplier_Example {
    static void main(String[] args) {
        Supplier<torneoAlgoritmico.Participante> fabricaBots = ()-> {
                int puntosRandom = (int)(Math.random()*100);
                return new torneoAlgoritmico.Participante("Bot_Entrenamiento", puntosRandom, false);
        };
        IO.println("Solicitando Bots al sistema");
        torneoAlgoritmico.Participante Bot1 = fabricaBots.get();
        torneoAlgoritmico.Participante Bot2 = fabricaBots.get();
        List<torneoAlgoritmico.Participante> bots = new ArrayList<>();
        // Insertamos los bots a la ArrayList.
        bots.add(Bot1);
        bots.add(Bot2);
        // Imprimir.
        for(torneoAlgoritmico.Participante p: bots){
            int i = 0;
            System.out.println(p);
            i += 1;
        }
    }
}
