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
        BSTNode<E> newBSTNode = new BSTNode<E>(val);
        if (root == null) {
            root = newBSTNode;
        } else {
            add(root, newBSTNode);
        }
    }

    public void add(BSTNode<E> current, BSTNode<E> newBSTNode) {
        if (current == null) {
            current = newBSTNode;
            System.out.println("Done.");
            return;
        }

        System.out.println("trying to add...");

        if (newBSTNode.compareTo(current) >= 0) {
            add(current.getRight(), newBSTNode);
        } else {
            add(current.getLeft(), newBSTNode);
        }
    }

    @Override
    public BSTNode<E> remove(E val) {
        if (root == null)
            return root;
        Queue<BSTNode<E>> queue = new LinkedList<>();
        queue.add(root);
        BSTNode<E> found = null;
        while (!queue.isEmpty()) {
            BSTNode<E> current = queue.remove();

            if (current.left != null) {
                if (current.left.data.compareTo(val) == 0) {
                    found = current.left;
                    current.left = null;
                    if (found.left != null) {
                        add(root, found.left);
                    }
                    if (found.right != null) {
                        add(root, found.right);
                    }
                    break;
                } else {
                    queue.add(current.left);
                }
            }

            if (current.right != null) {
                if (current.right.data.compareTo(val) == 0) {
                    found = current.right;
                    current.right = null;
                    if (found.left != null) {
                        add(root, found.left);
                    }
                    if (found.right != null) {
                        add(root, found.right);
                    }
                    break;
                } else {
                    queue.add(current.right);
                }
            }
        }
        return found;
    }

    @Override
    public void update(E val, E nextVal) {
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
            if (next.left != null)
                queue.add(next.left);
            if (next.right != null)
                queue.add(next.right);
        }
    }

    public static void main(String args[]) {
        BST<Character> tree = new BST<Character>();
        tree.add('a');
        tree.add('c');
        tree.add('t');
        tree.add('d');
        tree.add('x');
        tree.read();
    }
}
