package Cracking_the_Coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class MissingNumber {
    static ArrayList<Integer> arrayFinal = new ArrayList<>();
    static HashSet<Integer> numerosActivos = new HashSet<>();
    public static Integer numeroFaltante (int n){
        if (n <= 2){
            numerosActivos.add(n-1);
            return 1;
        }else{
            int value = n - 1;
            numerosActivos.add(value);
            return numeroFaltante(value);
        }
    }
    public static Integer finalArreglo (HashSet<Integer> finalSet){
        Iterator<Integer> iter = numerosActivos.iterator();
        if(iter.hasNext()){
            int value = iter.next();
            arrayFinal.add(value, value);
        }
        Iterator<Integer> iter2 = arrayFinal.listIterator();
        int valorFinal = 0;
        if(iter2.hasNext()){
            valorFinal = iter.next();
        }
        return valorFinal;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor = 0;
        if (sc.hasNextLong()){
            valor = sc.nextInt();
        }
        if(sc.hasNextLong()){

        }
    }
}
