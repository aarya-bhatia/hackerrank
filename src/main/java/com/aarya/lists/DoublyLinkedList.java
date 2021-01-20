package com.aarya.lists;

class DoublyLinkedList {
    SinglyLinkedListNode head;
    SinglyLinkedListNode tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void addLast(SinglyLinkedListNode node) {
        if (head == null) {
            head = node;
            tail = head;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public SinglyLinkedListNode getHead() {
        return head;
    }
}
