package com.zem.algorithm.swordoffer2.aboutqueue;

import com.zem.algorithm.swordoffer2.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Describe 二叉树最低层最左边的值
 * @Author zem
 * @CreateDate 2024/3/26 0026 16:06
 */
public class FindBottomLeftValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(2));
        root.setLeft(new TreeNode(3));
        root.getRight().setLeft(new TreeNode(4));
        System.out.println(findBottomLeftValue(root));
    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.offer(root);
        }
        Integer bottomLeft = root.getValue();
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
                Queue<TreeNode> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                if (!queue1.isEmpty()) {
                    bottomLeft = queue1.peek().getValue();
                }
            }
        }
        return bottomLeft;
    }
}
