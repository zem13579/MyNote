package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.MyListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 合并两个排序的链表,原递增，后递增
 */
public class Code17 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(7);
        MyListNode myListNode = MyListNode.buildListNode(integers);

        List<Integer> integers2 = new ArrayList<>();
        integers2.add(2);
        integers2.add(4);
        integers2.add(6);
        integers2.add(8);

        MyListNode myListNode2 = MyListNode.buildListNode(integers2);


        Code17 code17 = new Code17();

        MyListNode merge = code17.merge(myListNode, myListNode2);
        MyListNode.printListNode(merge);
    }

    MyListNode merge(MyListNode myListNode1, MyListNode myListNode2) {
        if (myListNode1 == null) {
            return myListNode2;
        } else if (myListNode2 == null) {
            return myListNode1;
        }

        MyListNode pMergedHead = null;

        if (myListNode1.value.compareTo(myListNode2.value) < 0) {
            pMergedHead = myListNode1;
            pMergedHead.nextNode = merge(myListNode1.nextNode, myListNode2);
        } else {
            pMergedHead = myListNode2;
            pMergedHead.nextNode = merge(myListNode1, myListNode2.nextNode);
        }

        return pMergedHead;
    }


}
