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
public class LinkedListA {
    private Link first;

    public LinkedListA(){
        first = null;
    }
    public boolean isEmpty (){
        return first == null;
    }
    // InsertFirst.
    public void insertFirst (int identificador, int dato){
        Link newLink = new Link(dato, identificador);
        newLink.next = first;
        first.next = newLink;
    }
    // DeleteFirst.
    public void deleteFirst (int identificador){
        Link removeLink = first;
        first.next = removeLink.next;
    }
    // DisplayChainofLinks.
    public void displayLinkedList (){
        Link current = first;
        while (!isEmpty()){
            current.displayLink();
            current = current.next;
        }
    }

}
