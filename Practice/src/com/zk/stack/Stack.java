package com.zk.stack;

import com.zk.stack.list.ArrayList;
import com.zk.stack.list.LinkedList;
import com.zk.stack.list.List;

public class Stack<E> {
    private List<E> list = new ArrayList<>(); // LinkedList 双向链表也可以, 没有区别, push, pop, top复杂度都是O(1)
    // private List<E> list = new LinkedList<>();

    public void clear() {
        list.clear();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(list.size() - 1);
    }

    public E top() {
        return list.get(list.size() - 1);
    }
}
