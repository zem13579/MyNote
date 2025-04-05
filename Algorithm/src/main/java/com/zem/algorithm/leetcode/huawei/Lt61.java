package com.zem.algorithm.leetcode.huawei;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Lt61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            n++;
        }

        int add = n - k % n;

        if(add ==n){
            return head;
        }

        p.next = head;

        while (add > 0){
            p = p.next;
            add--;
        }

        ListNode ret = p.next;
        p.next = null;
        return ret;





    }
}
