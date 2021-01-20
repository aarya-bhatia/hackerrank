package com.aarya.arrays;

import java.util.*;

public class Fighters {

    public static void main(String[] args) {
        Scanner sc = new Scanner("5 2 1 3 4 3 0 3 0 1 1 3 0 4 ");
        // Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int h[] = new int[n];

        for (int i = 0; i < n; i++) {
            h[i] = sc.nextInt();
        }

        boolean dp[][] = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (Math.abs(h[i] - h[j]) <= k) {
                    dp[i][j] = true;
                }
            }
        }

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(countPairs(dp, a, b));
        }

        sc.close();
    }

    public static int countPairs(boolean[][] dp, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count / 2;
    }
}
