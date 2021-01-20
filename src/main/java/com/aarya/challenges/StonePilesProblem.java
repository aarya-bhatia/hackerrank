package com.aarya.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class StonePilesProblem {
	
	public static int maximumStones(List<Integer> arr) {
        int evenSum = 0;
        int oddSum = 0;
        Iterator<Integer> itr = arr.listIterator();
        for(int i = 0; i < arr.size(); i++) {
            int a = itr.next();
            evenSum += i % 2 == 0 ? a : 0;
            oddSum += i % 2 == 0 ? 0 : a;
        }
        return Math.min(evenSum, oddSum) * 2;
    }
	
	public static void printSet(Set<Integer> s) {
		for(Integer next: s) {
			System.out.print(next);
		}
		System.out.println();
	}
	
	public static void printList(List<Integer> s) {
		Iterator<Integer> itr = s.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next());
		}
		System.out.println("");
	}
	
	public static String whoIsTheWinner(int[] arr) {
        Set<Integer> s = new HashSet<>();
		for (int j : arr) {
			s.add(j);
		}
        int count = arr.length - s.size(); // duplicate count
        
        System.out.println(Arrays.toString(arr));
        printSet(s);
        System.out.println("Duplicates: " + count);
        
        String p1 = "First";
        String p2 = "Second";
        if(count == 0) {
        	return p1;
        }
        if(count == 1) {
        	return p2;
        }
        if(count % 2 == 0) {
        	// player two moves
        	boolean won = didWin(s.size(), 2);
        	return won ? p2 : p1;
        }
        else {
        	// player one moves
        	boolean won = didWin(s.size(), 1);
        	return won ? p1 : p2;
        }
	}
	
	public static String whoIsTheWinner(List<Integer> arr) {
        Set<Integer> s = new HashSet<>();
		s.addAll(arr);
        int count = arr.size() - s.size(); // duplicate count
        
        printList(arr);
        printSet(s);
        System.out.println("Duplicates: " + count);
        
        String p1 = "First";
        String p2 = "Second";
        if(count == 0) {
        	return p1;
        }
        if(count == 1) {
        	return p2;
        }
        if(count % 2 == 0) {
        	// player two moves
        	boolean won = didWin(s.size(), 2);
        	return won ? p2 : p1;
        }
        else {
        	// player one moves
        	boolean won = didWin(s.size(), 1);
        	return won ? p1 : p2;
        }
	}
	
	public static boolean didWin(int len, int player) {
		return (len - 1 % 2 == 0);
	}
	
	public static void test() {
		int a1[] = {1, 2, 3, 3, 4, 4, 4, 5};
		int a2[] = {1, 2, 3, 3, 4, 4, 5};
		int a3[] = {1, 2, 3, 4, 4, 5};
		int a4[] = {1, 2, 3, 4, 5};
		
		System.out.println("Winner: " + whoIsTheWinner(a1));
		System.out.println("Winner: " + whoIsTheWinner(a2));
		System.out.println("Winner: " + whoIsTheWinner(a3));
		System.out.println("Winner: " + whoIsTheWinner(a4));
	}
	
	public static int maximumPower(String s) {
		// find the largest number possible by successive rotation
		int max = Integer.parseInt(s, 2);
        for(int i = 1; i < s.length(); i++){
            String next = s.substring(i) + s.substring(0, i);
            int num = Integer.parseInt(next, 2);
            System.out.println(num);
            if(num > max) {
            	max = num;
            }
        }
        int p = 0;
        // find the largest power of 2 that the number is divisible by
        for(int i = 0; i <= Math.log(max)/Math.log(2); i++) {
        	System.out.printf("dividing %d by %d %s \n", max, (int)Math.pow(2, i), max % (int)Math.pow(2, i) == 0 ? "divisible" : "not divisible");
        	if(max % (int)Math.pow(2, i) == 0) {
        		p = i;
        	}
        }
        return p;
    }
	
	public static void main(String args[]) {
		int res = maximumPower("1001");
		System.out.println(res);
	}
}
