import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MissingNumber {
    public static long misingNumber (int limiteMaximo, int[] enteros){
        long valueFinal = (long) limiteMaximo * (limiteMaximo + 1) / 2;
        long  contador = 0;
        if (limiteMaximo == 1){
            return 1;
        }else{
            for(int i = 0; i<enteros.length; i++){
                contador += enteros[i];
            }
        }
        return valueFinal-contador;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int limite = Integer.parseInt(br.readLine());
        int  arreglo[] = new int[limite-1];
        String lineaNumeros = br.readLine();
        if (lineaNumeros != null){
            StringTokenizer st = new StringTokenizer(lineaNumeros);
            for (int i = 0; i<arreglo.length; i++){
            }
        }
        long valorFinal = misingNumber(limite, arreglo);
        System.out.println(valorFinal);
    }
}
