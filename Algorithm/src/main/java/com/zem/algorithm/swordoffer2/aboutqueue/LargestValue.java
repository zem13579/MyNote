package com.zem.algorithm.swordoffer2.aboutqueue;

import com.zem.algorithm.swordoffer2.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Describe 二叉树中每层的最大值
 * @Author zem
 * @CreateDate 2024/3/26 0026 15:35
 */
public class LargestValue {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setRight(new TreeNode(2));
        root.setLeft(new TreeNode(3));
        root.getRight().setLeft(new TreeNode(4));
        System.out.println(largestValues2(root));
    }

    public static List<Integer> largestValues(TreeNode root) {
        int current = 0;
        int next = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        if (root != null) {
            queue.offer(root);
            current++;
        }
        List<Integer> result = new LinkedList<>();
        Integer max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            current--;
            max = Math.max(max, currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue.offer(currentNode.getLeft());
                next++;
            }
            if (currentNode.getRight() != null) {
                queue.offer(currentNode.getRight());
                next++;
            }
            if (current == 0) {
                result.add(max);
                max = Integer.MIN_VALUE;
                current = next;
                next = 0;
            }
        }
        return result;
    }

    /**
     * 方法2 使用双队列进行层序遍历 }
     *
     * @param root
     * @return
     */
    public static List<Integer> largestValues2(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) {
            queue1.offer(root);
        }
        int max = Integer.MIN_VALUE;
        List<Integer> result = new LinkedList<>();
        while (!queue1.isEmpty()) {
            TreeNode currentNode = queue1.poll();
            max = Math.max(max, currentNode.getValue());
            if (currentNode.getLeft() != null) {
                queue2.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue2.add(currentNode.getRight());
            }
            if (queue1.isEmpty()) {
                result.add(max);
                max = Integer.MIN_VALUE;
                Queue<TreeNode> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
            }
        }
        return result;
    }
}
