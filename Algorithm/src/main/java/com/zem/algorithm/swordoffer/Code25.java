package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.BinaryTree;

import java.util.Stack;

/**
 * @Author zem
 * @Date 2023/10/21
 * 二叉树中和为某一值的路径
 */
public class Code25 {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.pLeft = new BinaryTree(5);
        root.pRight = new BinaryTree(12);
        root.pLeft.pLeft = new BinaryTree(4);
        root.pLeft.pRight = new BinaryTree(7);
        Code25 code25 = new Code25();
        code25.findPath(root, 22);
    }

    void findPath(BinaryTree root, int expectedSum) {
        if (root == null) {
            return;
        }
        Stack<BinaryTree> path = new Stack<>();
        int currentSum = 0;
        findPath(root, expectedSum, path, currentSum);

    }

    private void findPath(BinaryTree root, int expectedSum, Stack<BinaryTree> path, int currentSum) {
        currentSum += root.value;
        path.push(root);
        boolean isLeaf = root.pLeft == null && root.pRight == null;
        if (currentSum == expectedSum && isLeaf) {
            System.out.println(path);
        }
        if (root.pRight != null) {
            findPath(root.pRight, expectedSum, path, currentSum);
        }
        if (root.pLeft != null) {
            findPath(root.pLeft, expectedSum, path, currentSum);
        }
        currentSum -= root.value;
        path.pop();
    }
}
