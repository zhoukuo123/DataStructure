package com.zk.dynamic_array.practice;

public class Assert {
    public static void test(boolean value) {
        try {
            if (!value) throw new IllegalArgumentException("测试未通过");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
