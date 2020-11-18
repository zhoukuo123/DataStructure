package com.zk;

import com.zk.heap.BinaryHeap;

import java.util.Comparator;

public class Main {
    static void test1() {
        Integer[] data = {23, 32, 45, 70, 64};

        BinaryHeap<Integer> heap = new BinaryHeap<>(data);
        BinaryHeap<Integer> heap2 = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // BinaryHeap的实现是大顶堆, 会把认为大的放在上面
                // 修改比较逻辑, 变成数值小的认为比较大
                // 所以会把数值小的放在上面, 结果变成利用大顶堆构建了小顶堆
                return o2 - o1;
            }
        });
    }

    /**
     * TOP K问题 从n个整数中, 找出最大的前k个数(k远远小于n)
     */
    static void test2() {
        // 新建一个小顶堆
        BinaryHeap<Integer> heap = new BinaryHeap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // 找出最大的前k个数
        int k = 5;
        Integer[] data = {3, 72, 66, 88, 39, 9, 7, 86, 37, 8, 41, 12,
                22, 14, 61, 87, 19, 45, 51, 43, 52, 13, 59, 70, 74,
                2, 23, 47};
        for (int i = 0; i < data.length; i++) {
            if (heap.size() < k) { // 前k个数添加到小顶堆
                heap.add(data[i]); // logk
            } else if (data[i] > heap.get()) { // 如果是第k + 1个数, 并且大于堆顶元素
                heap.replace(data[i]); // logk
            }
        }
        // 时间复杂度: O(nlogk)
    }

    public static void main(String[] args) {
        test2();
    }
}
