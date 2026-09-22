package Cracking_the_Coding.Chapter_03;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

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


    private boolean isEmpty(){
        return first == null;
    }
    public void add(T item){
        QueueNode<T> t = new QueueNode<>(item);
        if (isEmpty()){
            first = t;
        }else{
            last.next = t;
        }
        last = t;
    }
    public void remove (){
        QueueNode<T> current = first;
        if (current.next == null){
            last = null;
        }
        first = first.next;
    }

    public T peek (){
        return first.data;
    }


}
