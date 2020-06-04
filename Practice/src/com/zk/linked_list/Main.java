package com.zk.linked_list;

import com.zk.linked_list.single.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(0, 100);
        list.add(10);
        list.add(20);
        list.remove(0);
        list.remove(list.size() - 1);
        list.add(30);
        System.out.println(list); // size=2, [null_10_30, 10_30_null]



    }

}
