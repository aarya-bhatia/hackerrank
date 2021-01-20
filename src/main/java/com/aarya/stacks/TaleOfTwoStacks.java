package com.aarya.stacks;

import java.util.*;

public class TaleOfTwoStacks {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<>();
        Stack<T> stackOldestOnTop = new Stack<>();

        /*
        * Fix Later- donot empty and refill stack on every add operation
        * only add everyting to new stack for dequeue operation
        */

        public void enqueue(T value) { // Push onto newest stack
            while(!stackOldestOnTop.empty()) {
                stackNewestOnTop.push(stackOldestOnTop.pop());
            }
            stackNewestOnTop.push(value);
            while(!stackNewestOnTop.empty()){
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }

        public T peek() {
            if(stackOldestOnTop.empty()) return null;
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            if(stackOldestOnTop.empty()) return null;
            return stackOldestOnTop.pop();
        }

        public void print(){
            System.out.println("Queue");
            while(!stackOldestOnTop.empty()) {
                System.out.println(stackOldestOnTop.pop());
            }
        }
    }

    public static void main(String args[]) {
        MyQueue<Character> q = new MyQueue<>();
        q.enqueue('a');
        q.enqueue('b');
        q.enqueue('c');
        assert(q.stackOldestOnTop.size() == 3);
        q.print();
        q.dequeue();
        q.enqueue('d');
        q.enqueue('e');
        assert(q.stackOldestOnTop.size() == 5);
        q.dequeue();
        q.print();
        assert(q.stackOldestOnTop.size() == 3);
    }
}