package com.aarya.trees;

//import java.util.LinkedList;
//import java.util.Queue;

public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

//    public void add(int val) {
//        Node next = new Node(val);
//        this.add(this.root, next);
//    }
//
//    public void add(Node current, Node newNode) {
//        if (current == null) {
//            current = newNode;
//        } else {
//            if (newNode.getData() > current.getData()) {
//                add(current.getRight(), newNode);
//            } else {
//                add(current.getLeft(), newNode);
//            }
//        }
//    }
//
//    public void printLevelOrder() {
//        Queue<Node> q = new LinkedList<>();
//        Node current = this.root;
//        int level = 0;
//        q.add(current);
//        while (current != null) {
//            System.out.println(current.getData());
//            if (current.hasLeft()) {
//                q.add(current.getLeft());
//            }
//            if (current.hasRight()) {
//                q.add(current.getRight());
//            }
//            current = q.remove();
//            level++;
//            System.out.println("Level: " + level);
//        }
//    }
//
//    public void print() {
//        print(root);
//    }
//
//    public void print(Node current) {
//        if (current == null)
//            return;
//        System.out.println(current.getData());
//        print(current.getLeft());
//        print(current.getRight());
//    }
}