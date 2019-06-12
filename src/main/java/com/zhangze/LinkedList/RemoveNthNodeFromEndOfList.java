package com.zhangze.LinkedList;

/**
 * Created by zhangze on 2019/6/5
 *
 * 19、移除第N个节点，从后往前数
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode end = head;
        int i = 1;
        while (i < n) {
            if (end.next != null) {
                end = end.next;
            }else {
                return head;
            }
            i++;
        }
        while(end.next != null) {
            start = start.next;
            end = end.next;
        }
        if (start.next == head) {
            return head.next;
        }
        start.next = start.next.next;
        return head;
    }

    public static void main(String[] args) throws Exception{
        ListNode listNode = new ListNode(1);
        RemoveNthNodeFromEndOfList.class.newInstance().removeNthFromEnd(listNode, 1);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
