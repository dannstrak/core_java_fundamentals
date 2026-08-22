import java.util.ArrayList;

public class weird_algorithm {
    static ArrayList<Long> arregloFinal = new ArrayList<>();
    public static Long weirdAlgorithm(long n){
        if (n==1){
            arregloFinal.add(1L);
            return 1L;
        }else{
            if(n%2 == 0){
                Long valor = (long) (n/2);
                arregloFinal.add(valor);
                return weirdAlgorithm(valor);
            }else{
                Integer valor = Math.toIntExact((n * 3) + 1);
                arregloFinal.add(valor);
                return weirdAlgorithm(valor);
            }
        }
        for(Integer valor : arregloFinal){
            System.out.println(valor);
        }
    }
}
