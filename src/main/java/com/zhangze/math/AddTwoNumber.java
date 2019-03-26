package com.zhangze.math;

/**
 * Created by zhangze on 2019/3/22
 * 给两个单项链表，非负，数字以相反顺序存储，将这两个数相加，并返回链表形式
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode listNode1, ListNode listNode2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = listNode1;
        ListNode q = listNode2;
        ListNode curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = p == null?0:p.val;
            int y = q == null?0:q.val;
            int sum = carry + x +y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (q!= null) q = q.next;
            if (p!=null) p=p.next;

        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}