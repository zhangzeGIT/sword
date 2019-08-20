package com.zhangze.LinkedList;


/**
 * Created by zhangze on 2019/8/5
 * 反转链表，并返回链表头
 */
public class ReversalLinkedList {


    public ListNode revers(ListNode head) {
        ListNode newHead = null;
        ListNode currentNode;
        while (head != null) {
            currentNode = head;
            head = head.next;
            currentNode.next = null;
            if (newHead == null) {
                newHead = currentNode;
            } else {
                currentNode.next = newHead;
                newHead = currentNode;
            }
        }

        return newHead;
    }

    public static void main(String[] args) throws Exception {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        ListNode newHead = ReversalLinkedList.class.newInstance().revers(listNode1);

        while (listNode1 != null) {
            if (listNode1.val == 2) {
                break;
            }
            listNode1 = listNode1.next;
        }

//        System.out.println(newHead);
    }

}
