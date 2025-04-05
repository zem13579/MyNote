package com.zem.algorithm.swordoffer2.aboutlinkedlist;

import com.zem.algorithm.common.MyListNode;

/**
 * 两个链表的第1个重合节点
 */
public class GetIntersectionNode {
    public MyListNode<Integer> getIntersectionNode(MyListNode<Integer> headA, MyListNode<Integer> headB) {
        int count1 = countList(headA);
        int count2 = countList(headB);
        int delta = Math.abs(count1 - count2);
        MyListNode<Integer> longer = count1 > count2 ? headA : headB;
        MyListNode<Integer> shorter = count1 > count2 ? headB : headA;
        MyListNode<Integer> p = longer;
        for (int i = 0; i < delta; i++) {
            p = p.nextNode;
        }
        MyListNode<Integer> q = shorter;
        while (p != q) {
            p = p.nextNode;
            q = q.nextNode;
        }
        return q;
    }

    private int countList(MyListNode<Integer> head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.nextNode;
        }
        return count;
    }
}
