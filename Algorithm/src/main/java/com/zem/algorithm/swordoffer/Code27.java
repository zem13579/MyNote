package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.BinaryTree;

/**
 * @Author zem
 * @Date 2023/10/21
 */
public class Code27 {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.pLeft = new BinaryTree(6);
        root.pRight = new BinaryTree(14);

        root.pLeft.pLeft = new BinaryTree(4);
        root.pLeft.pRight = new BinaryTree(8);

        root.pRight.pLeft = new BinaryTree(12);
        root.pRight.pRight = new BinaryTree(16);

        Code27 code27 = new Code27();
        code27.convert(root);

    }

    private BinaryTree lastNodeinList;

    public BinaryTree convert(BinaryTree root) {
        lastNodeinList = null;
        convertNode(root);
        //我们需要返回头节点
        BinaryTree headOfList = lastNodeinList;
        while (headOfList != null && headOfList.pLeft != null) {
            System.out.println(headOfList.value + "\t");
            headOfList = headOfList.pLeft;

        }
        return headOfList;

    }

    private void convertNode(BinaryTree node) {
        if (node == null) {
            return;
        }
        BinaryTree current_node = node;
        if (current_node.pLeft != null) {
            convertNode(current_node.pLeft);
        }

        current_node.pLeft = lastNodeinList;

        if (lastNodeinList != null) {
            lastNodeinList.pRight = current_node;
        }

        lastNodeinList = current_node;

        if (current_node.pRight != null) {
            convertNode(current_node.pRight);
        }

    }
}
