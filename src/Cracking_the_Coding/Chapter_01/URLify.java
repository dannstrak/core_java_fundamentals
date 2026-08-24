package Cracking_the_Coding.Chapter_01;

public class URLify {
    public static void urlify (char[] cadena, int tamanioReal){
        char[] cadenaFinal = new char[cadena.length];
        int punteroFinal = tamanioReal -1 ;
        int punteroArray = cadena.length -1 ;
        for (int i = punteroFinal; i>= 0; i--){
            if(cadena[i] == ' '){
                cadena[punteroArray--] = '0';
                cadena[punteroArray--] = '2';
                cadena[punteroArray--] = '%';

            }else{
                cadena[punteroArray--] = cadena[i];
            }
        }
        for(char e : cadena){
            System.out.print(e);
        }
    }

    static void main() {
        char[] cadena = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
        urlify(cadena, 13);
    }
}
