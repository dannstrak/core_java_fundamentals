package Cracking_the_Coding.Chapter_01;

public class StringRotation {
    public static boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }
    public static boolean StringRotation (String cadenaNormal, String posibleRotation){
        if (cadenaNormal == null || posibleRotation == null){
            return false;
        }if (cadenaNormal.length() != posibleRotation.length()){
            return false;
        }else{
            String nuevaRotacion = posibleRotation + posibleRotation;
            if (!isSubstring(nuevaRotacion, cadenaNormal))
                return false;
        }
        return true;
    }

    public static void main() {
        boolean resultado = StringRotation("waterbottle", "erbottlewat");
        System.out.println(resultado);
    }
}
