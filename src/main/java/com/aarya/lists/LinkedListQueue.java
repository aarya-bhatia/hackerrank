package com.aarya.lists;

import java.util.Scanner;

public class LinkedListQueue {

    private static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }

        Node getNext() { return this.next; }
        void setNext(Node node) { this.next = node; }
        int getData() { return this.data; }
    }

    Node head;
    Node tail;
    int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
    }

    private boolean isEmpty(){
        return this.size == 0;
    }

    private Node createNode(int data) {
        return new LinkedListQueue.Node(data);
    }

    public void show(){
        if(this.isEmpty()) return;
        Node current = this.head;
        while(current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }

    public void enqueue(int data) {
        Node node = this.createNode(data);
        if(this.isEmpty()){
            this.head = node;
            this.tail = this.head;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
        this.size++;
    }

    public int dequeue() {
        if(this.isEmpty()) return -999;
        Node del = this.head;
        this.head = this.head.next;
        this.size--;
        return del.data;
    }

    public int peek(){
        if(this.isEmpty()) return -999;
        return this.head.data;
    }

    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of queries");
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            System.out.println("Enter your query");
            int query = sc.nextInt();
            if(query == 1) {
                System.out.println("Enter value to insert");
                int val = sc.nextInt();
                q.enqueue(val);
            }
            else if(query == 2) {
                int x = q.dequeue();
                if(x == -999) {
                    System.out.println("queue is empty");
                } else {
                    System.out.println("dequeued " + x);
                }
            } else {
                int top = q.peek();
                System.out.println("Output: " + top);
            }

            System.out.println("Current queue");
            q.show();
            System.out.println("--------------");
        }
        sc.close();
    }
}
