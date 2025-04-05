package com.zem.algorithm.swordoffer2.aboutlinkedlist.circularlist;

import com.zem.algorithm.common.MyListNode;

/**
 * 面试题29：排序的循环链表
 */
public class InsertNode {
    public static void main(String[] args) {

    }

    public static MyListNode<Integer> insert(MyListNode<Integer> head, int investVal) {
        MyListNode<Integer> node = new MyListNode<>(investVal);
        if (head == null) {
            head = node;
            node.nextNode = node;
        } else if (head.nextNode == head) {
            head.nextNode = node;
            node.nextNode = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }

    private static void insertCore(MyListNode<Integer> head,
                                   MyListNode<Integer> node) {
        MyListNode<Integer> cur = head;
        MyListNode<Integer> next = head.nextNode;
        MyListNode<Integer> biggest = head;
        while (!(cur.value <= node.value && next.value >= node.value) &&
                next != head) {
            cur = next;
            next = next.nextNode;
            if (cur.value >= biggest.value) {
                biggest = cur;
            }
        }

        if (cur.value <= node.value && next.value >= node.value) {
            cur.nextNode = node;
            node.nextNode = next;
        } else {
            node.nextNode = biggest.nextNode;
            biggest.nextNode = node;
        }
    }
}
