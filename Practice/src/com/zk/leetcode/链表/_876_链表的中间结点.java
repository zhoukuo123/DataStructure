package com.zk.leetcode.链表;

public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;
        // [1, 2]
        //  s  f
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                return slow;
            }
            if (fast.next == null) {
                slow = slow.next;
                return slow;
            }
        }
        return fast;
    }
}
