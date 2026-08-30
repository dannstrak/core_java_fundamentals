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

    public LinkedListB() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    // InsertFirst.
    public void insertFirst(int identificador, int dato) {
        Link newLink = new Link(dato, identificador);
        newLink.next = first;
        first = newLink;
    }

    // DeleteFirst.
    public void deleteFirst(int identificador) {
        first = first.next;
    }

    // DisplayChainofLinks.
    public void displayLinkedList() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
    }


    // Find and Deleting Specific links
    public Link findLink(int identificador) {
        Link current = first;
        while (current.identificador != identificador) {
            if (current.next == null) {
                return null;
            }else{
                current = current.next;
            }
        }
        return current;
    }

    // Delete an Specificic link
    public Link deleteSpecificLink (int identificador){
        Link current = first;
        Link previous = first;
        while(current.identificador != identificador){
            if (current.next == null){
                return  null;
            }else{
                previous = current;
                current = current.next;
            }
        }
        if (current == first){
            first = current.next;
        }else{
            previous.next = current.next;
        }
        return current;
    }

    public boolean deleteSpecificLink2 (int identificador){
        Link current = first;
        while(current.next.identificador != identificador){
            if (current.next == null){
                return  false;
            }else{
                current = current.next;
            }
        }
        if (current == first){
            first = current.next;
        }else{
            current.next = current.next.next;
        }
        return true;
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

