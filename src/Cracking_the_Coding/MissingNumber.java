package Cracking_the_Coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class MissingNumber {

    public static int valorTotal (int maxValue){
        if(maxValue <= 1){
            return 1;
        }else{
            return maxValue + valorTotal(maxValue-1);
        }
    }
    public static int missing(int maxValue, HashSet<Integer> numerosDados){
        int valueMaxSet = maxValue - 1;
        HashSet<Integer> numeros = new HashSet<>(numerosDados);
        int contador = 0;
        for (Integer e : numeros){
            contador += e;
        }
        return valorTotal(maxValue) - contador;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        HashSet<Integer> valores = new HashSet<>(valor -1);
        for (int i = 0; i < valor - 1; i++) {
            valores.add(sc.nextInt());
        }
        int valorFinal = missing(valor, valores);
        System.out.println(valorFinal);
    }
}
