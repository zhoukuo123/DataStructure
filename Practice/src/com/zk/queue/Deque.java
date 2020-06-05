package com.zk.queue;

import com.zk.queue.list.LinkedList;
import com.zk.queue.list.List;

public class Deque<E> {
    private List<E> list = new LinkedList<>(); // 最好使用双向链表 LinkedList 入队出队复杂度都是O(1)

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void clear() {
        list.clear();
    }

    public void enQueueRear(E element) {
        list.add(element);
    }

    public void enQueueFront(E element) {
        list.add(0, element);
    }

    public E deQueueFront() {
        return list.remove(0);
    }

    public E deQueueRear() {
        return list.remove(list.size() - 1);
    }

    public E front() {
        return list.get(0);
    }

    public E rear() {
        return list.get(list.size() - 1);
    }

}
