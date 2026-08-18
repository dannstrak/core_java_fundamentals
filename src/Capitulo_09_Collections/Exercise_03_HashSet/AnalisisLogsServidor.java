package Capitulo_09_Collections.Exercise_03_HashSet;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;

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

    }
}
