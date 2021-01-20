package com.aarya.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>> implements BSTMap<E> {

    protected BSTNode<E> root;

    public BST() {
        root = null;
    }

    @Override
    public void add(E val) {
        System.out.println("Adding node..." + val.toString());
        BSTNode<E> newBSTNode = new BSTNode<>(val);
        if (root == null) {
            root = newBSTNode;
        } else {
            addUtil(root, newBSTNode);
        }
    }

    public void addUtil(BSTNode<E> current, BSTNode<E> newNode) {
       if(current == null) {
           current = newNode;
       }
       else if(current.compareTo(newNode) > 0) {
           if(!current.hasLeft()) {
               current.setLeft(newNode);
           }
           else {
               addUtil(current.getLeft(), newNode);
           }
       }
       else {
           if(!current.hasRight()) {
               current.setRight(newNode);
           }
           else {
               addUtil(current.getRight(), newNode);
           }
       }
    }

    @Override
    public BSTNode<E> remove(E val) {

        if (root == null){
            return null;
        }

        Queue<BSTNode<E>> queue = new LinkedList<>();
        queue.add(root);

        BSTNode<E> found = null;

        while (!queue.isEmpty()) {
            BSTNode<E> current = queue.remove();

            if (current.hasLeft()) {
                if (current.getLeft().getData().compareTo(val) == 0) {
                    found = current.getLeft();
                    current.setLeft(null);
                    if (found.hasLeft()) {
                        addUtil(root, found.getLeft());
                    }
                    if (found.hasRight()) {
                        addUtil(root, found.getRight());
                    }
                    break;
                } else {
                    queue.add(current.getLeft());
                }
            }

            if (current.hasRight()) {
                if (current.getRight().getData().compareTo(val) == 0) {
                    found = current.getRight();
                    current.setRight(null);
                    if (found.hasLeft()) {
                        addUtil(root, found.getLeft());
                    }
                    if (found.hasRight()) {
                        addUtil(root, found.getRight());
                    }
                    break;
                } else {
                    queue.add(current.getRight());
                }
            }
        }
        return found;
    }

    @Override
    public void update(E val, E nextVal) {
        remove(val);
        add(nextVal);
    }

    @Override
    public void read() {
        Queue<BSTNode<E>> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        System.out.println("Printing BST...");
        while (!queue.isEmpty()) {
            BSTNode<E> next = queue.remove();
            System.out.println(next.toString());
            if (next.getLeft() != null)
                queue.add(next.getLeft());
            if (next.getRight() != null)
                queue.add(next.getRight());
        }
    }

    public static void main(String[] args) {
        BST<Character> tree = new BST<>();
        tree.add('a');
        tree.add('c');
        tree.add('t');
        tree.add('d');
        tree.add('x');
        tree.read();
    }
}
