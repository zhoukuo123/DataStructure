package com.zk.dynamic_array;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(11);
        list.add(12);
        list.add(13);
        System.out.println(list);

        ArrayList<Person> persons = new ArrayList<>(10);
        persons.add(new Person(10, "Jack"));
        persons.add(new Person(20, "James"));
        persons.add(new Person(30, "Rose"));
        System.out.println(persons);

    }
}








