package com.aarya.lists;

public class DoublyLinkedListNode<T extends Comparable<T>> implements Comparable<DoublyLinkedListNode<T>> {
    private T data;
    private DoublyLinkedListNode<T> next;
    private DoublyLinkedListNode<T> prev;

    public DoublyLinkedListNode(T v) {
        data = v;
        next = null;
        prev = null;
    }

    public boolean hasNext() {
        return this.getNext() != null;
    }

    public boolean hasPrev() {
        return this.getPrev() != null;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public DoublyLinkedListNode<T> getNext() {
        return this.hasNext() ? this.getNext() : null;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return this.hasPrev() ? this.getPrev() : null;
    }

    public T getData() {
        return this.hasData() ? this.getData() : null;
    }

    private boolean hasData() {
        return this.getData() != null;
    }

    @Override
    public int compareTo(DoublyLinkedListNode<T> otherNode) {
        return this.getData().compareTo(otherNode.getData());
    }

    public static <E extends Comparable<E>> DoublyLinkedListNode<E> reverseDoublyLinkedList(DoublyLinkedListNode<E> head) {
        DoublyLinkedListNode<E> current = head;
        if (head == null) { return null; }
        while (current != null) {
            head = current;
            System.out.println("current data = " + current.getData());
            DoublyLinkedListNode<E> oldNext = current.getNext();
            DoublyLinkedListNode<E> oldPrev = current.getPrev();
            current.setPrev(oldNext); // new prev
            current.setNext(oldPrev); // new next
            current = oldNext;
        }
        return head;
    }
}
