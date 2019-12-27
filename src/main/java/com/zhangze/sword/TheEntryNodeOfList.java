package com.zhangze.sword;

/**
 * Created by zhangze on 2019/11/6
 * 23、链表中环的入口节点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 *
 */
public class TheEntryNodeOfList {

    /**
     * 两个指针，一个每次走一步一共走了X，另一个一次走两步，一共走2X
     * 设环长为N，则 X + N = 2X  所以，X == N，也就是每次走一步的那个走了一个环长
     * 将Fast变为链表头，慢的那个在继续走，Fast和slow都每次走一步，当他们在相寓的时候，就是环头
     */
    public ListNode entryNodeOfLoop(ListNode pHead)
    {
        if(pHead.next == null || pHead.next.next == null)
            return null;
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while(fast != null){
            if(fast == slow){
                fast = pHead;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return null;
        }
        int index = 1;
        ListNode node1 = pHead;
        ListNode node2 = pHead;
        while (true) {
            int a = index;
            while (a > 0) {
                node2 = node2.next;
                a--;
            }
            if (node1 == node2) {
                break;
            }
            node1 = node2;
            index++;
        }
        ListNode two = pHead;
        ListNode one = pHead;
        while (index > 0) {
            two = two.next;
            index--;
        }
        while (two != one) {
            two = two.next;
            one = one.next;
        }
        return one;

    }


    public static void main(String[] args) {

    }
}
