class Queue{
    private Link First;
    private Link Last;
    public Queue (){
        First = null;
        Last = null;
    }
    public boolean isEmpty(){
        return First == null;
    }
    public void InsertLast (int identificador, int data){
        Link newLink = new Link(identificador, data);
        if(isEmpty()){
            First = null;
        }else{
            Last.next = newLink;
        }
        Last = newLink;
    }
    public void DeleteFirst(){
        if (First.next == null){
            Last = null;
        }
        First = First.next;
    }
}
public class QueueImplementByLinkedList {
    static void main(String[] args) {

    }
}
