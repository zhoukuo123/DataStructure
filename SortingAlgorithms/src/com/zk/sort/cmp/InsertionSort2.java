package com.zk.sort.cmp;

import com.zk.sort.Sort;

/**
 * 把交换转为挪动后的插入排序
 *
 * @param <E>
 */
public class InsertionSort2<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            int cur = begin;
            E v = array[cur];
            while (cur > 0 && cmp(v, array[cur - 1]) < 0) {
                array[cur] = array[cur - 1];
                cur--;
            }
            array[cur] = v;
        }
    }
}
