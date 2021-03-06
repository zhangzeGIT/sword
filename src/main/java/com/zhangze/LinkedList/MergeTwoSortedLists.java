package com.zhangze.LinkedList;

/**
 * Created by zhangze on 2019/6/12
 *
 * 21、Merge Two Sorted Lists
 *
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode head=new ListNode(0);
        if (l1.val<l2.val){
            head=l1;
            l1=l1.next;
        }
        else {
            head=l2;
            l2=l2.next;
        }
        head.next=mergeTwoLists(l1,l2);
        return head;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode a = new ListNode(0);
        ListNode b = a;
        while(l1!=null || l2 != null) {
            if (l2 == null) {
                b.next = l1;
                l1 = l1.next;
                b = b.next;
            }else if (l1 == null) {
                b.next = l2;
                l2 = l2.next;
                b = b.next;
            }else {
                if (l1.val < l2.val){
                    b.next = l1;
                    l1 = l1.next;
                    b = b.next;
                }else {
                    b.next = l2;
                    l2 = l2.next;
                    b = b.next;
                }
            }
        }
        return a.next;
    }

    public static void main(String[] args) throws Exception{
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        MergeTwoSortedLists.class.newInstance().mergeTwoLists1(l1,l2);
    }
}
