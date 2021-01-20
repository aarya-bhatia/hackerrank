package com.aarya.hashmaps;

import java.io.*;
import java.util.*;

public class CountTriplets {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("input/countTriplets/case6.txt"))) {
            long n = sc.nextLong();
            long r = sc.nextLong();
            HashMap<Long, Long> map = new HashMap<>();

            for (long i = 0; i < n; i++) {
                long input = sc.nextLong();
                if (map.containsKey(input)) {
                    map.put(input, map.get(input) + 1);
                } else {
                    map.put(input, 1L);
                }
            }

            long count = 0;

            // NumberFormat nf = new DecimalFormat("0.#E0");
            // String mapString = "";

            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                long key = entry.getKey();
                long value = entry.getValue();

                // mapString += "[ " + nf.format(key) + " => " + nf.format(value) + " ]\n";

                if (key == 0 || (r == 1 && value < 3))
                    continue;

                if (r == 1) {
                    count += (value * (value - 1) * (value - 2)) / 6; // nC3 = n(n-1)(n-2)/3!
                } else {
                    long a = key * r;
                    long b = key * r * r;

                    if (map.containsKey(a) && map.containsKey(b)) {
                        long numTimes = value * map.get(a) * map.get(b);
                        count += numTimes;
                        System.out.printf("[%d, %d, %d] x %d \n", key, a, b, numTimes);
                        // System.out.printf("(%s, %s, %s) x %s \n", nf.format(key), nf.format(a),
                        // nf.format(b),
                        // nf.format(numTimes));
                    }
                }
            }
            // System.out.println(mapString);
            System.out.println(map);
            System.out.println(count);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        }
    }
}

