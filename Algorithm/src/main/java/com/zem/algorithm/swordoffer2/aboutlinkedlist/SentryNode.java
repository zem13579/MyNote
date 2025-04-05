package com.zem.algorithm.swordoffer2.aboutlinkedlist;

import com.zem.algorithm.common.MyListNode;

/**
 * 哨兵节点
 */
public class SentryNode {
    public static void main(String[] args) {

    }

    /**
     * 在链表最后添加节点
     *
     * @param head
     * @param value
     * @return
     */
    public MyListNode append(MyListNode head, int value) {
        MyListNode newNode = new MyListNode(value);
        if (head == null) {
            return newNode;
        }
        MyListNode node = head;
        while (node.nextNode != null) {
            node = node.nextNode;
        }
        node.nextNode = newNode;
        return head;

    }

    public MyListNode append2(MyListNode head, int value) {
        MyListNode dummy = new MyListNode(0);
        dummy.nextNode = head;
        MyListNode<Integer> newNode = new MyListNode<>(value);
        MyListNode node = dummy;
        while (node.nextNode != null) {
            node = node.nextNode;
        }
        node.nextNode = newNode;
        return dummy.nextNode;
    }

    public static MyListNode<Integer> delete(MyListNode head, int value) {
        MyListNode<Integer> sentry = new MyListNode<>(value);
        sentry.nextNode = head;
        MyListNode<Integer> node = sentry;
        while (node.nextNode != null) {
            if (node.nextNode.value.equals(value)) {
                node.nextNode = node.nextNode.nextNode;
                break;
            }
        }
        return sentry.nextNode;
    }


}
