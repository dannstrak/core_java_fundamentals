package Capitulo_09_Collections.LinkedHashSet;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class ExtractorPalabras {

    static void main() {
        Set<String> vocabulario = new LinkedHashSet<>();
        vocabulario.add("matriz");
        vocabulario.add("Vector");
        vocabulario.add("tensor");
        vocabulario.add("matriz");
        vocabulario.add("Escala");

        for (String palabra : vocabulario){
            System.out.println(palabra);
        }
    }
}
