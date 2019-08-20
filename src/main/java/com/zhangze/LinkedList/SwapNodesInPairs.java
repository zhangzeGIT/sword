package com.zhangze.LinkedList;

/**
 * Created by zhangze on 2019/7/8
 * 24、交换相邻链表中的值
 *
 * Example:
 *
 * Given 1->2->3->4->5->6, you should return the list as 2->1->4->3->6->5.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;


        ListNode newHead = head.next;
        ListNode node1 = null;
        ListNode node2 = null;

        ListNode currentNode = head;

        while (currentNode != null && currentNode.next != null) {
            node2 = currentNode.next.next;
            currentNode.next.next = null;
            ListNode next = currentNode.next;
            currentNode.next = null;
            if (node1 != null) {
                node1.next = next;
            }
            next.next = currentNode;
            currentNode.next = node2;
            node1 = currentNode;
            currentNode = node2;
        }

        return newHead;
    }

    public static void main(String[] args) throws Exception{
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node6 = SwapNodesInPairs.class.newInstance().swapPairs(node);
        System.out.println(node6);
    }















}
