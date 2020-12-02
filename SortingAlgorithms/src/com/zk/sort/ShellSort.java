package com.zk.sort;

import java.util.ArrayList;
import java.util.List;

public class ShellSort<E extends Comparable<E>> extends Sort<E> {
    @Override
    protected void sort() {
        List<Integer> stepSequence = shellStepSequence();
        for (Integer step : stepSequence) {
            sort(step);
        }
    }

    /**
     * 分成step列进行排序
     *
     * @param step
     */
    private void sort(int step) {
        for (int col = 0; col < step; col++) { // 对第col列进行排序

            for (int begin = 1; begin < array.length; begin++) {
                int cur = begin;
                while (cur > 0 && cmp(cur, cur - 1) < 0) {
                    swap(cur, cur - 1);
                    cur--;
                }
            }
        }
    }

    private List<Integer> shellStepSequence() {
        List<Integer> stepSequence = new ArrayList<>();
        int step = array.length;
        while ((step >>= 1) > 0) {
            stepSequence.add(step);
        }
        return stepSequence;
    }
}
