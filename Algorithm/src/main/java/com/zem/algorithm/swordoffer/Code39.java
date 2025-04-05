package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.BinaryTree;

/**
 * @Describe 二叉树的深度
 * @Author zem
 * @CreateDate 2023/11/23 0023
 */
public class Code39 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.pLeft = new BinaryTree(2);
        binaryTree.pRight = new BinaryTree(3);

        binaryTree.pLeft.pLeft = new BinaryTree(4);

        Code39 code39 = new Code39();
        System.out.println(code39.treeDepth(binaryTree));
    }

    public int treeDepth(BinaryTree tree) {
        if (tree == null) {
            return 0;
        }
        int leftDepth = treeDepth(tree.pLeft);
        int rightDepth = treeDepth(tree.pRight);
        return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
    }
}
