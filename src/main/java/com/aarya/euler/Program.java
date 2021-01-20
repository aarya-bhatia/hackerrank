package com.aarya.euler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Program {
    HashMap<Integer, Integer> factorials = new HashMap<>();
    HashMap<Integer, Integer> history = new HashMap<>();

    int f(int x) {
        return fact_sum(digits(x));
    }

    int sf(int x) {
        return dig_sum(digits(f(x)));
    }

    int dig_sum(int[] x) {
        return dig_sum_util(x, 0);
    }

    int dig_sum_util(int[] x, int indx) {
        if (indx > x.length - 1) {
            return 0;
        }
        return x[indx] + dig_sum_util(x, indx + 1);
    }

    int fact_sum(int[] x) {
        return fact_sum_util(x, 0);
    }

    int fact_sum_util(int[] x, int indx) {
        if (indx > x.length - 1) {
            return 0;
        }
        return fact(x[indx]) + fact_sum_util(x, indx + 1);
    }

    int fact(int x) {
        if (x <= 1) {
            return 1;
        }
        if (!factorials.containsKey(x)) {
            factorials.put(x, x * fact(x - 1));
        }
        return factorials.get(x);
    }

    int[] digits(int x) {
        int[] r = new int[String.valueOf(x).length()];
        int i = 0;
        while (x > 0) {
            r[i++] = x % 10;
            x = x / 10;
        }
        System.out.println(Arrays.toString(r));
        return r;
    }

    void generateSF() {
        for (int i = 1; i < 100; i++) {
            int res = sf(i);
            if (!history.containsKey(res)) {
                history.put(res, i);
            }
        }
    }

    int sg(int i) {
        return dig_sum(digits(history.get(i)));
    }

    int sum_sg(int n, int m) {
        return sum_sg_util(n, 1) % m;
    }

    int sum_sg_util(int n, int i) {
        if (i > n) {
            return 0;
        }
        return sg(i) + sum_sg_util(n, i + 1);
    }
}

class Solution {

    public static void main(String[] args) {
        Program p = new Program();
        System.out.println(p.f(342598));
        System.out.println(p.sf(342));

        for (Map.Entry<Integer, Integer> entry : p.factorials.entrySet()) {
            System.out.printf("The factorial of %d is %d%n", entry.getKey(), entry.getValue());
        }
    }

}
