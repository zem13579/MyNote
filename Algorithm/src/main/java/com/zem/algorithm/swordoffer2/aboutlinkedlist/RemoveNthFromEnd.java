package com.zem.algorithm.swordoffer2.aboutlinkedlist;

import com.zem.algorithm.common.MyListNode;


/**
 * 移除导数第k个元素2
 */
public class RemoveNthFromEnd {
    public MyListNode<Integer> removeNthFromEnd(MyListNode<Integer> head, int n) {
        MyListNode<Integer> dummy = new MyListNode<>(0);
        dummy.nextNode = head;
        MyListNode<Integer> front = head, back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.nextNode;
        }
        while (front != null) {
            front = front.nextNode;
            back = back.nextNode;
        }
        back.nextNode = back.nextNode.nextNode;
        return dummy.nextNode;
    }
}
