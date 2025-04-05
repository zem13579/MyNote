package com.zem.algorithm.swordoffer2.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/3/26 0026 15:08
 */
@Data
@NoArgsConstructor
public class TreeNode {
    private Integer value;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

}
