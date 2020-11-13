package com.zk.model;

public class Key {
    protected int value;

    public Key(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Key key = (Key) obj;
        return value == key.value;
    }

    @Override
    public int hashCode() {
        return value / 10;
    }

    @Override
    public String toString() {
        return "v(" + value + ")";
    }
}
