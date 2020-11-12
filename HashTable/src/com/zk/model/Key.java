package com.zk.model;

public class Key {
    private int value;

    public Key(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return value == key.value;
    }

    @Override
    public int hashCode() {
        return value / 20;
    }

    @Override
    public String toString() {
        return "v(" + value + ")";
    }
}
