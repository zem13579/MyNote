package com.zem.algorithm.swordoffer2.aboutlinkedlist;

import com.zem.algorithm.common.MyListNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IsPalindrome {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 1};
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        MyListNode myListNode = MyListNode.buildListNode(list);
        System.out.println(isPalindrome(myListNode));
    }

    public static boolean isPalindrome(MyListNode<Integer> head) {
        if (head == null || head.nextNode == null) {
            return true;
        }
        MyListNode slow = head;
        MyListNode fast = head.nextNode;
        while (fast.nextNode != null && fast.nextNode.nextNode != null) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
        }
        System.out.println(fast);
        System.out.println(slow);
        MyListNode secondHalf = slow.nextNode;
        if (fast.nextNode != null) {
            secondHalf = slow.nextNode.nextNode;
        }
        slow.nextNode = null;
        return equals(secondHalf, ReverseList.reverseList(head));
    }

    private static boolean equals(MyListNode head1, MyListNode<Integer> head2) {
        while (head1 != null && head2 != null) {
            if (head1.value != head2.value) {
                return false;
            }
            head1 = head1.nextNode;
            head2 = head2.nextNode;
        }
        return head1 == null && head2 == null;
    }
}
