package Capitulo_09_Collections.Exercise_03_HashSet;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AnalisisLogsServidor {
    static void main(String[] args) {
        HashSet<String> usuarioDia1 = new HashSet<>();
        HashSet<String> usuarioDia2 = new HashSet<>();

        usuarioDia1.add("ID-100");
        usuarioDia1.add("ID-200");
        usuarioDia1.add("ID-300");
        usuarioDia1.add("ID-100");
        usuarioDia1.add("ID-400");

        usuarioDia2.add("ID-300");
        usuarioDia2.add("ID-400");
        usuarioDia2.add("ID-500");
        usuarioDia2.add("ID-600");

        for(String elemento : usuarioDia1){
            System.out.print(elemento + " ");
        }
        System.out.println();
        for(String elemento : usuarioDia2){
            System.out.print(elemento + " ");
        }

        // Uso de contains method.
        var esSospechosoD1 = usuarioDia1.contains("ID-500");
        System.out.println("¿El usuario ID-500 entró el Día 1? " + esSospechosoD1);

        Set<String> usuariosTotales = new HashSet<>(usuarioDia1);
        usuariosTotales.addAll(usuarioDia2);
        System.out.println("Unión (Todos los únicos): " + usuariosTotales);

        Set<String> usuariosFieles = new HashSet<>(usuarioDia1);
        usuariosFieles.retainAll(usuarioDia2);
        System.out.println("Intersección (Entraron ambos días): " + usuariosFieles);

        Set<String> usuariosFugados = new HashSet<>(usuarioDia1);
        usuariosFugados.removeAll(usuarioDia2);
        System.out.println("Diferencia (Entraron Día 1, pero no Día 2): " + usuariosFugados);



    }
}
