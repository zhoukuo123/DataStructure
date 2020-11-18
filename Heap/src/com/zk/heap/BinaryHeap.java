package com.zk.heap;

import org.omg.CORBA.Object;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class BinaryHeap<E> extends AbstractHeap<E> implements Heap<E> {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap() {
        this(null);
    }

    public BinaryHeap(Comparator<E> comparator) {
        super(comparator);
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    /**
     * 让index位置的元素上滤
     *
     * @param index
     */
    private void siftUp(int index) {
//        E e = elements[index];
//        while (index > 0) {
//            int pindex = (index - 1) >> 1;
//            E p = elements[pindex];
//            if (compare(e, p) <= 0) return;
//
//            // 交换index, pindex位置的内容
//            E tmp = elements[index];
//            elements[index] = elements[pindex];
//            elements[pindex] = tmp;
//
//            // 重新赋值index
//            index = pindex;
//        }
        E e = elements[index];
        while (index > 0) {
            int pindex = (index - 1) >> 1;
            E p = elements[pindex];
            if (compare(e, p) <= 0) break;

            // 将父元素存储在index位置
            elements[index] = p;

            // 重新赋值index
            index = pindex;
        }
        elements[index] = e;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new java.lang.Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }


    private void emptyCheck() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("element must not be null");
        }
    }
}
