import java.util.ArrayList;

public class weird_algorithm {
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

    static void main(String[] args) {
        weirdAlgorithm(3);
        for(long e : arregloFinal){
            System.out.print(e + " ");
        }
    }
}
