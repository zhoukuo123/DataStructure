package com.zk;

import com.zk.union.UnionFind;
import com.zk.union.UnionFind_QF;

public class Main {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind_QF(12);
        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);

//        uf.union(4, 6);

        System.out.println(uf.isSame(0, 6));
        System.out.println(uf.isSame(2, 7));
    }
}
