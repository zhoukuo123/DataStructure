package com.zk.leetcode.链表;

/**
 *
 */
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

}
