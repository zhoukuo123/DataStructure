package com.zk.map;

public class LinkedHashMap<K, V> extends HashMap<K, V> {
    private LinkedNode<K, V> first;
    private LinkedNode<K, V> last;

    @Override
    protected Node<K, V> createNode(K key, V value, Node<K, V> parent) {
        return new LinkedNode<>(key, value, parent);
    }

    private static class LinkedNode<K, V> extends Node<K, V> {
        LinkedNode<K, V> prev;
        LinkedNode<K, V> next;

        public LinkedNode(K key, V value, Node<K, V> parent) {
            super(key, value, parent);
        }
    }
}
