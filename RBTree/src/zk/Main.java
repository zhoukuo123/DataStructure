package zk;

import com.zk.tree.AVLTree;
import com.zk.tree.BST;

import java.util.ArrayList;
import java.util.List;

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

    static void test2() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100_0000; i++) {
            data.add((int) (Math.random() * 100_0000));
        }

        BST<Integer> bst = new BST<>();
        for (int i = 0; i < data.size(); i++) {
            bst.add(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            bst.contains(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            bst.remove(data.get(i));
        }
        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.size(); i++) {
            avl.add(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            avl.contains(data.get(i));
        }
        for (int i = 0; i < data.size(); i++) {
            avl.remove(data.get(i));
        }
    }

    public static void main(String[] args) {
        test1();
    }
}
