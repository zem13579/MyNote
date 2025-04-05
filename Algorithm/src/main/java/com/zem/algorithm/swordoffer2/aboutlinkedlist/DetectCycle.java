package com.zem.algorithm.swordoffer2.aboutlinkedlist;

import com.zem.algorithm.common.MyListNode;

/**
 * 链表中环的入口节点
 */
public class DetectCycle {
    public MyListNode<Integer> detectCycle(MyListNode<Integer> head) {
        MyListNode<Integer> inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }
        int loopCount = 1;
        for (MyListNode n = inLoop; n.nextNode != inLoop; n = n.nextNode) {
            loopCount++;
        }
        MyListNode<Integer> fast = head;
        for (int i = 0; i < loopCount; i++) {
            fast = fast.nextNode;
        }
        MyListNode<Integer> slow = head;
        while (fast != slow) {
            fast = fast.nextNode;
            slow = slow.nextNode;
        }
        return slow;
    }

    private MyListNode<Integer> getNodeInLoop(MyListNode<Integer> head) {
        if (head == null || head.nextNode == null) {
            return null;
        }
        MyListNode slow = head.nextNode;
        MyListNode fast = slow.nextNode;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return slow;
            }
            slow = slow.nextNode;
            fast = fast.nextNode;
            if (fast != null) {
                fast = fast.nextNode;
            }
        }
        return null;
    }
}
