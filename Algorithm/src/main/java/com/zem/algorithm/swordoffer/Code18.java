package com.zem.algorithm.swordoffer;

import com.zem.algorithm.common.BinaryTree;

/**
 * @Author zem
 * @Date 2023/10/4
 * 树的子结构
 */
public class Code18 {
    public static void main(String[] args) {

    }

    public Boolean hasSubTree(BinaryTree root1, BinaryTree root2) {
        Boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.value == root2.value) {
                //如果单个节点值相同，从该节点开始比较树
                result = DoseTree1HasTree2(root1, root2);
            }
            if (!result) {
                result = hasSubTree(root1.pLeft, root2);
            }
            if (!result) {
                result = hasSubTree(root1.pRight, root2);
            }
        }
        return result;
    }

    private Boolean DoseTree1HasTree2(BinaryTree root1, BinaryTree root2) {
        if (root2 == null) {
            //root2 比较到了空节点，可以说明已经比较到了摸个分叉的尽头
            //但是，判断必须在root1 为空判断之前
            return true;
        }

        if (root1 == null) {
            //root2 不为空，但root1 为空，说明不能判断为空
            return false;
        }

        if (root1.value != root2.value) {
            return false;
        }

        return DoseTree1HasTree2(root1.pLeft, root2.pLeft) && DoseTree1HasTree2(root1.pRight, root2.pRight);
    }

}
