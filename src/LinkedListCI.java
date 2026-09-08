public class LinkedListCI {
    int data;
    LinkedListCI next;
    public LinkedListCI(int data){
        this.data = data;
    }
    public void appendToTail(int data){
        LinkedListCI newNode = new LinkedListCI(data);
        LinkedListCI current = this;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
}
