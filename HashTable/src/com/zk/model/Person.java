package com.zk.model;

public class Person implements Comparable<Person> {
    private int age;
    private float height;
    private String name;

    public Person(int age, float height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    /**
     * 用来比较2个对象是否相等
     * 用以判断2个key是否为同一个key
     */
    public boolean equals(Object obj) {
        // 内存地址
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        // if (obj == null || !(obj instanceof Person)) return false;

        // 比较成员变量
        Person person = (Person) obj;
        return person.age == age
                && person.height == height
                && person.name == null ? name == null : person.name.equals(name);
    }

    @Override
    /**
     * 必须保证equals为true的2个key的哈希值一样
     */
    public int hashCode() {
        int hashCode = Integer.hashCode(age);
        hashCode = hashCode * 31 + Float.hashCode(hashCode);
        hashCode = hashCode * 31 + (name != null ? name.hashCode() : 0);
        return hashCode;
    }

    @Override
    public int compareTo(Person o) {
        return age - o.age;
    }
}
