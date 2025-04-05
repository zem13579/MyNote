package com.zem.algorithm.swordoffer2.aboutTree;

import com.zem.algorithm.swordoffer2.bean.TreeNode;


/**
 * @Describe 将二叉树序列化与反序列化
 * @Author zem
 * @CreateDate 2024/3/27 0027 10:28
 */
public class TreeSerialize {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode lv1N1 = new TreeNode(6);
        TreeNode lv1N2 = new TreeNode(6);
        root.setLeft(lv1N1);
        root.setRight(lv1N2);

        lv1N1.setLeft(new TreeNode(6));
        lv1N1.setRight(new TreeNode(6));

        System.out.println(serialize(root));

        TreeNode tree = deserialize("6,6,6,#,#,6,#,#,6,#,#");
    }

    public static String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftstr = serialize(root.getLeft());
        String rightstr = serialize(root.getRight());
        return root.getValue() + "," + leftstr + "," + rightstr;
    }

    public static TreeNode deserialize(String str) {
        String[] nodeStrs = str.split(",");
        int[] i = {0};
        return dfs(nodeStrs, i);
    }

    private static TreeNode dfs(String[] nodeStrs, int[] i) {
        String str = nodeStrs[i[0]];
        i[0]++;
        if ("#".equals(str)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str));
        root.setLeft(dfs(nodeStrs, i));
        root.setRight(dfs(nodeStrs, i));
        return root;
    }

}
