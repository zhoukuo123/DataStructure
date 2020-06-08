package com.zk.queue.circle;

import java.net.IDN;

/**
 * 其实队列底层也可以使用动态数组实现,并且各项接口也可以优化到 O(1) 的时间复杂度
 * 这个用数组实现并且优化之后的队列也叫做:循环队列
 */
@SuppressWarnings("unchecked")
public class CircleQueue<E> {
    private int size;
    private int front; // 使用front保存队列头的下标
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleQueue() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[index(i)] = null;
        }
        size = 0;
        front = 0;
    }

    public void enQueue(E element) {
        ensureCapacity(size + 1);

        elements[index(size)] = element;
        size++;
    }

    public E deQueue() {
        E deQueueElement = elements[front];
        elements[front] = null;
        front = index(1);
        size--;
        return deQueueElement;
    }

    public E front() {
        return elements[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("capacity=").append(elements.length)
                .append(" size=").append(size).append(", [");
        for (int i = 0; i < elements.length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            sb.append(elements[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        // 注意: 要重置front
        front = 0;
    }

    private int index(int index) {
        index += front;
        return index - (index >= elements.length ? elements.length : 0);
    }
}
