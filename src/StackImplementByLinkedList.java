class node{
    int data;
    int identificador;
    node next;
    public node(int data, int identificador){
        this.data = data;
        this.identificador = identificador;
    }
    public void displayLink(){
        System.out.print("{" + identificador + ", " + data + "} ");
    }
}
class LinkedL {
    private node First;
    public LinkedL(){
        First = null;
    }
    public boolean isEmpty(){
        return First == null;
    }
    public void insertFirst(int identificador, int data){
        node newNode = new node(identificador, data);
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
        node current = First;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
    }
}

class StackImp {
    private LinkedL Stack;
    public StackImp(){
        Stack = new LinkedL();
    }
    public void push(int identificador, int data){
        Stack.insertFirst(identificador,data);
    }
    public void pop (){
        Stack.deleteFirst();
    }
    public void Peek(){
        Stack.displayList();
    }
    public boolean isEmpty(){
       return Stack.isEmpty();
    }
}

public class StackImplementByLinkedList {


}
