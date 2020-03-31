package com.zk;

import java.util.Objects;

@SuppressWarnings("unchecked")

/**
 * 有动态缩容操作
 */
public class ArrayList2<E> extends AbstractList<E> {
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList2(int capacity) {

        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];

    }

    public ArrayList2() {
        this(DEFAULT_CAPACITY);
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public E get(int index) { // O(1)
        rangeCheck(index);
        return elements[index];
    }

    public E set(int index, E element) { // O(1)
        rangeCheck(index);

        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public void add(int index, E element) {
        /**
         * 最好: O(1)
         * 最坏: O(n)
         * 平均: O(n)
         */
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];

        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        /**
         * 最好: O(1)
         * 最坏: O(n)
         * 平均: O(n)
         */
        rangeCheck(index);
        E old = elements[index];
        for (int i = index + 1; i <= size -1; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;

        trim();
        return old;
    }

    public void remove (E element) {
        remove(indexOf(element));
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUD;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

        System.out.println(oldCapacity + "扩容为" + newCapacity);
    }

    private void trim() {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity >> 1;
        if (size >= newCapacity || oldCapacity < DEFAULT_CAPACITY) return;
        E[] newElements = (E[]) new Objects[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println(oldCapacity + "缩容为" + newCapacity);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }

            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
