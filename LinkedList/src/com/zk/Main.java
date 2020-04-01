package com.zk;

import com.zk.circle.CircleLinkedList;
import com.zk.single.SingleLinkedList;

public class Main {

    static void josephus() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        for (int i = 1; i <= 8; i++) {
            list.add(i);
        }
        // 指向头节点(指向1)
        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }
    }
    public static void main(String[] args) {
        josephus(); // 约瑟夫问题
//        List<Integer> list = new SingleLinkedList<>();
//        list.add(20);
//        list.add(0, 10);
//        list.add(30);
//        list.add(list.size(), 40);
//        list.remove(1);
//        System.out.println(list);
    }
}
