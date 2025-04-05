package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.BinaryTree;

import java.util.Stack;

/**
 * @Author zem
 * @Date 2023/10/5
 * 二叉树的镜像
 */
public class Code19 {
    public static void main(String[] args) {

        BinaryTree headNode = new BinaryTree(1);
        headNode.pLeft = new BinaryTree(2);
        headNode.pRight = new BinaryTree(3);

        headNode.pLeft.pLeft = new BinaryTree(4);
        headNode.pLeft.pRight = new BinaryTree(5);

        headNode.pLeft.pRight.pLeft = new BinaryTree(6);
        headNode.pLeft.pRight.pRight = new BinaryTree(7);

        new Code19().loopMirror(headNode);

        BinaryTree.preOrderRecursion(headNode, node -> System.out.print(node.value + "\t"));
    }

    public void MirrorRecursively(BinaryTree binaryTree) {
        if (binaryTree == null || (binaryTree.pLeft == null && binaryTree.pRight == null)) {
            return;
        }
        //交换左右节点
        BinaryTree pTemp = binaryTree.pLeft;
        binaryTree.pLeft = binaryTree.pRight;
        binaryTree.pRight = pTemp;

        if (binaryTree.pLeft != null) {
            MirrorRecursively(binaryTree.pLeft);
        }

        if (binaryTree.pRight != null) {
            MirrorRecursively(binaryTree.pRight);
        }

    }

    /**
     * 使用循环解决
     *
     * @param binaryTree
     */
    public void loopMirror(BinaryTree root) {
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                //交换左右子树
                BinaryTree temp = current.pLeft;
                current.pLeft = current.pRight;
                current.pRight = temp;
                //
                stack.push(current);
                //
                current = current.pLeft;

            } else {
                current = stack.pop().pRight;
            }
        }
    }
}
