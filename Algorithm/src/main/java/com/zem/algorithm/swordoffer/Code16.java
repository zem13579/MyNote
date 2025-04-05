package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.MyListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 反转列表
 */
public class Code16 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        MyListNode myListNode = MyListNode.buildListNode(integers);
        Code16 code16 = new Code16();
        MyListNode myListNode1 = code16.recursionReveseList(myListNode);
        //正向例子
        MyListNode.printListNode(myListNode1);
        //反向
//        code16.ReverseLIist(null);
        //
        code16.recursionReveseList(new MyListNode(1));
    }

    MyListNode ReverseLIist(MyListNode pHead) {
        MyListNode pNext = null;
        MyListNode pNode = pHead;
        MyListNode pPre = null;
        MyListNode pReversedHead = null;
        while (pNode != null) {
            pNext = pNode.nextNode;
            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.nextNode = pPre;
            pPre = pNode;
            pNode = pNext;
        }
        return pReversedHead;
    }

    /**
     * 使用递归方法
     *
     * @param phead
     * @return
     */
    MyListNode recursionReveseList(MyListNode phead) {
        if (phead == null) return null;
        MyListNode reversedHead = null;
        return fun(phead, null);
    }

    private MyListNode fun(MyListNode pNode, MyListNode pPreNode) {
        if (pNode == null) {
            return pPreNode;
        }
        MyListNode nextNode = pNode.nextNode;
        pNode.nextNode = pPreNode;
        return fun(nextNode, pNode);
    }

}
