package com.aarya.euler;

import java.util.Arrays;

public class Problem1 {
	
	public static void main(String arg[]) {
		quadraticPrimes(50);
	}
	
	/* Multiples of 3 and 5 */
	public static int solve(int max) {
		int sum = 0;
		for(int n = 1; n < max; n++) {
			if(n % 3 == 0 || n % 5 == 0) {
				System.out.println(n);
				sum += n;
			}
		}
		return sum;
	}
	
	/* Problem 9 */
	public static int pythagoreanTriplet(int sum) {
		for(int i = 1; i < sum/Math.sqrt(2); i++) {
			for(int j = 1; j < sum/Math.sqrt(2); j++) {
				int c = sum - i - j;
				if(i*i + j*j == c*c) {
					System.out.printf("%d, %d, %d\n", i, j, c);
					return i*j*c;
				}
			}
		}
		return -1;
	}
	
	/* problem 8 */
	public static long greatestProductSequence(String s, int l) {
		long maxProd = 1;
		for(int i = 0; i <= s.length()-l; i++) {
			long prod = 1;
			for(int j = i; j < i + l; j++) {
				int n = Character.getNumericValue(s.charAt(j));
				System.out.print(n + "\t");
				prod *= n;
				if(prod > maxProd) {
					maxProd = prod;
				}
			}
			System.out.println(prod);
		}
		return maxProd;
	}
	
	/* problem 27 - quadratic primes */
	public static void quadraticPrimes(int max) {
		int[] primes = getAllPrimes(max);
		System.out.println(Arrays.toString(primes));
		for(int a = 1-max; a < max; a++) {
			for(int b = 1-max; b < max; b++) {
				int count = 0;
				for(int n = 0; n < Math.abs(a); n++) {
					int val = n*n+n*a+b;
					System.out.printf("a: %d, b: %d, n: %d \n", a,b,n);
					if(Arrays.binarySearch(primes, val) >= 0) {
						count++;
					}
				}
				System.out.println("Primes: " + count);
			}
		}
		
	}
	
	public static int[] getAllPrimes(int n) {
		Generator generator = new Generator();
		int[] primes = new int[n];
		for(int i = 0; i < n; i++) {
			primes[i] = generator.next();
		}
		return primes;
	}
}

class Generator {
	int current = 2;
	
	public static boolean isPrime(int x) {
		for(int i = 2; i <= Math.sqrt(x); i++) {
			if(x % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public int next() {
		while(!isPrime(current)) current++;
		return current++;
	}
}
