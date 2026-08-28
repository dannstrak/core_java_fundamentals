public class LinkedListCTCI {
    int data;
    LinkedListCTCI next  = null;

    public LinkedListCTCI(int data){
        this.data = data;
    }

    void appendToTail(int data){
        LinkedListCTCI end = new LinkedListCTCI(data);
        LinkedListCTCI current = this;
        while (current.next != null){
            current = current.next;
        }
        current.next = end;
    }

    LinkedListCTCI appendToHead (int data){
        LinkedListCTCI newLink = new LinkedListCTCI(data);
        newLink.next = this;
        return  newLink;
    }
}
