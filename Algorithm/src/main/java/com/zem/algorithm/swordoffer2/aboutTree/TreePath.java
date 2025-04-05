package com.zem.algorithm.swordoffer2.aboutTree;

import com.zem.algorithm.swordoffer2.bean.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Describe 从根节点到叶节点的路径数字之和
 * @Author zem
 * @CreateDate 2024/3/27 0027 15:33
 */
public class TreePath {

    public static void main(String[] args) {
        /**
         *
         * 3
         * 9 0
         * 51 2
         */
        TreeNode root = new TreeNode(3);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(0));
        root.getLeft().setLeft(new TreeNode(5));
        root.getLeft().setRight(new TreeNode(1));
        root.getRight().setLeft(new TreeNode(2));
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode node) {
        return dfs(node, 0);
    }

    private static int dfs(TreeNode node, Integer path) {
        if (node == null) {
            return 0;
        }
        path = path * 10 + node.getValue();
        if (node.getLeft() == null && node.getRight() == null) {
            return path;
        }
        return dfs(node.getLeft(), path) + dfs(node.getRight(), path);
    }

    /**
     * 面试题50：向下的路径节点值之和
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, sum, map, 0);
    }

    private int dfs(TreeNode root, int sum, Map<Integer, Integer> map, int path) {
        if (root == null) {
            return 0;
        }
        path += root.getValue();
        int count = map.getOrDefault(path - sum, 0);
        map.put(path, map.getOrDefault(path, 0) + 1);
        count += dfs(root.getLeft(), sum, map, path);
        count += dfs(root.getRight(), sum, map, path);
        map.put(path, map.get(path) - 1);
        return count;
    }


}
