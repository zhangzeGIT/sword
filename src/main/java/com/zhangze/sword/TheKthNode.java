package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/6
 * 22、链表中倒数第K个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class TheKthNode {

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        ListNode current = head;
        while (k > 1) {
            head = head.next;
            k--;
            if (head == null) {
                return null;
            }
        }
        while (head.next != null) {
            head = head.next;
            current = current.next;
        }
        return current;

    }

    public static void main(String[] args) throws Exception{
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        ListNode l = TheKthNode.class.newInstance().FindKthToTail(listNode1, 6);
        System.out.println(l);
    }
}
