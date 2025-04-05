package com.zem.algorithm.swordoffer2.aboutTree;

import com.zem.algorithm.swordoffer2.bean.TreeNode;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/3/27 0027 9:33
 */
public class PruneTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode lv1N1 = new TreeNode(0);
        TreeNode lv1N2 = new TreeNode(0);
        root.setLeft(lv1N1);
        root.setRight(lv1N2);

        lv1N1.setLeft(new TreeNode(0));
        lv1N1.setRight(new TreeNode(0));

        lv1N2.setLeft(new TreeNode(0));
        lv1N2.setRight(new TreeNode(1));

        TreeNode newRoot = pruneTree(root);
    }


    public static TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        root.setLeft(pruneTree(root.getLeft()));
        root.setRight(pruneTree(root.getRight()));
        if (root.getRight() == null && root.getLeft() == null && root.getValue() == 0) {
            return null;
        }
        return root;
    }
}
