package com.zhangze.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangze on 2019/8/8
 * 25、给定一个链表和一个整形k，每k个节点做一下翻转
 *
 * 例：
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 */
public class ReversNodeInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
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
        ListNode listNode = ReversNodeInKGroup.class.newInstance().reverseKGroup(node, 2);
        System.out.println(listNode);
    }





}
