package com.aarya.trees;

import java.util.*;

public class LeastCommonAncestor {

    public static boolean match(Node n, int v1, int v2) {
        return n.data == v1 || n.data == v2;
    }

    // find the first parent of either v1 or v2 using a queue
    public static Node lca(Node root, int v1, int v2) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        if (match(root, v1, v2))
            return root;

        while (!q.isEmpty()) {
            Node current = q.remove();

            if (current.left != null) {
                if (match(current.left, v1, v2)) {
                    return current;
                } else {
                    q.add(current.left);
                }
            }

            if (current.right != null) {
                if (match(current.right, v1, v2)) {
                    return current;
                } else {
                    q.add(current.right);
                }
            }
        }

        return root;
    }

    public static Node lca(Node root, Node n1, Node n2) {
        if (root == null)
            return root;
        if (root.equals(n1) || root.equals(n2))
            return root;
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left != null && right != null)
            return root;
        if (left == null && right == null)
            return null;
        if (left != null)
            return lca(root.left, n1, n2);
        else
            return lca(root.right, n1, n2);
    }

    public static int findLevel(Node current, Node target, int level) {
        if (current == null)
            return -1;
        if (current.equals(target))
            return level;
        int left = findLevel(current.left, target, level + 1);
        if (left != -1)
            return findLevel(current.right, target, level + 1);
        return left;
    }

    public static void main(String args[]) {
        Tree t = new Tree();
        int[] vals = { 1, 3, 5, 4, 2, 7, 11 };
        for (int i = 0; i < vals.length; i++) {
            t.add(vals[i]);
        }
        t.print();
        System.out.println("Level order");
        t.printLevelOrder();
    }
}