package com.zk.queue;

import com.zk.heap.BinaryHeap;

public class PriorityQueue<E> {
    private BinaryHeap<E> heap = new BinaryHeap<>();

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void clear() {
        list.clear();
    }

    public void enQueue(E element) {
        list.add(element);
    }

    public E deQueue() {
        return list.remove(0);
    }

    public E front() {
        return list.get(0);
    }
}
