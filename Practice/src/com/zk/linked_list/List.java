package com.zk.linked_list;

public interface List<E> {
    int ELEMENT_NOT_FOUND = -1;

    void clear();

    void add(int index, E element);

    void remove(int index);

    E get(int index);

    E set(int index, E element);

    int indexOf(E element);

    void add(E element);
    boolean isEmpty();
    int size();
    boolean contains(E element);
    void remove(E element);
}
