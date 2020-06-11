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

    public static class Abc<E> extends Visitor<E> {

        @Override
        public boolean visit(E element) {
            System.out.println(element);
            return false;
        }
    }

    static int count = 0;
    static void test2() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.levelOrder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                count++;
                System.out.println("_" + element + "_ ");
                return count == 3;
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

    static void test3() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] data = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 1, 3, 10, 12
        };
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        bst.postorder(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                count++;
                System.out.print(element + " ");
                return count == 3;
            }
        });
    }

    static void test4() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] data = new Integer[] {
                7, 4, 9, 2, 5, 8, 11, 1, 3, 10, 12
        };
        for (int i = 0; i < data.length; i++) {
            bst.add(data[i]);
        }
        System.out.println(bst.height());
    }

    public static void main(String[] args) {
        test4();


    }
}
