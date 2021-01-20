package com.aarya.lists;

public class SinglyLinkedListNode {
    private int data;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode(int d) {
        data = d;
        next = null;
    }

    public int getData() {
        return data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(SinglyLinkedListNode next) {
        this.next = next;
    }
}
