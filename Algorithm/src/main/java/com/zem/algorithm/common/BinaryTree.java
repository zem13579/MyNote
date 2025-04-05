package com.zem.algorithm.common;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * 二叉树的遍历
 */

public class BinaryTree {

    public int value;
    public BinaryTree pLeft;
    public BinaryTree pRight;

    public BinaryTree() {
    }

    public BinaryTree(int value) {
        this.value = value;
    }

    /**
     * 先序递归 中 左 右
     *
     * @param rootNode
     */
    public static void preOrderRecursion(BinaryTree rootNode, Consumer<BinaryTree> visitFunction) {
        if (rootNode != null) {
            visitFunction.accept(rootNode);
            preOrderRecursion(rootNode.pLeft, visitFunction);
            preOrderRecursion(rootNode.pRight, visitFunction);
        }
    }

    /**
     * 先序循环 中 左 右
     *
     * @param rootNode
     */
    public static void preOrderLoop(BinaryTree rootNode, Consumer<BinaryTree> visitFunction) {
        //借助栈
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree current = rootNode;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                visitFunction.accept(current);
                stack.push(current);
                current = current.pLeft;
            } else {
                current = stack.pop().pRight;
            }
        }
    }

    /**
     * 中序递归 左 中 右
     *
     * @param rootNode
     * @param visitFunction
     */
    public static void inOrderRecursion(BinaryTree rootNode, Consumer<BinaryTree> visitFunction) {
        if (rootNode != null) {
            inOrderRecursion(rootNode.pLeft, visitFunction);
            visitFunction.accept(rootNode);
            inOrderRecursion(rootNode.pRight, visitFunction);
        }
    }

    /**
     * 中序循环 中 左 右
     *
     * @param rootNode
     */
    public static void inOrderLoop(BinaryTree rootNode, Consumer<BinaryTree> visitFunction) {
        //借助栈
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree current = rootNode;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.pLeft;
            } else {
                current = stack.pop();
                visitFunction.accept(current);
                current = current.pRight;
            }
        }

    }

    /**
     * 后序递归 左 右 中
     *
     * @param rootNode
     * @param visitFunction
     */
    public static void postOrderRecursion(BinaryTree rootNode, Consumer<BinaryTree> visitFunction) {
        if (rootNode != null) {
            postOrderRecursion(rootNode.pLeft, visitFunction);
            postOrderRecursion(rootNode.pRight, visitFunction);
            visitFunction.accept(rootNode);
        }
    }

    /**
     * 后序循环 中 左 右
     *
     * @param rootNode
     */
    public static void postOrderLoop(BinaryTree rootNode, Consumer<BinaryTree> visitFunction) {
        //借助栈
        if (rootNode == null) {
            return;
        }
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree current = rootNode;
        stack.push(current);
        stack.push(current); // 每个结点 push 两次，这样可以简单的判断出哪些结点是否处理过
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (!stack.isEmpty() && current == stack.peek()) {
                if (current.pRight != null) {
                    stack.push(current.pRight);
                    stack.push(current.pRight);
                }
                if (current.pLeft != null) {
                    stack.push(current.pLeft);
                    stack.push(current.pLeft);
                }
            } else {
                visitFunction.accept(current);
            }
        }

    }

    @Override
    public String toString() {
        return this.value + "";
    }
}
