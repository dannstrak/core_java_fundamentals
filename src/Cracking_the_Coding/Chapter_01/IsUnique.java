package Cracking_the_Coding.Chapter_01;

public class IsUnique {
    public static boolean isUnique (String  cadena){
        cadena.trim().strip().toLowerCase();
        int i= 0;
        for (i = 0; i<cadena.length(); i++) {
            for (int j = i+1; j<cadena.length();j++){
                if (cadena.charAt(i) == cadena.charAt(j)){
                    return false;
                }
            }
        }
        return true;
    }

    static void main(String[] args) {
        boolean siONo = isUnique("Ecuakonge");
        System.out.println(siONo);
    }
}