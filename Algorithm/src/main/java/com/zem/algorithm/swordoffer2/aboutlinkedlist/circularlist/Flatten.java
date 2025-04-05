package com.zem.algorithm.swordoffer2.aboutlinkedlist.circularlist;

/**
 * 展平多级双向链表
 */
public class Flatten {
    public static void main(String[] args) {
        SpecialNode head = new SpecialNode(1);

        head.next = new SpecialNode(2);
        head.next.prev = head;

        head.next.next = new SpecialNode(3);
        head.next.next.prev = head.next;

        head.next.next.next = new SpecialNode(4);
        head.next.next.next.prev = head.next.next;

        SpecialNode head2 = new SpecialNode(5);

        head2.next = new SpecialNode(6);
        head2.next.prev = head2;

        head2.next.next = new SpecialNode(7);
        head2.next.next.prev = head2.next;

        SpecialNode head3 = new SpecialNode(8);
        head3.next = new SpecialNode(9);
        head3.next.prev = head3;

        head.next.child = head2;

        head2.next.child = head3;

        flatten(head);

        SpecialNode p = head;
        while (p != null) {
            System.out.println(p.value);
            p = p.next;
        }


    }

    private static SpecialNode flatten(SpecialNode head) {
        flattenGetTail(head);
        return head;
    }

    private static SpecialNode flattenGetTail(SpecialNode head) {
        SpecialNode node = head;
        SpecialNode tail = null;
        while (node != null) {
            //摘出来node，防止断链
            SpecialNode next = node.next;
            if (node.child != null) {
                SpecialNode child = node.child;
                SpecialNode childTail = flattenGetTail(child);

                node.child = null;
                node.next = child;
                child.prev = node;

                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
                tail = childTail;
            } else {
                tail = node;
            }
            node = node.next;
        }
        return tail;
    }

    public static class SpecialNode {
        private Integer value;

        public SpecialNode prev;
        public SpecialNode next;
        public SpecialNode child;

        public SpecialNode(Integer value) {
            this.value = value;
        }

        public SpecialNode() {
        }
    }
}
