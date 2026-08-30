class Link{
    int data;
    int identificador;
    Link next;
    public Link(int data, int identificador){
        this.data = data;
        this.identificador = identificador;
    }
    public void displayLink(){
        System.out.print("{" + identificador + ", " + data + "} ");
    }
}
class LinkedListB {
    private Link first;

    public LinkedListB(){
        first = null;
    }
    public boolean isEmpty (){
        return first == null;
    }
    // InsertFirst.
    public void insertFirst (int identificador, int dato){
        Link newLink = new Link(dato, identificador);
        newLink.next = first;
        first = newLink;
    }
    // DeleteFirst.
    public void deleteFirst (int identificador){
        first = first.next;
    }
    // DisplayChainofLinks.
    public void displayLinkedList (){
        Link current = first;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
    }
}

public class LinkedListA{
    static void main(String[] args) {
        LinkedListB linkedList = new LinkedListB();
        linkedList.insertFirst(1, 10);
        linkedList.insertFirst(2, 14);
        linkedList.insertFirst(3, 20);
        linkedList.displayLinkedList();
    }
}

