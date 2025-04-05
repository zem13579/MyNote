package com.zem.algorithm.swordoffer2.aboutqueue;

import com.zem.algorithm.swordoffer2.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Describe 二叉树的右侧视图 (每层的最后一个点
 * @Author zem
 * @CreateDate 2024/3/26 0026 16:13
 */
public class RightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.offer(root);
        }
        List<Integer> result = new LinkedList<>();
        while (!queue1.isEmpty()) {
            TreeNode currentNode = queue1.poll();
            if (currentNode.getLeft() != null) {
                queue2.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue2.add(currentNode.getRight());
            }
            if (queue1.isEmpty()) {
                result.add(currentNode.getValue());
                Queue<TreeNode> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
            }
        }
        return result;
    }
}
