package com.zk;

import com.zk.file.FileInfo;
import com.zk.file.Files;
import com.zk.map.Map;
import com.zk.map.TreeMap;

public class Main {

    static void test1() {
        Map<String, Integer> map = new TreeMap<>();
        map.put("class", 2);
        map.put("public", 5);
        map.put("text", 6);
        map.put("public", 8);

        map.traversal(new Map.Visitor<String, Integer>() {
            @Override
            public boolean visit(String key, Integer value) {
                System.out.println(key + "_" + value);
                return false;
            }
        });
    }

    static void test2() {
        FileInfo fileInfo = Files.read("/home/linux/concurrent", new String[]{"java"});
        System.out.println("文件数量:" + fileInfo.getFiles());
        System.out.println("代码行数:" + fileInfo.getLines());
        String[] words = fileInfo.words();
        System.out.println("单词数量:" + fileInfo.words().length);

        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            Integer count = map.get(words[i]);
            count = (count == null) ? 1 : (count + 1);
            map.put(words[i], count);
        }

        System.out.println(map.size());

        map.traversal(new Map.Visitor<String, Integer>() {
            @Override
            public boolean visit(String key, Integer value) {
                System.out.println(key + "_" + value);
                return false;
            }
        });
    }

    public static void main(String[] args) {
        test2();
    }
}
