package com.zem.algorithm.swordoffer2.aboutlinkedlist;

import com.zem.algorithm.common.MyListNode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AddTwoNumbers {
    public static void main(String[] args) {
        MyListNode number1 = MyListNode.buildListNode(
                Arrays.stream(new int[] {1, 2, 3}).boxed().collect(Collectors.toList()));
        MyListNode number2 = MyListNode.buildListNode(
                Arrays.stream(new int[] {4, 5, 6}).boxed().collect(Collectors.toList()));
        MyListNode myListNode = addTwoNumbers(number1, number2);
        MyListNode.printListNode(myListNode);
    }

    public static MyListNode<Integer> addTwoNumbers(MyListNode<Integer> head1,
                                                    MyListNode<Integer> head2) {
        head1 = ReverseList.reverseList(head1);
        head2 = ReverseList.reverseList(head2);
        MyListNode<Integer> reversedHead = addReversed(head1, head2);
        return ReverseList.reverseList(reversedHead);
    }

    private static MyListNode<Integer> addReversed(MyListNode<Integer> head1, MyListNode<Integer> head2) {
        MyListNode<Integer> dummy = new MyListNode<>(0);
        MyListNode<Integer> sumNode = dummy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.value) + (head2 == null ? 0 : head2.value) + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;
            MyListNode<Integer> newNode = new MyListNode<>(sum);

            sumNode.nextNode = newNode;
            sumNode = sumNode.nextNode;

            head1 = head1 == null ? null : head1.nextNode;
            head2 = head2 == null ? null : head2.nextNode;
        }

        if (carry > 0) {
            sumNode.nextNode = new MyListNode(carry);
        }

        return dummy.nextNode;
    }

}
