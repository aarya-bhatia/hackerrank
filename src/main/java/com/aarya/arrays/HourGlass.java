package com.aarya.arrays;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HourGlass {

    private static final Scanner scanner = new Scanner(System.in);

    public static void test(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();

        new Program(arr);
    }

    public static void main(String[] args) {
        int[][] h = new int[6][6];
        int r = 0, c = 0;
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            while (sc.hasNext()) {
                System.out.printf("row = %d, col = %d%n", r, c);
                String nextToken = sc.next();
                System.out.println("next token=" + nextToken);
                int next = Integer.parseInt(nextToken);
                // int next = sc.nextInt();
                h[r][c] = next;
                c++;
                if (r == 6 && c == 6) {
                    break;
                }
                if (c == 6) {
                    r++;
                    c = 0;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(h[i][j] + "  ");
            }
            System.out.println();
        }
        new Program(h);
    }

    static class Hourglass {
        Stack<Integer> stack;
        int size = 7;

        public Hourglass() {
            stack = new Stack<>();
        }

        boolean isEmpty() {
            return stack.isEmpty();
        }

        void add(int el) {
            System.out.println("adding..." + el);
            if (stack.size() < size) {
                stack.push(el);
            }
        }

        int sum() {
            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            System.out.println("Stack sum: " + sum);
            return sum;
        }

        void clear() {
            stack.clear();
        }

        public String toString() {
            return stack.toString();
        }
    }

    static class Program {
        Hourglass hg = new Hourglass();
        int size = 6;
        int[][] h;

        public Program(int x[][]) {
            if (x.length != size) {
                throw new IllegalArgumentException();
            }
            h = x;
            start();
        }

        int hgSum(int row, int col) {
            System.out.println("STACK: " + hg.toString());
            if (row > size - 2 || col > size - 2) {
                return -999;
            }
            if (hg.isEmpty()) {
                hg.add(h[row][col]);
                hg.add(h[row][col + 1]);
                hg.add(h[row][col + 2]);
                hg.add(h[row + 1][col + 1]);
                hg.add(h[row + 2][col]);
                hg.add(h[row + 2][col + 1]);
                hg.add(h[row + 2][col + 2]);
                return hg.sum();
            } else {
                hg.clear();
                return hgSum(row, col);
            }
        }

        void start() {
            int max = -999;
            for (int i = 0; i < size - 2; i++) {
                for (int j = 0; j < size - 2; j++) {
                    int curSum = hgSum(i, j);
                    if (curSum > max) {
                        max = curSum;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
