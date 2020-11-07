package com.zk;

import com.zk.set.ListSet;
import com.zk.set.Set;
import com.zk.set.Set.Visitor;

public class Main {
    public static void main(String[] args) {
        Set<Integer> listSet = new ListSet<>();
        listSet.add(10);
        listSet.add(11);
        listSet.add(11);
        listSet.add(12);
        listSet.add(10);

        listSet.traversal(new Visitor<Integer>() {
            @Override
            public boolean visit(Integer element) {
                System.out.println(element);
                return false;
            }
        });
    }
}
