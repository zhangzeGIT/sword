package com.zhangze.LinkedList;

/**
 * Created by zhangze on 2019/10/9
 * 61、Rotate List：旋转列表
 * 给一个Linked List ,从列表的右边开始旋转，转动k次
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 *
 * Example 2:
 *
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int listNodeLength = 1;
        ListNode jj = head;
        while (jj.next != null) {
            listNodeLength++;
            jj = jj.next;
        }
        while (k >= listNodeLength) {
            k = k - listNodeLength;
        }
        if (k == 0) {
            return head;
        }
        ListNode newHead = null;
        ListNode current = head;
        ListNode preHead = null;
        for (int i = 0; i < listNodeLength - k ; i++) {
            preHead = current;
            current = current.next;
            newHead = current;
        }
        preHead.next = null;
        jj.next = head;
        return newHead;
    }

    /**
     * discuss
     */
    public ListNode rotateRight1(ListNode head, int n) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)
            fast=fast.next;

        for (int j=i-n%i;j>0;j--)
            slow=slow.next;

        fast.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;
    }


    public static void main(String[] args) throws Exception{
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        RotateList.class.newInstance().rotateRight(listNode1, 2);
    }

}
