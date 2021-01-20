package com.aarya.challenges;

import java.util.HashMap;
import java.util.Locale;

/* Program to convert roman numerals into integers */
public class RomanNumerals {
    HashMap<String, Integer> map = new HashMap<>();

    public RomanNumerals() {
        map.put("i", 1);
        map.put("v", 5);
        map.put("x", 10);
        map.put("l", 50);
        map.put("c", 100);
        map.put("d", 500);
        map.put("m", 1000);

        addCombo("ix");
        addCombo("iv");
        addCombo("xl");
        addCombo("xc");
        addCombo("cd");
        addCombo("cm");
    }

    public void addCombo(String s) {
        String[] ch = s.split("");
        map.put(s, map.get(ch[1]) - map.get(ch[0]));
    }

    public int romanToInteger(String roman) {

        String[] arr = roman.toLowerCase().split("");

        if(arr.length == 0) {
            return 0;
        }
        if(arr.length == 1) {
            return map.getOrDefault(arr[0], 0);
        }

        int sum = 0;
        for(int i = 0; i < arr.length - 1; i+= 2) {
            String letter = arr[i];
            String nextLetter = arr[i+1];
            String combo = letter + nextLetter;
            if(map.containsKey(combo)) {
                sum += map.get(combo);
            }
            else {
                if(map.containsKey(letter)) {
                    sum += map.get(letter);
                }
                if(map.containsKey(nextLetter)) {
                    sum += map.get(nextLetter);
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        RomanNumerals r = new RomanNumerals();
        String test = "XXIX";
        System.out.println(r.romanToInteger(test));
        test = "mv";
        System.out.println(r.romanToInteger(test));
        test = "mcm";
        System.out.println(r.romanToInteger(test));
        test = "lxxxi";
        System.out.println(r.romanToInteger(test));
    }

}

