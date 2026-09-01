class Node{
    int identificador;
    int data;
    Node next;
    public Node(int identificador, int data){
        this.identificador = identificador;
        this.data = data;
    }
    public void displayLink(){
        System.out.print("{" + identificador + ", " + data + "} ");
    }
}

class Double_Ended{
    private Node First;
    private Node Last;
    public Double_Ended(){
        First = null;
        Last = null;
    }
    public boolean isEmpty() {
        return First == null;
    }
    public void insertFirst (int identificador, int data){
        Node newNode = new Node(identificador,data);
        if(First == null){
            Last = newNode;
        }
        newNode.next = First;
        First = newNode;
    }

    public void insertLast (int identificador, int data){
        Node newNode = new Node(identificador, data);
        if(isEmpty()){
            First = newNode;
        }else{
            Last.next = newNode;
        }
        Last = newNode;
    }
}

public class Double_Ended_Linked_List {
}
