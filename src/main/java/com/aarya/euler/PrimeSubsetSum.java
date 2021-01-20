package com.aarya.euler;

import java.util.*;

public class PrimeSubsetSum {

    public static void main(String args[]) {

        try (Scanner sc = new Scanner(System.in)) {
            int k = sc.nextInt();

            for (int i = 0; i < k; i++) {
                int number = sc.nextInt();
                int result = 0;

                List<Integer> primes = SieveOfEratosthenes.getPrimesTill(number);

                int arr[] = new int[primes.size()];
                int index = 0;

                for (int prime : primes) {
                    arr[index++] = prime;
                }

                System.out.println(result);
            }

        }
    }

}