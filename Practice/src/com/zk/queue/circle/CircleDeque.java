package com.zk.queue.circle;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class CircleDeque<E> {
    private int size;
    private E[] elements;
    private int front;
    private static final int DEFAULT_CAPACITY = 10;

    public CircleDeque() {
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

    public void enQueueFront(E element) {
        ensureCapacity(size + 1);

        front = index(-1);
        elements[front] = element;
        size++;
    }

    public void enQueueRear(E element) {
        ensureCapacity(size + 1);

        elements[index(size)] = element;
        size++;
    }

    public E deQueueFront() {
       E element = elements[front];
       elements[front] = null;
       front = index(1);
       size--;
       return element;
    }

    public E deQueueRear() {
        E element = elements[index(size - 1)];
        elements[index(size - 1)] = null;
        size--;
        return element;
    }

    public E front() {
        return elements[front];
    }

    public E rear() {
        return elements[index(size - 1)];
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

        int newCapacity = oldCapacity + oldCapacity >> 1;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[index(i)];
        }
        elements = newElements;
        front = 0;
    }

    private int index(int index) {
        index += front;
        if (index < 0) {
            return index + elements.length;
        } else {
            // 取模运算符优化: n % m 等价于n - (n >= m ? m : 0) 前提条件: n < 2m
            // n = 7  m = 10  n % m = 7
            // n = 14 m =10   n % m = 4
            // 条件: m > 0, n >= 0, n < 2m
//            if (n >= m) {
//                System.out.println(n - m);
//            } else {
//                System.out.println(n);
//            }
//            n - (n >= m ? m : 0)
            return index - (index >= elements.length ? elements.length : 0);
        }
    }
}
