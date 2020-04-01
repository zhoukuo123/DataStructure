package com.zk;

public class BinarySearchTree<E> {
    private int size;
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void add(E element) {

    }

    public void remove(E element) {

    }

    public boolean contains(E element) {
        return false;
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;
        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
