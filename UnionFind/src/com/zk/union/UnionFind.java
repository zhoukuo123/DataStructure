package com.zk.union;

public class UnionFind {
    private int[] parents;

    public UnionFind(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        parents = new int[capacity];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
    }

    /**
     * 查找v所属的集合 (根节点)
     */
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }

    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;

        for (int i = 0; i < parents.length; i++) {
            if (parents[i] == p1) {
                parents[i] = p2;
            }
        }
    }

    /**
     * 检查v1, v2是否属于同一个集合
     */
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    private void rangeCheck(int v) {
        if (v < 0 || v >= parents.length) {
            throw new IllegalArgumentException("v is out of bounds");
        }
    }
}
