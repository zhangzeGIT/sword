package com.zhangze.sword;

import java.util.Stack;

/**
 * Created by zhangze on 2019/11/26
 * 52、两个链表的第一个公共结点
 *
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class LinkedListFirstNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) return null;
        if (pHead2 == null) return null;
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode listNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()) {
            listNode = stack1.pop();
            stack2.pop();
        }
        return listNode;
    }









    public static void main(String[] args) {

    }
}
