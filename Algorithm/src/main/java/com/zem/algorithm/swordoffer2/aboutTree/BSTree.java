package com.zem.algorithm.swordoffer2.aboutTree;

import com.zem.algorithm.swordoffer2.bean.TreeNode;

import java.util.Iterator;
import java.util.Stack;

/**
 * @Describe 二叉搜索树
 * @Author zem
 * @CreateDate 2024/3/27 0027 17:27
 */
public class BSTree {

    public static void main(String[] args) {
        //        new Test2().test();
        //        new Test3().test();
//        new Test4().test();
        new Test5().test();
    }


    static class Test2 {

        public void test() {
            TreeNode root = new TreeNode(4);
            root.setLeft(new TreeNode(2));
            root.setRight(new TreeNode(5));
            root.getLeft().setLeft(new TreeNode(1));
            root.getLeft().setRight(new TreeNode(3));
            root.getRight().setRight(new TreeNode(6));

            System.out.println(increaseBST(root));
        }
    }

    static class Test3 {

        public void test() {
            TreeNode root = new TreeNode(4);
            root.setLeft(new TreeNode(2));
            root.setRight(new TreeNode(6));
            root.getLeft().setLeft(new TreeNode(1));
            root.getLeft().setRight(new TreeNode(3));
            root.getRight().setLeft(new TreeNode(5));
            root.getRight().setRight(new TreeNode(7));
            System.out.println(convertBST(root));
        }
    }

    static class Test4 {

        public void test() {
            TreeNode root = new TreeNode(4);
            root.setLeft(new TreeNode(2));
            root.setRight(new TreeNode(6));
            root.getLeft().setLeft(new TreeNode(1));
            root.getLeft().setRight(new TreeNode(3));
            root.getRight().setLeft(new TreeNode(5));
            root.getRight().setRight(new TreeNode(7));
            BSTIterator bstIterator = new BSTIterator(root, true);
            while (bstIterator.hasNext()) {
                System.out.println(bstIterator.next());
            }
        }
    }


    static class Test5 {

        public void test() {
            TreeNode root = new TreeNode(4);
            root.setLeft(new TreeNode(2));
            root.setRight(new TreeNode(6));
            root.getLeft().setLeft(new TreeNode(1));
            root.getLeft().setRight(new TreeNode(3));
            root.getRight().setLeft(new TreeNode(5));
            root.getRight().setRight(new TreeNode(7));
            System.out.println(findTarget(root, 89));
        }
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.getValue() == val) {
                break;
            }
            if (cur.getValue() > val) {
                cur = cur.getLeft();
            } else {
                cur = cur.getRight();
            }
        }
        return cur;
    }

    public static TreeNode increaseBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }

            cur = stack.pop();
            if (prev == null) {
                //第一个节点
                first = cur;
            } else {
                prev.setRight(cur);
            }

            prev = cur;
            cur.setLeft(null);
            cur = cur.getRight();
        }
        return first;
    }

    /**
     * 面试题54：所有大于或等于节点的值之和 从大到小遍历排序二叉树
     *
     * @param root
     * @return
     */
    public static TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.getRight();
            }
            cur = stack.pop();
            sum += cur.getValue();
            cur.setValue(sum);
            cur = cur.getLeft();
        }
        return root;
    }

    /**
     * 从小到大遍历二叉树
     */
    static class BSTIterator implements Iterator<TreeNode> {

        TreeNode cur;

        Stack<TreeNode> stack;

        Boolean reverse;

        public BSTIterator(TreeNode root, boolean reverse) {
            this.cur = root;
            this.reverse = reverse;
            this.stack = new Stack<>();
        }

        @Override
        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }

        @Override
        public TreeNode next() {
            while (cur != null) {
                stack.push(cur);
                cur = reverse ? cur.getRight() : cur.getLeft();
            }
            cur = stack.pop();
            TreeNode treeNode = cur;
            cur = reverse ? cur.getLeft() : cur.getRight();
            return treeNode;
        }
    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        BSTIterator itor = new BSTIterator(root, false);
        BSTIterator ritor = new BSTIterator(root, true);
        int next = itor.next().getValue();
        int rnext = ritor.next().getValue();
        while (next != rnext) {
            if (next + rnext == k) {
                return true;
            }
            if (next + rnext < k) {
                next = itor.next().getValue();
            } else {
                rnext = ritor.next().getValue();
            }
        }
        return false;
    }
}
