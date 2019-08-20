package com.zhangze.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangze on 2019/7/5
 *
 * 23、合并K个有序的链表，返回一个
 *
 * 例子：
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode resultNode = lists[0];
        for (int i = 1;i < lists.length;i++) {
            ListNode currentNode = lists[i];
            resultNode = sort(resultNode, currentNode);
        }
        return resultNode;
    }
    private static ListNode sort(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        } else if (second == null) return first;
        else {
            ListNode result = new ListNode(0);
            ListNode aaa = result;
            while(first != null || second != null) {
                if (first == null) {
                    aaa.next = second;
                    break;
                }else if (second == null) {
                    aaa.next = first;
                    break;
                }else {
                    if (first.val < second.val) {
                        aaa.next  = first;
                        aaa = aaa.next;
                        first = first.next;
                    }else {
                        aaa.next  = second;
                        aaa = aaa.next;
                        second = second.next;
                    }
                }
            }
            return result.next;
        }
    }

    public static void main(String[] args) throws Exception{
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode7 = new ListNode(2);
        ListNode listNode8 = new ListNode(6);
        listNode7.next = listNode8;
        List<ListNode> listNodeList = new ArrayList<>();
        listNodeList.add(listNode1);
        listNodeList.add(listNode4);
        listNodeList.add(listNode7);
        ListNode[] listNodes = {listNode1,listNode4,listNode7};
        ListNode l = MergeKSortedLists.class.newInstance().mergeKLists(listNodes);
        System.out.println(l);
    }
}
