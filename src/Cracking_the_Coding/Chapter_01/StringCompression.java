package Cracking_the_Coding.Chapter_01;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringCompression {
    public static String stringCompression(String cadenaOriginal){
        StringBuilder sb = new StringBuilder();
        int contadorConsecutivo = 0;
        for (int i = 1; i<cadenaOriginal.length(); i++) {
            contadorConsecutivo++;
            if (i +1 == cadenaOriginal.length() || cadenaOriginal.charAt(i) != cadenaOriginal.charAt(i+1)){
                sb.append(cadenaOriginal.charAt(i));
                sb.append(contadorConsecutivo);
                contadorConsecutivo = 0;
            }
        }
        if (sb.toString().length() > cadenaOriginal.length()){
            return  cadenaOriginal;
        }else{
            return sb.toString();
        }
    }

    static void main(String[] args) {
        System.out.println(stringCompression("aabcccccaaa"));
        System.out.println(stringCompression("abc"));
    }
}
