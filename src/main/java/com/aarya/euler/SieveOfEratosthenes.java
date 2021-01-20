package com.aarya.euler;

import java.util.*;

public class SieveOfEratosthenes {

    public static List<Integer> getPrimesTill(int n) {
        List<Integer> primes = new ArrayList<>();

        // array prime[0...n] will contains primes where value if false
        boolean prime[] = new boolean[n + 1];

        // initialise all to true
        Arrays.fill(prime, true);

        for (int p = 2; p * p <= n; p++) {

            // prime[p] is a prime
            if (prime[p]) {

                // update all multiples of p
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }

            }
        }

        // put all prime numbers into list
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    public static void main(String[] args) {
        int n = 30;
        List<Integer> primes = SieveOfEratosthenes.getPrimesTill(n);
        System.out.print("Prime numbers smaller than or equal to " + n + " are as follows: " + primes);
    }
}
