package com.zk.leetcode.链表;

public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }
        ListNode headNode = head;

        while (headNode.next != null) {
            if (headNode.next.val == val) {
                headNode.next = headNode.next.next;
            } else {
                headNode = headNode.next;
            }
        }
        return head;
    }

    /**
     * 有问题 node = null; ???
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode node = head;
        while (node != null) {
            if (node.val == val) {
                if (node.next == null) {
                    node = null;
                    return head;
                }
                node.val = node.next.val;
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }
}
