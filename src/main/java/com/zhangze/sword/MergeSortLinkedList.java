package com.zhangze.sword;

import java.util.List;

/**
 * Created by zhangze on 2019/11/7
 * 25、合并两个排序的链表
 *
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 */
public class MergeSortLinkedList {


    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                current.next = list2;
                return head.next;
            }
            if (list2 == null) {
                current.next = list1;
                return head.next;
            }
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        return head.next;
    }

    // 递归
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge1(list1, list2.next);
            return list2;
        }
    }


}
