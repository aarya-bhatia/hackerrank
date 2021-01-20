package com.aarya.arrays;

import java.util.Arrays;

public class LargestRectangle {
    public static void log(int left, int right, int hmin, long maxA, long newA) {
        System.out.println("left " + left + " right " + right + " hmin " + hmin + " maxA " + maxA + " newA " + newA);
    }

    public static long solve(int position, int h[]) {
        if(position > h.length || position < 0) return 0;

        int left = position, right = position;
        int hmin = h[position];
        long maxA = hmin;

        System.out.println("right peak");

        // Find right peak while keeping left stationary
        while(right < h.length - 1) {
            int newH = Math.min(hmin, h[right+1]);
            long newA = (right - left + 2) * newH;
            log(left, right, hmin, maxA, newA);
            if(newA >= maxA) {
                maxA = newA;
                hmin = newH;
                right++;
            } else {
                break;
            }
        }

        System.out.println("left peak");

        // Find left peak while keeping right stationary
        int leftShift = right;
        int hminShift = h[right];
        long maxAShift = hmin;

        while(left > 0) {
            int newH = Math.min(h[leftShift - 1], hminShift);
            long newA = (right - leftShift + 2) * newH;
            log(leftShift, right, hminShift, maxAShift, newA);
            if(newA >= maxAShift) {
                maxAShift = newA;
                hminShift = newH;
                leftShift--;
            }
            else {
                break;
            }
        }

        // compare left shifted and without shift areas to see who did better
        if(maxAShift > maxA) {
            maxA = maxAShift;
            left = leftShift;
        }

        // If there are unvisited elements, find the next largest area of that region
        // and return the area which is bigger i.e. current area vs area of next region
        if(right == h.length - 1) return maxA;
        return Math.max(maxA, solve(right+1, h));
    }

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        int n = h.length;
        if(n == 0) return 0;
        if(n == 1) return h[0];
        return solve(0, h);
    }

    public static void main(String args[]) {
        int h[];
        if(args.length > 0) {
            h = new int[args.length];
            for(int i = 0; i < args.length; i++) {
                h[i] = Integer.parseInt(args[i]);
            }
        }
        else {
            h = new int[] {3, 2, 2, 3};
        }
        System.out.println(Arrays.toString(h));
        long largestArea = largestRectangle(h);
        System.out.println("Largest area is " + largestArea);
    }
}
