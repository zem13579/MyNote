package com.zem.algorithm.huawei2024.ex1.no3605ex1no67;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Queue<TreeNode> nodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
        for (int i = 0; i < num; i++) {
            int value = sc.nextInt();
            nodes.add(new TreeNode(value));
        }

        while (nodes.size() != 1) {
            TreeNode first = nodes.poll();
            TreeNode second = nodes.poll();
            //二叉树节点中，左节点权值小于等于右节点权值，根节点权值为左右节点权值之和。
            int sum = first.value + second.value;
            TreeNode treeNode = new TreeNode(sum);
            if (first.value < second.value) {
                treeNode.left = first;
                treeNode.right = second;
            } else {
                // 当左右节点权值相同时，左子树高度高度小于等于右子树
                if (TreeNode.height(first) <= TreeNode.height(second)) {
                    treeNode.left = first;
                    treeNode.right = second;
                } else {
                    treeNode.left = second;
                    treeNode.right = first;
                }
            }
            nodes.add(treeNode);
        }
        TreeNode root = nodes.poll();
        //中序遍历哈夫曼树
        TreeNode.inOrderSer(root);
        TreeNode.trverseResult.forEach(x -> System.out.print(x + " "));

    }

    static class TreeNode {
        static List<Integer> trverseResult = new ArrayList<>();
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public static void inOrderSer(TreeNode node) {
            if (node == null) {
                return;
            }
            inOrderSer(node.left);
            trverseResult.add(node.value);
            inOrderSer(node.right);
        }

        public static int height(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(height(node.left), height(node.right)) + 1;
        }
    }
}
