package com.zem.algorithm.swordoffer2.aboutqueue;

import com.zem.algorithm.swordoffer2.bean.TreeNode;
import lombok.Getter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/3/26 0026 15:04
 */
public class CBTInsertor {

    private Queue<TreeNode> queue;

    @Getter
    private TreeNode root;

    public CBTInsertor(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        while (queue.peek().getLeft() != null && queue.peek().getRight() != null) {
            TreeNode poll = queue.poll();
            queue.offer(poll.getLeft());
            queue.offer(poll.getRight());
        }
    }

    public int insert(int value) {
        TreeNode parent = queue.peek();
        TreeNode treeNode = new TreeNode(value);
        if (parent.getLeft() == null) {
            parent.setLeft(treeNode);
        } else {
            parent.setRight(treeNode);
            queue.poll();
            queue.offer(parent.getRight());
            queue.offer(parent.getLeft());
        }
        return parent.getValue();
    }

}
