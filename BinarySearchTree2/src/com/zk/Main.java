package com.zk;

import com.zk.tree.BST;
import com.zk.tree.BinaryTree;

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

    static void test2() {
        Integer[] data = new Integer[]{
                7, 4, 9, 2, 5, 8, 11
        };
        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        StringBuilder sb = new StringBuilder();
        BinaryTree.Visitor<Integer> visitor = new BinaryTree.Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                sb.append(element).append(" ");
                return false;
            }
        };
        bst.preorder(visitor);
        System.out.println(sb);
    }

    public static void main(String[] args) {
//        test1();
        test2();

    }
}
