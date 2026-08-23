package Cracking_the_Coding;

import java.util.ArrayList;
import java.util.Scanner;

public class WeirdAlgorithm {
    static ArrayList<Long> arregloFinal = new ArrayList<>();
    public static Long weirdAlgorithm(long n){
        arregloFinal.add(n);
        if (n==1){
            return 1L;
        }else{
            if(n%2 == 0){
                return weirdAlgorithm(n/2);
            }else{
                return weirdAlgorithm((n*3)+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()){
            long n = sc.nextLong();
            weirdAlgorithm(n);
        }
        for(long e : arregloFinal){
            System.out.print(e + " ");
        }
        sc.close();
    }
}
