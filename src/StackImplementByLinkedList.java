class LinkedL {
    private Node First;
    public LinkedL(){
        First = null;
    }
    public boolean isEmpty(){
        return First == null;
    }
    public void insertFirst(int data, int identificador){
        Node newNode = new Node(data, identificador);
        if (isEmpty()){
            First = newNode;
        }else{
            newNode.next = First;
            First = newNode;
        }
    }
    public void deleteFirst (){
        if (!isEmpty()){
            First = First.next;
        }
    }

    public void displayList(){
        Node current = First;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
    }
}

class StackImp {
    private LinkedL Stack1;
    public StackImp(){
        Stack1 = new LinkedL();
    }
    public void push(int data, int identificador){
        Stack1.insertFirst(data, identificador);
    }
    public void pop (){
        Stack1.deleteFirst();
    }
    public void Peek(){
        Stack1.displayList();
    }
    public boolean isEmpty(){
       return Stack1.isEmpty();
    }
}
public class StackImplementByLinkedList {
    public static void main(String[] args) {
        StackImp Stack = new StackImp();
        Stack.push(1, 10);
        Stack.push(2, 10);
        Stack.push(3, 12);
        Stack.Peek();
        Stack.pop();
        Stack.pop();
        Stack.Peek();
    }
}
