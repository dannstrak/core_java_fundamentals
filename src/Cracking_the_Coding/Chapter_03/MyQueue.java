package Cracking_the_Coding.Chapter_03;

public class MyQueue <T>{
    public static class QueueNode<T>{
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }
    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item){
        QueueNode<T> t = new QueueNode<>(item);
        if (last != null){
            last.next = t;
        }
        last = t;

    }
}
