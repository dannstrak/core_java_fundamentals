package Cracking_the_Coding.Chapter_01;

public class PalindromePermutation {
    public static boolean palindromePermutation (String cadena){
        String lowerCase = cadena.replace(" ","").toLowerCase();
        int arregloFinal[] = new int[128];
        for(int i = 0; i<lowerCase.length(); i++){
            int j = lowerCase.charAt(i);
            arregloFinal[j]++;
        }
        int contadorImpares = 0;
        for (int k = 0; k<arregloFinal.length; k++){
            if (arregloFinal[k]%2 !=0 ){
                contadorImpares++;
            }
        }
        if (contadorImpares > 1){
            return false;
        }else
            return true;
    }

    static void main(String[] args) {
        boolean resultado = palindromePermutation("Tact Coa");
        System.out.println(resultado);
    }
}
