package Cracking_the_Coding.Chapter_02;

public class PalindromeLinked {
    static boolean palindrome(LinkedListCI head){
        LinkedListCI punteroLento = head;
        LinkedListCI punteroRapido = head;
        // 1.
        while(punteroRapido != null && punteroRapido.next != null){
            punteroLento = punteroLento.next;
            punteroRapido = punteroRapido.next.next;
        }
        // 2.
        LinkedListCI previous = null;
        LinkedListCI actual = punteroLento;
        LinkedListCI siguiente = null;

        while(actual != null){
            siguiente = actual.next;
            actual.next = previous;
            previous = actual;
            actual = siguiente;
        }
    }
}
