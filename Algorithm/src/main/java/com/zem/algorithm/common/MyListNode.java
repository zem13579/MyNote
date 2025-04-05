package com.zem.algorithm.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zem
 */
public class MyListNode<T extends Comparable> {
    public T value;

    public MyListNode nextNode;


    public MyListNode() {
    }

    public MyListNode(T value) {
        this.value = value;
    }

    public MyListNode(T value, MyListNode nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public static void printListNode(MyListNode headNode) {
        MyListNode pNode = headNode;
        while (pNode != null) {
            System.out.print(pNode.value + "\t");
            pNode = pNode.nextNode;
        }
    }

    public static MyListNode buildListNode(List<? extends Comparable> values) {
        if (values == null || values.size() == 0) {
            return null;
        }
        MyListNode head = new MyListNode();
        MyListNode pLast = head;
        for (int i = 0; i < values.size(); i++) {
            MyListNode myListNode = new MyListNode();
            myListNode.value = values.get(i);
            pLast.nextNode = myListNode;
            pLast = myListNode;
        }
        return head.nextNode;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        MyListNode myListNode = buildListNode(arrayList);
        printListNode(myListNode);
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }
}
