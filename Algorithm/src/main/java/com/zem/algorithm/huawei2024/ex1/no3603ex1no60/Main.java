package com.zem.algorithm.huawei2024.ex1.no3603ex1no60;

import java.util.Scanner;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/9/12 0012 13:38
 */
public class Main {
    
    static class TriNode {
        
        private int value;
        
        public TriNode left;
        
        public TriNode mid;
        
        public TriNode right;
        
        public TriNode(int value) {
            this.value = value;
        }
        
        public void insert(int inValue) {
            if (inValue < this.value - 500) {
                if (left == null) {
                    left = new TriNode(inValue);
                } else {
                    left.insert(inValue);
                }
            } else if (inValue > this.value + 500) {
                if (right == null) {
                    right = new TriNode(inValue);
                } else {
                    right.insert(inValue);
                }
            } else {
                if (mid == null) {
                    mid = new TriNode(inValue);
                } else {
                    mid.insert(inValue);
                }
            }
        }
        
        public int getHeight() {
            int leftheight = 0;
            int midheight = 0;
            int rightheight = 0;
            if (left != null) {
                leftheight = left.getHeight();
            }
            if (right != null) {
                rightheight = right.getHeight();
            }
            if (mid != null) {
                midheight = mid.getHeight();
            }
            return Math.max(Math.max(leftheight, midheight), rightheight) + 1;
        }
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        TriNode root = null;
        for (int i = 0; i < num; i++) {
            int value = sc.nextInt();
            if (root == null) {
                root = new TriNode(value);
            } else {
                root.insert(value);
            }
            
        }
        System.out.println(root.getHeight());
    }
    
}
