package com.zem.algorithm.swordoffer2.aboutlinkedlist;

import com.zem.algorithm.common.MyListNode;

public class ReOrderList {
    public static void main(String[] args) {

    }

    public void reorderList(MyListNode<Integer> head) {
        MyListNode<Integer> dummy = new MyListNode<>(0);
        dummy.nextNode = head;
        MyListNode<Integer> fast = dummy;
        MyListNode<Integer> slow = dummy;
        //快慢指针将链表分为两部分
        while (fast != null && slow != null) {
            fast = fast.nextNode;
            slow = slow.nextNode;
            if (fast.nextNode != null) {
                fast = fast.nextNode;
            }
        }
        MyListNode temp = slow.nextNode;
        slow.nextNode = null;
        link(head, ReverseList.reverseList(temp), dummy);

    }

    private void link(MyListNode<Integer> node1, MyListNode node2, MyListNode<Integer> head) {
        MyListNode<Integer> prev = head;
        while (node1 != null && node2 != null) {
            MyListNode temp = node1.nextNode;

            prev.nextNode = node1;
            node1.nextNode = node2;
            prev = node2;

            node1 = temp;
            node2 = node2.nextNode;
        }
        if (node1 != null) {
            prev.nextNode = node1;
        }
    }
}
