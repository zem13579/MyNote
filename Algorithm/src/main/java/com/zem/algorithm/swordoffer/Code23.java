package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.BinaryTree;

/**
 * 层序遍历二叉树
 */
public class Code23 {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(8);
        root.pLeft = new BinaryTree(6);
        root.pLeft.pLeft = new BinaryTree(5);
        root.pLeft.pRight = new BinaryTree(7);

        root.pRight = new BinaryTree(10);
        root.pRight.pLeft = new BinaryTree(9);
        root.pRight.pRight = new BinaryTree(11);


    }

    public void levelOrderTraversal(BinaryTree root) {

    }

}
