package com.zk;

import com.zk.tree.AVLTree;

public class Main {
    static void test1() {
        Integer[] data = new Integer[]{
                100, 16, 25, 3, 95, 36, 37, 19, 48, 53, 20, 33, 24, 14, 42, 72
        };

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }
        System.out.println(avl);
    }

    public static void main(String[] args) {
        test1();
    }
}
