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
    node First;
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

    }
}

public class StackImplementByLinkedList {
}
