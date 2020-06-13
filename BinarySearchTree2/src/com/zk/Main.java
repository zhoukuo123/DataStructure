package com.zk;

import com.zk.tree.BST;

public class Main {
    static void test1() {
        Integer[] data = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 1, 3, 12
        };

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        System.out.println(bst);
        bst.remove(7);
        System.out.println(bst);
    }

    public static void main(String[] args) {
        test1();


    }
}
