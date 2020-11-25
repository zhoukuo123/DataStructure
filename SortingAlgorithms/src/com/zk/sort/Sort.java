package com.zk.sort;

public abstract class Sort {
    protected Integer[] array;
    private int cmpCount;
    private int swapCount;

    // 公共接口
    public void sort(Integer[] array) {
        // 过滤
        if (array == null || array.length < 2) return;

        // 将数组存起来
        this.array = array;

        sort();
    }

    protected abstract void sort();

    /**
     * 返回值等于0, 代表 array[i1] == array[i2]
     * 返回值小于0, 代表 array[i1] < array[i2]
     * 返回值大于0, 代表 array[i1] > array[i2]
     */
    protected int cmp(int i1, int i2) {
        cmpCount++;
        return array[i1] - array[i2];
    }

    protected void swap(int i1, int i2) {
        swapCount++;
        int tmp = array[i1];
        array[i1] = array[i2];
        array[i2] = tmp;
    }
}
