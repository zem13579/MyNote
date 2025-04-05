package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.MyListNode;

import java.util.ArrayList;

/**
 * 在O(1)时间内删除链表节点 （直接提供要删除的节点）
 */
public class Code13 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        MyListNode myListNode = MyListNode.buildListNode(arrayList);

        MyListNode.printListNode(myListNode);
    }


    public void DeleteNode(MyListNode head, MyListNode toBeDeleteNode) {
        if (head == null || toBeDeleteNode == null) {
            return;
        }

        if (toBeDeleteNode.nextNode != null) {
            //要删除的节点不是尾节点
            MyListNode nextNode = toBeDeleteNode.nextNode;
            toBeDeleteNode.value = nextNode.value;
            toBeDeleteNode.nextNode = nextNode.nextNode;
        } else if (head == toBeDeleteNode) {
            //链表只有一个节点，删除头节点
            toBeDeleteNode = null;
            head = null;
        } else {
            //链表中有多个节点，删除尾节点
            MyListNode pNode = head;
            while (pNode.nextNode != toBeDeleteNode) {
                pNode = pNode.nextNode;
            }
            pNode.nextNode = null;
            toBeDeleteNode = null;
        }
    }
}
