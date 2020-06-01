package com.zk;

public interface List<E> {
    int ELEMENT_NOT_FOUD = -1;
    void clear();
    int size();
    boolean isEmpty();
    boolean contains(E element);
    void add(E element);
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);
    void remove(E element);
    int indexOf(E element);
}
