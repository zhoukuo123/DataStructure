package com.zk;

/**
 * 0 1 2 3 4 5 6 7
 * 0 1 1 2 3 5 8 13 ....
 */
public class Fibnaci {
    public int fib(int N) {
        if (N <= 1) return N;

        int first = 0;
        int second = 1;
        for (int i = 0; i < N - 1; i++) {
            second += first;
            first = second - first;
        }
        return second;
    }
}
