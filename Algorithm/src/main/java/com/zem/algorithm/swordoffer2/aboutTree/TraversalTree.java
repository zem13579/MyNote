package com.zem.algorithm.swordoffer2.aboutTree;

import com.zem.algorithm.swordoffer2.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TraversalTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getLeft().getLeft().setRight(new TreeNode(6));
        System.out.println(afterorderTraversal(root));
        System.out.println(afterorderTraversal2(root));
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs(root, nodes);
        return nodes;
    }

    private static void dfs(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs(root.getLeft(), nodes);
            nodes.add(root.getValue());
            dfs(root.getRight(), nodes);
        }
    }

    /**
     * 迭代遍历，使用栈的思想
     * 中序遍历，
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            nodes.add(cur.getValue());
            cur = cur.getRight();
        }
        return nodes;
    }

    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs2(root, nodes);
        return nodes;
    }

    private static void dfs2(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            nodes.add(root.getValue());
            dfs2(root.getLeft(), nodes);
            dfs2(root.getRight(), nodes);
        }
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                nodes.add(cur.getValue());
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.pop();
            cur = cur.getRight();
        }
        return nodes;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> afterorderTraversal(TreeNode root) {
        List<Integer> nodes = new LinkedList<>();
        dfs3(root, nodes);
        return nodes;
    }

    private static void dfs3(TreeNode root, List<Integer> nodes) {
        if (root != null) {
            dfs3(root.getLeft(), nodes);
            dfs3(root.getRight(), nodes);
            nodes.add(root.getValue());
        }
    }

    public static List<Integer> afterorderTraversal2(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }
            cur = stack.peek();
            if (cur.getRight() != null && cur.getRight() != pre) {
                cur = cur.getRight();
            } else {
                stack.pop();
                result.add(cur.getValue());
                pre = cur; //todo 防止再次去右边
                cur = null; //todo
            }
        }
        return result;
    }

}
