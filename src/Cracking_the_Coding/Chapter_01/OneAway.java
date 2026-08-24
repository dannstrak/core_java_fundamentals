package Cracking_the_Coding.Chapter_01;

public class OneAway {
    public static boolean oneaway(String palabra, String posibleModificacion){
        if (Math.abs(palabra.length() - posibleModificacion.length()) >1){
            return false;
        }
        int contadorVariaciones = 0;
        int contadorVariacionesDiferentes = 0;
        if (palabra.length() == posibleModificacion.length()){
            int j = 0;
            for (int i = 0; i<palabra.length(); i++){
                j = i;
                if (palabra.charAt(i) == posibleModificacion.charAt(j)){
                    j++;
                }else{
                    j++;
                    contadorVariaciones ++;
                }
            }
        }else{
            String larga = palabra.length() > posibleModificacion.length() ? palabra : posibleModificacion;
            String corta = palabra.length() < posibleModificacion.length() ? palabra : posibleModificacion;
            int s = 0;
            int l = 0;
            while (s < corta.length() && l < larga.length()){
                if (larga.charAt(l) == corta.charAt(s)){
                    l++;
                    s++;
                }else{
                    l++;
                    contadorVariacionesDiferentes++;
                }
            }
        }
        if (contadorVariaciones>1 || contadorVariacionesDiferentes>1)
            return false;
        else
            return true;
    }
    static void main(String[] args) {
        boolean resultado = oneaway("pale", "peal");
        System.out.println(resultado);
    }
}
