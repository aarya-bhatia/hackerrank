package com.aarya.trees;

public class BSTNode<E extends Comparable<E>> implements Comparable<BSTNode<E>> {
    private E data;
    private BSTNode<E> left;
    private BSTNode<E> right;

    public BSTNode(E val) {
        data = val;
        left = null;
        right = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public BSTNode<E> getLeft() {
        return left;
    }

    public void setLeft(BSTNode<E> left) {
        this.left = left;
    }

    public BSTNode<E> getRight() {
        return right;
    }

    public void setRight(BSTNode<E> right) {
        this.right = right;
    }

    public boolean hasLeft() { return this.left != null; }

    public boolean hasRight() { return this.right != null; }

    @Override
    public int compareTo(BSTNode<E> o) {
        return data.compareTo(o.data);
    }

    @Override
    public String toString() {
        return String.format("[BSTNode: %s]", data.toString());
    }
}