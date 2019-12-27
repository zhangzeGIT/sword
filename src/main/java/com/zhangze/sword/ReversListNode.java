package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/6
 * 24、反转链表
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 */
public class ReversListNode {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = null;
        ListNode second = head;
        while (true) {
            ListNode next = second.next;
            revers(first, second);
            first = second;
            if (next == null) {
                return first;
            }
            second = next;
        }
    }

    public void revers(ListNode first, ListNode second) {
        second.next = first;
    }

    public ListNode ts(ListNode head) {
        ListNode pReversedHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pReversedHead;
    }


    public static void main(String[] args) throws Exception{
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        ListNode listNode3 = ReversListNode.class.newInstance().ReverseList(listNode);
        System.out.println(listNode3);
    }


}
