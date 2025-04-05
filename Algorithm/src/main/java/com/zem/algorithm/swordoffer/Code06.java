package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.BinaryTree;

import java.util.Arrays;

/**
 * 重建二叉树
 */
public class Code06 {

    public static void main(String[] args) {
        int[] preOrderArr = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] InOrderArr = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree root = constructCore(preOrderArr, InOrderArr);
        BinaryTree.inOrderRecursion(root, node -> System.out.println(node.value));
    }


    private static BinaryTree constructCore(int[] preOrderArr, int[] inOrderArr) {
        int rootValue = preOrderArr[0];
        BinaryTree rootNode = new BinaryTree(rootValue);
        int inOrderRootIndex = -1;
        for (int i = 0; i < inOrderArr.length; i++) {
            if (inOrderArr[i] == rootValue) {
                inOrderRootIndex = i;
                //取第一个匹配的
                break;
            }
        }
        if (inOrderRootIndex == -1) {
            throw new RuntimeException("非法数组,不包含节点");
        }
        if (inOrderRootIndex != 0) {
            int[] newPreOrderArr = Arrays.copyOfRange(preOrderArr, 1, inOrderRootIndex + 1);
            int[] newInOrderArr = Arrays.copyOfRange(inOrderArr, 0, inOrderRootIndex - 1 + 1);
            rootNode.pLeft = constructCore(newPreOrderArr, newInOrderArr);
        }
        if (inOrderRootIndex != inOrderArr.length - 1) {
            int[] newPreOrderArr = Arrays.copyOfRange(preOrderArr, inOrderRootIndex + 1, preOrderArr.length);
            int[] newInOrderArr = Arrays.copyOfRange(inOrderArr, inOrderRootIndex + 1, inOrderArr.length);
            rootNode.pRight = constructCore(newPreOrderArr, newInOrderArr);
        }
        return rootNode;
    }
}
