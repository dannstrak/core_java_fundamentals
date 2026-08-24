package Cracking_the_Coding.Chapter_01;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class CheckPermutation {
    public static boolean checkPermutation (String cadenaOriginal, String posiblePermutacion){
        cadenaOriginal.trim();
        posiblePermutacion.trim();
        int[] arregloFinal = new int[128];
        if (cadenaOriginal.length() != posiblePermutacion.length())
            return false;
        for (int i = 0; i < cadenaOriginal.length(); i++){
            int value = cadenaOriginal.charAt(i);
            arregloFinal[value] ++;
        }
        for (int i = 0; i < posiblePermutacion.length(); i++){
            int value = posiblePermutacion.charAt(i);
            arregloFinal[value] --;
            if (arregloFinal[value] < 0) {
                return false;
            }
        }
        return  true;
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        String posiblePermutacion = sc.nextLine();
        boolean resultado = checkPermutation(cadena, posiblePermutacion);
        System.out.println("El resultado es el siguiente: "+resultado);
    }
}
