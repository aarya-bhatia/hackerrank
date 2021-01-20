package com.aarya.euler;

import java.util.*;

public class CountSubsetsWithGivenSum {

    public static int countSets(int[] arr, int total) {
        HashMap<String, Integer> mem = new HashMap<>();
        int result = dp(arr, total, arr.length - 1, mem);
        System.out.println(mem);
        return result;
    }

    public static int dp(int[] arr, int total, int i, HashMap<String, Integer> mem) {
        String key = total + ":" + i;
        int value;

        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        else if (total == 0) {
            return 1;
        }

        else if (total < 0 || i < 0) {
            return 0;
        }

        else if (total < arr[i]) {
            value = dp(arr, total, i - 1, mem);
        }

        else {
            value = dp(arr, total - arr[i], i - 1, mem) + dp(arr, total, i - 1, mem);
        }

        mem.put(key, value);
        return value;
    }
}
