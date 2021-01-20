package com.aarya.hashmaps;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Leaderboard {

    public static int getIndex(Set<?> set, Object value) {
        int result = 1;
        for (Object entry : set) {
            if (entry.equals(value)) {
                return set.size() - result + 1;
            }
            result++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] scores = { 100, 100, 50, 40, 40, 20, 10 };
        SortedSet<Integer> ranks = new TreeSet<>();
        for (int score : scores) {
            ranks.add(score);
        }
        // System.out.println("Ranks:" + ranks);
        int prevScore = -1;
        for (int score : new int[] { 5, 25, 50, 120 }) {
            if (prevScore > 0) {
                ranks.remove(prevScore);
            }
            ranks.add(score);
            prevScore = score;
            int rank = getIndex(ranks, score);
            System.out.println(rank);
            // System.out.println("Ranks: " + ranks);
        }
    }
}
