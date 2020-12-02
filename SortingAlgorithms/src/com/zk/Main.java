package com.zk;

import com.zk.sort.*;
import com.zk.tools.Asserts;
import com.zk.tools.Integers;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Main {
    public static void main(String[] args) {
//        int[] array = {2, 4, 6, 8, 10};
//        Asserts.test(BinarySearch.indexOf(array, 4) == 1);
//        Asserts.test(BinarySearch.indexOf(array, 2) == 0);
//        Asserts.test(BinarySearch.indexOf(array, 10) == 4);
//        Asserts.test(BinarySearch.indexOf(array, 56) == -1);

        Integer[] array = Integers.random(30000, 1, 30000);

        testSorts(array,
                new BubbleSort3(),
                new SelectionSort(),
//                new InsertionSort1(),
//                new InsertionSort2(),
                new InsertionSort3(),
                new HeapSort(),
                new MergeSort(),
                new QuickSort(),
                new ShellSort()
        );
    }

    static void testSorts(Integer[] array, Sort... sorts) {
        for (Sort sort : sorts) {
            Integer[] newArray = Integers.copy(array);
            sort.sort(newArray);
            Asserts.test(Integers.isAscOrder(newArray));
        }

        Arrays.sort(sorts);

        for (Sort sort : sorts) {
            System.out.println(sort);
        }
    }

    static void selectionSort(Integer[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int begin = 1; begin <= end; begin++) {
                if (array[maxIndex] <= array[begin]) {
                    maxIndex = begin;
                }
            }
            int tmp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = tmp;
        }
    }

    static void bubbleSort1(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                }
            }
        }
    }

    static void bubbleSort2(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            boolean sorted = true;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    static void bubbleSort3(int[] array) {
        for (int end = array.length - 1; end > 0; end--) {
            // sortedIndex的初始值在数组完全有序的时候有用
            int sortedIndex = 1;
            for (int begin = 1; begin <= end; begin++) {
                if (array[begin] < array[begin - 1]) {
                    int tmp = array[begin];
                    array[begin] = array[begin - 1];
                    array[begin - 1] = tmp;
                    sortedIndex = begin;
                }
            }
            end = sortedIndex;
        }
    }
}
