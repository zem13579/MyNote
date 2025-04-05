package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.MyListNode;

import java.util.ArrayDeque;

/**
 * 两个链表的第一个公共结点
 * 三种思路，
 * 1 逐个对比
 * 2 使用栈，达到逆序对比
 * 3 使用双指针法，达到节省空间的办法
 */
public class Code37 {
    public static void main(String[] args) {
        /**
         * 12  345
         * 67
         */
        MyListNode<Integer> head1 = new MyListNode<>(1);
        head1.nextNode = new MyListNode(2);
        head1.nextNode.nextNode = new MyListNode(3);
        head1.nextNode.nextNode.nextNode = new MyListNode(4);
        head1.nextNode.nextNode.nextNode.nextNode = new MyListNode(5);


        MyListNode<Integer> head2 = new MyListNode<>(6);
        head2.nextNode = new MyListNode<Integer>(7);
        head2.nextNode.nextNode = head1.nextNode.nextNode;

        Code37 code37 = new Code37();
        MyListNode<Integer> firstCommonNode = code37.findFirstCommonNode3(head1, head2);
        System.out.println(firstCommonNode == null ? "none" : firstCommonNode);
    }

    public MyListNode<Integer> findFirstCommonNode(MyListNode<Integer> headNode1, MyListNode headNode2) {
        MyListNode p1 = headNode1;
        MyListNode p2 = headNode2;

        while (p1 != null) {
            while (p2 != null) {

                if (p1 == p2) {
                    return p1;
                }
                p2 = p2.nextNode;
            }
            p1 = p1.nextNode;
            p2 = headNode2;
        }
        return null;
    }


    /**
     * 使用栈
     *
     * @param headNode1
     * @param headNode2
     * @return
     */
    public MyListNode<Integer> findFirstCommonNode2(MyListNode<Integer> headNode1, MyListNode headNode2) {
        ArrayDeque<MyListNode> stack1 = new ArrayDeque<>();
        ArrayDeque<MyListNode> stack2 = new ArrayDeque<>();
        MyListNode p1 = headNode1;
        MyListNode p2 = headNode2;
        while (p1 != null) {
            stack1.push(p1);
            p1 = p1.nextNode;
        }
        while (p2 != null) {
            stack2.push(p2);
            p2 = p2.nextNode;
        }

        MyListNode commonNode = null;
        while (stack1.peek().equals(stack2.peek())) {
            commonNode = stack1.remove();
            stack2.remove();
        }

        return commonNode;

    }

    /**
     * 双指针法，将长度较长的指针 先挪动几部
     *
     * @param headNode1
     * @param headNode2
     * @return
     */
    public MyListNode<Integer> findFirstCommonNode3(MyListNode<Integer> headNode1, MyListNode headNode2) {
        int length1 = 0;
        int length2 = 0;
        MyListNode p1 = headNode1;
        MyListNode p2 = headNode2;
        while (p1 != null) {
            length1++;
            p1 = p1.nextNode;
        }

        while (p2 != null) {
            length2++;
            p2 = p2.nextNode;
        }

        int longerListLength = 0;
        int smallerListLength = 0;
        MyListNode longerList = null;
        MyListNode smallerList = null;
        if (length1 > length2) {
            longerListLength = length1;
            smallerListLength = length2;
            longerList = headNode1;
            smallerList = headNode2;
        }
        int diff = longerListLength - smallerListLength;

        //提前走几步
        for (int i = 0; i < diff; i++) {
            headNode1 = headNode1.nextNode;
        }
        while (headNode1 != null && headNode2 != null && headNode1 != headNode2) {
            headNode1 = headNode1.nextNode;
            headNode2 = headNode2.nextNode;
        }

        return headNode1;

    }
}
