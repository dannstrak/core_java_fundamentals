package Cracking_the_Coding.Chapter_02;

public class PalindromeLinked {
    static boolean palindrome(LinkedListCI head){
        LinkedListCI punteroRapido = head;
        LinkedListCI punteroLento = head;
        while (punteroRapido != null && punteroRapido.next != null){
            punteroRapido = punteroRapido.next.next;
            punteroLento = punteroLento.next;
        }
        // 2. Invertir el inicio de el punteroLento
        LinkedListCI previous = null;
        LinkedListCI current = punteroLento;
        LinkedListCI nextLinked = null;

        while(current != null){
            nextLinked = current.next;
            current.next = previous;
            previous = current;
            current = nextLinked;
        }
        // 3. Comparar.
        LinkedListCI izquierda = head;
        LinkedListCI derecha = previous;
        while(derecha != null){
            if (derecha.data != izquierda.data){
                return false;
            }
        }
        return true;
    }
}