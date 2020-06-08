package com.zk;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Integer[] data = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 3
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        BinarySearchTree<Person> bst3 = new BinarySearchTree<>();
        bst3.add(new Person(11));
        bst3.add(new Person(22));
    }
}
