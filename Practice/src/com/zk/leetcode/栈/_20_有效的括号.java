package com.zk.leetcode.栈;

import javax.swing.*;
import java.util.HashMap;
import java.util.Stack;

public class _20_有效的括号 {

    private HashMap<Character, Character> map = new HashMap<>();

//    public _20_有效的括号() {
//        map.put('(', ')');
//        map.put('[', ']');
//        map.put('{', '}');
//    }

    {
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public boolean isValid(String s) {
        // (){}[]    {([])}[   (]{    ]
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char left = stack.pop();
                char right = map.get(left);
                if (right != c) return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        // (){}[]    {([])}[   (]{    ]
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char left = stack.pop();
                if (left == '(' && c != ')') return false;
                if (left == '[' && c != ']') return false;
                if (left == '{' && c != '}') return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        // (){}[]    ({[]})
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }
}
