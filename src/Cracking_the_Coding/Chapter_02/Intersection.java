package Cracking_the_Coding.Chapter_02;

public class Intersection {
    static LinkedListCI intersecction (LinkedListCI head1, LinkedListCI head2) {
        if(head1==null || head2 ==null){
            return null;
        }
        int contador1 = 1;
        int contador2 = 1;
        LinkedListCI tail1 = head1;
        LinkedListCI tail2 = head2;
        while (tail1.next != null){
            tail1 = tail1.next;
            contador1++;
        }
        while (tail2.next != null){
            tail2 = tail2.next;
            contador2 ++;
        }
        if (tail1 != tail2){
            return null;
        }
        LinkedListCI masLarga = contador1 > contador2 ? head1 : head2;
        LinkedListCI masCorta = contador1 > contador2 ? head1 : head2;

        int diferenciaFinal = Math.abs(contador1 - contador2);
        while (diferenciaFinal != 0){
            masLarga = masLarga.next;
            diferenciaFinal--;
        }
        while (masLarga != masCorta){
            masLarga = masLarga.next;
            masCorta = masCorta.next;
        }
        return  masLarga;
    }
}
