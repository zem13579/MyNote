package com.zem.algorithm.swordoffer;

import java.util.Stack;

/**
 * 从尾到头打印列表
 */
public class Code05 {

    private static class ListNode {
        public ListNode() {
        }

        public ListNode(int key) {
            this.key = key;
        }

        int key;
        ListNode pNext;
    }

    public static void main(String[] args) {
        ListNode pHead = new ListNode(0);
        ListNode pNode = pHead;
        for (int i = 1; i < 10; i++) {
            ListNode listNode = new ListNode(i);
            pNode.pNext = listNode;
            pNode = listNode;
        }


        PrintListReversingly_Iteratively(pHead);
        PrintListReversingly_Recursively(pHead);
    }

    private static void PrintListReversingly_Iteratively(ListNode pHead) {
        Stack<ListNode> stack = new Stack<>();
        ListNode pNode = pHead;
        while (pNode != null) {
            stack.push(pNode);
            pNode = pNode.pNext;
        }

        while (!stack.isEmpty()) {
            ListNode pop = stack.peek();
            System.out.println(pop.key + "\t");
            stack.pop();
        }

    }

    private static void PrintListReversingly_Recursively(ListNode pHead) {
        if (pHead != null) {
            if (pHead.pNext != null) {
                PrintListReversingly_Recursively(pHead.pNext);
            }
            System.out.println(pHead.key);
        }
    }

}
