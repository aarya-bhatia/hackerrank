package com.aarya.strings;

import java.util.*;

public class Anagrams {

    private static void updateMap(HashMap<Character, int[]> map, Character key, int position) {
        if (map.containsKey(key)) {
            int values[] = map.get(key);
            values[position]++;
            map.put(key, values);
        } else {
            int values[] = { 0, 0 };
            values[position]++;
            map.put(key, values);
        }
    }

    /*
     * Compares two strings and checks if they are anagrams. An anagram contain the
     * same frequency of characters.
     */
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        /*
         * the int array for each key stores the count of that character in each string
         */
        HashMap<Character, int[]> map = new HashMap<>();

        a = a.toLowerCase();
        b = b.toLowerCase();

        for (int i = 0; i < a.length(); i++) {
            Character c1 = a.charAt(i);
            Character c2 = b.charAt(i);
            updateMap(map, c1, 0);
            updateMap(map, c2, 1);
        }

        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int[] x = entry.getValue();
            if (x[0] != x[1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
