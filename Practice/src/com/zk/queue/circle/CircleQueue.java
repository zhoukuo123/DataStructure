package com.zk.queue.circle;

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

    public void enQueue(E element) {
        elements[(front + size) % elements.length] = element;
        size++;
    }

    public E deQueue() {
        E deQueueElement = elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return deQueueElement;
    }

    public E front() {
        return elements[front];
    }
}
