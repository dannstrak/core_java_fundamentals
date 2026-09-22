package Cracking_the_Coding.Chapter_03;

import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack <T>{
    private static class StackNode<T>{
        private T data;
        private StackNode<T> next;

        public StackNode (T data){
            this.data = data;
        }
    }
    private StackNode<T> top;

    public T pop(){
        if (top == null){
            return null;
        }
        T item  = top.data;
        top = top.next;
        return item;
    }

    public void push(T data){
        var newNode = new StackNode<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T peek (){
        if (top == null){
            throw new EmptyStackException();
        }
        T onlyData = top.data;
        return onlyData;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
