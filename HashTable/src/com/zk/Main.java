package com.zk;

import com.zk.map.HashMap;
import com.zk.map.Map;
import com.zk.model.Key;
import com.zk.model.Person;

public class Main {
    static void test1() {
        String string = "jack";
        System.out.println(string.hashCode());
        int len = string.length();
        int hashCode = 0;
        for (int i = 0; i < len; i++) {
            char c = string.charAt(i);
            hashCode = hashCode * 31 + c;
            // hashCode = (hashCode << 5) - hashCode + c;
        }
        System.out.println(hashCode);
    }

    static void test2() {
        Integer a = 110;
        Float b = 10.6f;
        Long c = 156L;
        Double d = 10.9;
        String e = "rose";

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());
        System.out.println(e.hashCode());

    }

    static void test3() {
        Person p1 = new Person(10, 1.67f, "jack");
        Person p2 = new Person(10, 1.67f, "jack");
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

        Map<Object, Object> map = new HashMap<>();
        map.put(p1, "abc");
        map.put("test", "ccc");
        map.put(p2, "bcd");
        System.out.println(map.size());
    }

    static void test4() {
        Person p1 = new Person(10, 1.67f, "jack");
        Person p2 = new Person(10, 1.67f, "jack");

        Map<Object, Integer> map = new HashMap<>();
        map.put(p1, 1);
        map.put(p2, 2);
        map.put("jack", 3);
        map.put("rose", 4);
        map.put("jack", 5);
        map.put(null, 6);

//        System.out.println(map.size());
//        System.out.println(map.remove("jack"));
//        System.out.println(map.get("jack"));
//        System.out.println(map.size());

        System.out.println(map.containsKey(p1));
        System.out.println(map.containsKey(null));
        System.out.println(map.containsValue(6));
        System.out.println(map.containsValue(1));

//        map.traversal(new Map.Visitor<Object, Integer>() {
//            @Override
//            public boolean visit(Object key, Integer value) {
//                System.out.println(key + "_" +value);
//                return false;
//            }
//        });

//        System.out.println(map.get("jack"));
//        System.out.println(map.get("rose"));
//        System.out.println(map.get(null));
//        System.out.println(map.get(p1));
    }

    static void test5() {
        Person p1 = new Person(10, 1.67f, "jack");
        Person p2 = new Person(10, 1.67f, "jack");

        Map<Object, Integer> map = new HashMap<>();
        map.put(p1, 1);
        map.put(p2, 2);
        map.put("jack", 3);
        map.put("rose", 4);
        map.put("jack", 5);
        map.put(null, 6);

//        System.out.println(map.size());
//        System.out.println(map.remove("jack"));
//        System.out.println(map.get("jack"));
//        System.out.println(map.size());

        System.out.println(map.containsKey(p1));
        System.out.println(map.containsKey(null));
        System.out.println(map.containsValue(6));
        System.out.println(map.containsValue(1));

//        map.traversal(new Map.Visitor<Object, Integer>() {
//            @Override
//            public boolean visit(Object key, Integer value) {
//                System.out.println(key + "_" +value);
//                return false;
//            }
//        });

//        System.out.println(map.get("jack"));
//        System.out.println(map.get("rose"));
//        System.out.println(map.get(null));
//        System.out.println(map.get(p1));
    }

    static void test6() {
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 1; i <= 19; i++) {
            map.put(new Key(i), i);
        }

        System.out.println(map.get(new Key(1)));
    }

    public static void main(String[] args) {
        test6();
    }
}
