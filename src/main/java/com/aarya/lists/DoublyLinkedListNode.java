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
        return this.getNext();
    }

    public DoublyLinkedListNode<T> getPrev() {
        return this.getPrev();
    }

    public T getData() {
        return this.getData();
    }

    @Override
    public int compareTo(DoublyLinkedListNode<T> otherNode) {
        return this.getData().compareTo(otherNode.getData());
    }
}
