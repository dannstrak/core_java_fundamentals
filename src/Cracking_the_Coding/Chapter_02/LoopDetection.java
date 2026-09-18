package Cracking_the_Coding.Chapter_02;

public class LoopDetection {
    static LinkedListCI loopDetection (LinkedListCI head){
        LinkedListCI punteroRapido = head;
        LinkedListCI punteroLento = head;
        while(punteroRapido != null && punteroRapido.next != null){
            punteroRapido = punteroRapido.next.next;
            punteroLento = punteroLento.next;

            if (punteroLento == punteroRapido){
                break;
            }
        }
        if (punteroRapido == null){
            return null;
        }
        punteroLento = head;
        while(punteroLento != punteroRapido){
            punteroLento = punteroLento.next;
            punteroRapido = punteroRapido.next;
        }
        return punteroRapido;
    }
}
