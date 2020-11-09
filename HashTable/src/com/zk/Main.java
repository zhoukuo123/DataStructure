package com.zk;

public class Main {
    static void test1() {
        String string = "jack";
        System.out.println(string.hashCode());
        int len = string.length();
        int hashCode = 0;
        for (int i = 0; i < len; i++) {
            char c = string.charAt(i);
            hashCode = hashCode * 31 + c;
            // hashCode = (hashCode << 5) - hashCode + c;
        }
        System.out.println(hashCode);
    }

    static void test2() {

    }

    public static void main(String[] args) {
        int a = 110;
        float b = 10.6f;
        long c = 156L;
        double d = 10.9;
        String e = "rose";

        System.out.println(Integer.hashCode(a));
        System.out.println(Float.floatToIntBits(b));
        System.out.println();

    }
}
