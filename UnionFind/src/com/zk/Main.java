package com.zk;

import com.zk.tools.Asserts;
import com.zk.tools.Times;
import com.zk.union.*;

public class Main {
    static final int COUNT = 1000000;

    public static void main(String[] args) {
//        testTime(new UnionFind_QF(COUNT));
//        testTime(new UnionFind_QU(COUNT));
        testTime(new UnionFind_QU_S(COUNT));
        testTime(new UnionFind_QU_R(COUNT));
        testTime(new UnionFind_QU_R_PC(COUNT));
        testTime(new UnionFind_QU_R_PS(COUNT));
        testTime(new UnionFind_QU_R_PH(COUNT));
    }

    static void testTime(UnionFind uf) {
        uf.union(0, 1);
        uf.union(0, 3);
        uf.union(0, 4);
        uf.union(2, 3);
        uf.union(2, 5);

        uf.union(6, 7);

        uf.union(8, 10);
        uf.union(9, 10);
        uf.union(9, 11);
        Asserts.test(!uf.isSame(2, 7));
        uf.union(4, 6);
        Asserts.test(uf.isSame(2, 7));

        Times.test(uf.getClass().getSimpleName(), () -> {
            for (int i = 0; i < COUNT; i++) {
                uf.union((int) (Math.random() * COUNT),
                        (int) (Math.random() * COUNT));
            }

            for (int i = 0; i < COUNT; i++) {
                uf.isSame((int) (Math.random() * COUNT),
                        (int) (Math.random() * COUNT));
            }
        });
    }
}
