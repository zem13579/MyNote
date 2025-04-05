package com.zem.algorithm.swordoffer2.aboutTrie;


/**
 * 面试题67：最大的异或
 */
public class MaxXor {

    public static void main(String[] args) {
        MaxXor maxXor = new MaxXor();
        System.out.println(maxXor.findMaxiNumXor(new int[]{1, 3, 4, 7}));
    }

    static class TrieNode {
        public TrieNode[] children;

        public TrieNode() {
            children = new TrieNode[2];
        }
    }

    public TrieNode buildTrie(int[] nums) {
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        return root;
    }

    public int findMaxiNumXor(int[] nums) {
        TrieNode root = buildTrie(nums);
        int max = 0;
        for (int num : nums) {
            TrieNode node = root;
            int xor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.children[1 - bit] != null) {
                    xor = (xor << 1) + 1;
                    node = node.children[1 - bit];
                } else {
                    xor = xor << 1;
                    node = node.children[bit];
                }
            }
            max = Math.max(max, xor);
        }
        return max;
    }
}
