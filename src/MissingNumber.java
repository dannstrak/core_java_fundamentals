import java.util.ArrayList;
import java.util.Scanner;

public class MissingNumber {
    static ArrayList<Integer> arrayFinal = new ArrayList<>();
    public static Integer numeroFaltante (int n){
        if (n <= 2){
            arrayFinal.add(n-1);
            return 1;
        }else{
            int value = n - 1;
            arrayFinal.add(value);
            return numeroFaltante(value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLong()){
            int n = sc.nextInt();
            numeroFaltante(n);
        }
        for(int e : arrayFinal){
            System.out.print(e + " ");
        }
    }
}
