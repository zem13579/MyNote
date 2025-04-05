package com.zem.algorithm.swordoffer2.aboutTree;

import com.zem.algorithm.swordoffer2.bean.TreeNode;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/3/27 0027 16:57
 */
public class MaxPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-9);
        root.setLeft(new TreeNode(4));
        root.setRight(new TreeNode(20));
        root.getRight().setLeft(new TreeNode(15));
        root.getRight().setRight(new TreeNode(7));
        root.getRight().getLeft().setLeft(new TreeNode(-3));
        System.out.println(maxPathSum(root));
    }

    /**
     * 节点值之和最大的路径 需要先求出左右子树中路径节点值之和的最大值（左右子树中的路径不经过当前节点），再求出经过根节点的路径节点值之和的最大值，最后对三者进行比较得到最大值
     *
     * @param root
     * @return
     */
    public static int maxPathSum(TreeNode root) {
        int[] maxSum = {Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }

    private static int dfs(TreeNode root, int[] maxSum) {
        if (root == null) {
            return 0;
        }
        int[] maxSumLeft = {Integer.MIN_VALUE};
        int left = Math.max(0, dfs(root.getLeft(), maxSumLeft));
        int[] maxSumRight = {Integer.MIN_VALUE};
        int right = Math.max(0, dfs(root.getRight(), maxSumRight));
        maxSum[0] = Math.max(maxSumLeft[0], maxSumRight[0]);
        maxSum[0] = Math.max(maxSum[0], root.getValue() + left + right);
        return root.getValue() + Math.max(left, right);
    }
}
