package com.zk;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


//        List<Integer> list = new ArrayList<>();
//        list.add(11);
//        list.add(12);
//        list.add(13);
//        list.add(14);
//        for (Integer integer : list) {
//            list.remove(3);
//            System.out.println(integer);
//        }
//

//        ArrayList<Object> persons = new ArrayList<>();
//        persons.add(null);
//        persons.add(null);
//        persons.add(new Person(15, "Rose"));
//        persons.add(null);
//        persons.add(new Person(12, "James"));
//        persons.add(null);
//
//        System.out.println(persons.indexOf(null));
    }

    static void test() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(10, "Jack"));
        persons.add(new Person(12, "James"));
        persons.add(new Person(15, "Rose"));
        persons.clear();
        persons.add(new Person(22, "abc"));

        System.out.println(persons);
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(10);
        ints.add(22);
        ints.add(33);
        System.out.println(ints);

    }


}
