package com.zk.queue;

import com.zk.queue.list.LinkedList;
import com.zk.queue.list.List;

public class Queue<E> {
    private List<E> list = new LinkedList<>(); // 最好使用双向链表 LinkedList 入队出队复杂度都是O(1)

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.size() == 0;
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
