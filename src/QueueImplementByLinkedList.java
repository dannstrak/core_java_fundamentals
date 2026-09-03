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
    public void mirar(){
        Link current = First;
        while (current != null){
            current.displayLink();
            current = current.next;
        }
        System.out.println(" ");
    }
}

class QueueFinal {
    private Queue queue;
    public QueueFinal(){
        queue = new Queue();
    }
    public void insertQueue(int identificador, int data){
        queue.InsertLast(identificador, data);
    }
    public void deleteQueue(){
        queue.DeleteFirst();
    }
    public void isEmpty(){
        queue.isEmpty();
    }
    public void displayQueue (){
        queue.mirar();
    }
}
public class QueueImplementByLinkedList {
    static void main(String[] args) {
        QueueFinal queue = new QueueFinal();
        queue.insertQueue(1, 10);
        queue.insertQueue(2, 12);
        queue.insertQueue(3, 19);
        queue.displayQueue();
    }
}
