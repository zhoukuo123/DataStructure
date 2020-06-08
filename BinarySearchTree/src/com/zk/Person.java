package com.zk;

public class Person implements Comparable<Person> {
    private int age;

    public int getAge() {
        return age;
    }

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return age - o.getAge();
    }
}
