package com.zk.sort.cmp;

import com.zk.sort.Sort;

@SuppressWarnings("unchecked")
public class MergeSort<E extends Comparable<E>> extends Sort<E> {
    private E[] leftArray;

    @Override
    protected void sort() {
        leftArray = (E[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    /**
     * 对 [begin, end) 范围的数据进行归并排序
     */
    private void sort(int begin, int end) {
        if (end - begin < 2) return;

        int mid = (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin, mid, end);
    }

    /**
     * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
     */
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin; // 左边数组(基于leftArray)
        int ri = mid, re = end; // 右边数组(基于array)
        int ai = begin; // array的索引

        // 备份左边数组
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }
        // 如果左边还没有结束
        while (li < le) {
            if (ri < re && cmp(array[ri], leftArray[li]) < 0) { // 如果ri == re, 说明右边先结束
                array[ai++] = array[ri++];
            } else {
                array[ai++] = leftArray[li++];
            }
        } // cmp位置改为 <= 会失去稳定性
    }
}
