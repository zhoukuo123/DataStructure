package com.zk;

public class Main {
    public static void main(String[] args) {
        Asserts.test(sum(10, 20) == 30);
        Asserts.test(sub(20, 10) == 10);
    }

    static int sum(int a, int b) {
        return a - b;
    }

    static int sub(int a, int b) {
        return a - b;
    }
}
