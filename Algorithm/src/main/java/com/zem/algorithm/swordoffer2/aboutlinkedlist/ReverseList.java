package com.zem.algorithm.swordoffer2.aboutlinkedlist;

import com.zem.algorithm.common.MyListNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 反转列表
 */
public class ReverseList {
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5};
        List<Integer> list1 = Arrays.stream(list).boxed().collect(Collectors.toList());
        MyListNode myListNode = MyListNode.buildListNode(list1);
        MyListNode reversed = reverseList(myListNode);
        MyListNode.printListNode(reversed);

    }

    public static MyListNode<Integer> reverseList(MyListNode<Integer> head) {
        MyListNode<Integer> prev = null;
        MyListNode<Integer> cur = head;
        while (cur != null) {
            MyListNode nextNode = cur.nextNode;
            cur.nextNode = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }


}
