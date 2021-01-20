package com.aarya.heaps;

import java.util.*;

public class Cookie {
    public static int solve(int c[], int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < c.length; i++) {
            q.add(c[i]);
        }

        int moves = 0;

        try {
            while (q.size() > 1 && q.peek() < k) {
                System.out.println(q);
                moves++;
                q.add(q.poll() + 2 * q.poll());
            }
            return q.peek() < k ? -1 : moves;
        } catch (Exception ex) {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[] { 4, 12, 43, 56, 10, 68, 98, 10, 3, 100 }, 124));
    }
}
