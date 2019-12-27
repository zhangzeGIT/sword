package com.zhangze.sword;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by zhangze on 2019/11/8
 * 35、复杂链表的复制
 *
 * 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class ListCopy {


    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 建立random链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return pCloneHead;

    }

    public void build(RandomListNode root, RandomListNode another) {
        if (root == null) return;
        if (root.next != null) {
            another.next = new RandomListNode(root.next.label);
            build(root.next, another.next);
        }
        if (root.random != null) {
            another.random = new RandomListNode(root.random.label);
            build(root.random, another.random);
        }
    }


    public static void main(String[] args) throws Exception{
        RandomListNode listNode = new RandomListNode(1);
        RandomListNode left1 = new RandomListNode(2);
        RandomListNode right = new RandomListNode(3);
        RandomListNode left2 = new RandomListNode(4);
        RandomListNode right1 = new RandomListNode(5);

        listNode.next = left1;
        left1.next= left2;
        listNode.random = right;
        right.random = right1;
        ListCopy.class.newInstance().Clone(listNode);
    }







}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
