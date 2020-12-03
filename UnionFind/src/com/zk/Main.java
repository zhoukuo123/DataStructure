package com.zk;

import com.zk.union.UnionFind;

public class Main {
    public static void main(String[] args) {
        UnionFind uf = new UnionFind(12);
        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        System.out.println(uf.isSame(3, 5));
    }
}
