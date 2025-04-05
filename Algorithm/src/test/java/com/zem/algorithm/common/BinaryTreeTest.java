package com.zem.algorithm.common;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree headNode;

    @BeforeEach
    public  void beforeAllFun() {
        headNode = new BinaryTree(1);
        headNode.pLeft = new BinaryTree(2);
        headNode.pRight = new BinaryTree(3);

        headNode.pLeft.pLeft = new BinaryTree(4);
        headNode.pLeft.pRight = new BinaryTree(5);

        headNode.pLeft.pRight.pLeft = new BinaryTree(6);
        headNode.pLeft.pRight.pRight = new BinaryTree(7);

    }

    @Test
    void preOrderRecursion() {
        BinaryTree.preOrderRecursion(headNode, node -> System.out.print(node.value+"\t"));
    }

    @Test
    void inOrderRecursion() {
        BinaryTree.inOrderRecursion(headNode, node -> System.out.print(node.value+"\t"));
    }

    @Test
    void postOrderRecursion() {
        BinaryTree.postOrderRecursion(headNode, node -> System.out.print(node.value+"\t"));
    }

    @Test
    void inOrderLoop() {
        BinaryTree.inOrderLoop(headNode, node -> System.out.print(node.value+"\t"));
    }

    @Test
    void postOrderLoop() {
        BinaryTree.postOrderLoop(headNode, node -> System.out.print(node.value+"\t"));
    }
}