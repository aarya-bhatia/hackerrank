package com.aarya.search;

import java.io.*;
import java.util.*;

public class Pairs {

    /**
     * find other number such that the abs diff of both num is equal to given diff
     */
    static int getOtherNum(int num, int diff) {
        return num < diff ? num + diff : num - diff;
    }

    static int pairs(int k, int[] arr) {
        Set<Integer> numbers = new HashSet<>();
        HashPair pairs = new HashPair();

        // if arr has duplicates use a hashmap instead.

        for (int num : arr) {
            numbers.add(num);
        }

        for (int num : numbers) {
            int otherNum = getOtherNum(num, k);
            // assume otherNum cannot be the same
            if (numbers.contains(otherNum) && !pairs.hasPair(num, otherNum)) {
                pairs.addPair(num, otherNum);
            }
        }

        System.out.println(pairs.toString());

        return pairs.size();
    }

    /*
     * Data structure to store pairs of numbers and avoid adding duplicates
     */
    private static class HashPair {
        Set<String> set = new HashSet<>();

        /*
         * Key is uses min and max num because pair(a, b) == pair(b, a)
         */
        private String getKey(int a, int b) {
            return String.format("[%d,%d]", Math.min(a, b), Math.max(a, b));
        }

        public String toString() {
            return set.toString();
        }

        public void addPair(int a, int b) {
            String key = getKey(a, b);
            set.add(key);
        }

        public boolean hasPair(int a, int b) {
            String key = getKey(a, b);
            return set.contains(key);
        }

        public int size() {
            return set.size();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
