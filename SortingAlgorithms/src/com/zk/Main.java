package com.zk;

public class Main {
    public static void main(String[] args) {
        int[] array = {2, 9, 3, 7, 6, 1};

        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                }
            }
        }

        for (int value : array) {
            System.out.print(value + "_");
        }
    }
}
