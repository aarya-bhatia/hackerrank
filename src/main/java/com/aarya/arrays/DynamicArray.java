package com.aarya.arrays;

import java.util.*;

public class DynamicArray {
    int data[];
    int top = -1;
    int size = 10;

    DynamicArray() {
        data = new int[size];
    }

    DynamicArray(int n) {
        size = n;
        data = new int[n];
    }

    public int getSize() {
        return top + 1;
    }

    private void resize(int m) {
        data = Arrays.copyOf(data, m);
    }

    public void add(int val) {
        if (top == size - 1) {
            resize(size * 2);
        }
        data[++top] = val;
    }

    public int get(int index) {
        return data[index];
    }

    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(data[i]);
        }
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<Integer> res = new LinkedList<Integer>();
        DynamicArray[] seq = new DynamicArray[n];
        for (int i = 0; i < n; i++) {
            seq[i] = new DynamicArray();
        }
        int var = 0;
        int seqIndex, elementIndex, type, x, y;
        DynamicArray dyArr = null;

        for (List<Integer> query : queries) {
            type = query.get(0);
            x = query.get(1);
            y = query.get(2);
            switch (type) {
                case 1:
                    seqIndex = (x ^ var) % n;
                    dyArr = seq[seqIndex];
                    dyArr.add(y);
                    dyArr.print();
                    break;
                case 2:
                    seqIndex = (x ^ var) % n;
                    dyArr = seq[seqIndex];
                    elementIndex = y % dyArr.getSize();
                    var = dyArr.get(elementIndex);
                    res.add(var);
                    break;

                default:
                    break;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        List<List<Integer>> queries = new LinkedList<List<Integer>>();
        String[] queryLines = { "1 0 5", "1 1 7", "1 0 3", "2 1 0", "2 1 1" };
        for (String line : queryLines) {
            LinkedList<Integer> q = new LinkedList<>();
            for (String c : line.split(" ")) {
                Integer x = Integer.parseInt(c);
                q.add(x);
            }
            queries.add(q);
        }

        System.out.println(Arrays.toString(dynamicArray(2, queries).toArray()));
    }
}
