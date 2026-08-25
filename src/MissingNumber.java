import java.util.HashSet;
import java.util.Scanner;

public class MissingNumber {
    public static int misingNumber (int limiteMaximo, int[] enteros){
        int valueFinal = (limiteMaximo*(limiteMaximo+1))/2;
        int contador = 0;
        if (limiteMaximo == 1){
            return 1;
        }else{
            for(int i = 0; i<enteros.length; i++){
                contador += enteros[i];
            }
        }
        return valueFinal-contador;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int limite = sc.nextInt();
        int arreglo[] = new int[limite-1];
        if (sc.hasNextInt()){
            for (int i = 0; i<arreglo.length; i++){
                arreglo[i] = sc.nextInt();
            }
        }
        int valorFinal = misingNumber(limite, arreglo);
        System.out.println(valorFinal);
    }
}
