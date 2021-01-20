package com.aarya.lists;

public class SinglyLinkedList {
    protected SinglyLinkedListNode head;
    protected SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public SinglyLinkedListNode getHead() {
        return head;
    }

    public SinglyLinkedListNode getTail() {
        return tail;
    }

    public void setHead(SinglyLinkedListNode head) {
        this.head = head;
    }

    public void setTail(SinglyLinkedListNode tail) {
        this.tail = tail;
    }

    public void addLast(SinglyLinkedListNode node) {
        if (head == null) {
            head = node;
            tail = head;
            return;
        }
        tail.setNext(node);
        tail = node;
    }


}
