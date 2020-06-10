package com.zk;

import java.util.Comparator;
import com.zk.BinarySearchTree.Visitor;

public class Main {

    static void test1() {
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

    public static class Abc<E> implements Visitor<E> {

        @Override
        public void visit(E element) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.levelOrder(new Visitor<Integer>() {
            @Override
            public void visit(Integer element) {
                System.out.println("_" + element + "_ ");
            }
        });

        BinarySearchTree<Integer> bst2 = new BinarySearchTree<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        bst2.levelOrder(new Abc<Integer>());


    }
}
