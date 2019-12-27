package com.zhangze.sword;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by zhangze on 2019/10/24
 * 6、从尾到头打印链表
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintLinkedList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

    // 栈的解题方式
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}