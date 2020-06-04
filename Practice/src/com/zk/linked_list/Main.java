package com.zk.linked_list;

import com.zk.asserts.Asserts;
import com.zk.linked_list.circle.CircleLinkedList;
import com.zk.linked_list.practice.SingleCircleLinkedList;

public class Main {
    static void testList(List<Integer> list) {
        list.add(0, 100);
        list.add(10);
        list.add(20);
        list.add(0, 200);
        list.remove(0); // [100, 10, 20]
        list.remove(list.size() - 1); // [100, 10]
        list.add(30); // [100, 10, 30]

        Asserts.test(list.get(0) == 100);
        Asserts.test(list.get(list.size() - 1) == 30);
        Asserts.test(list.set(0, 200) == 100);

        System.out.println(list); // size=3, [200_10, 10_30, 30_200]
    }

    public static void main(String[] args) {
//        testList(new SingleCircleLinkedList<>());
//        testList(new com.zk.linked_list.circle.SingleCircleLinkedList<>());
//        testList(new CircleLinkedList<>());
//        testList(new com.zk.linked_list.practice.CircleLinkedList<>());



    }

}
