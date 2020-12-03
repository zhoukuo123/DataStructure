package com.zk.sort;

public class RadixSort extends Sort<Integer> {
    @Override
    protected void sort() {
        // 找出最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // array[i] = 1000
        // 个位数: array[i] / 1 % 10 = 0
        // 十位数: array[i] / 10 % 10 = 0
        // 百位数: array[i] / 100 % 10 = 0
        // 千位数: array[i] / 1000 % 10 = 1
        for (int divider = 1; divider <= max; divider *= 10) {
            countingSort(divider);
        }
    }

    protected void countingSort(int divider) {
        // 开辟内存空间, 存储次数
        int[] counts = new int[10];
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++) {
            counts[array[i] / divider % 10]++;
        }
        // 累加次数
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }

        // 从后往前遍历元素, 将它放到有序数组中的合适位置
        int[] newArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            newArray[--counts[array[i] / divider % 10]] = array[i];
        }

        // 将有序数组赋值到array
        for (int i = 0; i < newArray.length; i++) {
            array[i] = newArray[i];
        }
    }

    /**
     * 基数排序的另一种思路, 空间复杂度: O(kn + k), 时间复杂度: O(dn), k是进制
     */
    protected void sort2() {
        int max = array[0]; // 最大值
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int[][] buckets = new int[10][array.length];
        // 每个桶的元素数量
        int[] bucketSizes = new int[buckets.length];
        for (int divider = 1; divider <= max; divider *= 10) {
            for (int i = 0; i < array.length; i++) {
                int no = array[i] / divider % 10;
                buckets[no][bucketSizes[no]++] = array[i];
            }
            int index = 0;
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < bucketSizes[i]; j++) {
                    array[index++] = buckets[i][j];
                }
                bucketSizes[i] = 0;
            }
        }
    }
}
