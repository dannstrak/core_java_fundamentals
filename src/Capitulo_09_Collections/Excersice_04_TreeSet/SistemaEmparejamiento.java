package Capitulo_09_Collections.Excersice_04_TreeSet;

import java.util.NavigableSet;
import java.util.TreeSet;

public class SistemaEmparejamiento {
    static void main(String[] args) {
        NavigableSet<Integer> trofeos = new TreeSet<>();
        trofeos.add(1500);
        trofeos.add(800);
        trofeos.add(2100);
        trofeos.add(500);
        trofeos.add(1200);
        trofeos.add(1500);

        System.out.println(trofeos);

        int novato = trofeos.first();
        int pro = trofeos.last();

        System.out.println("Novato es: "+ novato);
        System.out.println("Pro es: "+pro);

        var rivalInferior = trofeos.lower(1250);
        var rivalSuperior = trofeos.higher(1250);

        var rivalIgualOSuperior = trofeos.ceiling(800);
        System.out.println(rivalIgualOSuperior);

        var ligaMedia = trofeos.subSet(800, true, 2000, true);
        System.out.println(ligaMedia);

    }
}
