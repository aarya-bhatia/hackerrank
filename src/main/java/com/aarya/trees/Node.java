package com.aarya.trees;

public class Node {

    private Node right;
    private Node left;
    private int data;

    public Node(int val) {
        this.data = val;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean hasLeft() {
        return this.getLeft() != null;
    }

    public boolean hasRight() {
        return this.getRight() != null;
    }

}