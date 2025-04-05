package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.MyListNode;

/**
 * 链表中倒数第k个结点
 */
public class Code15 {
    public static void main(String[] args) {

    }

    public MyListNode findKthToFail(MyListNode headNode, int k) {
        if (headNode == null || k == 0) {
            return null;
        }
        MyListNode pAhead = headNode;
        MyListNode pBehind = null;
        for (int i = 0; i < k; i++) {
            if (pAhead.nextNode != null) {
                pAhead = pAhead.nextNode;
            } else {
                return null;
            }
        }
        pBehind = headNode;
        while (headNode.nextNode != null) {
            headNode = headNode.nextNode;
            pBehind = pBehind.nextNode;
        }
        return pBehind;
    }

    /**
     * 求链表的中间结点
     * 如果链表中结点总数为奇数，返回中间结点；
     * 如果结点总数是偶数，返回中间两个结点中前一个
     *
     * @param head
     * @return
     */
    public MyListNode isOddOrEvenList(MyListNode head) {
        return null;
    }
}
