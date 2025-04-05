package com.zem.algorithm.leetcode.learn.part1Array;

import java.util.Arrays;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2025/3/17 0017 14:07
 */
public class Lt189 {
    
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }
    
    private int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
    
    public void rotate3(int[] nums, int k) {
        int l = k % nums.length;
        if (l == 0) {
            return;
        }
        int mid = nums.length - l - 1;
        reverse(nums, 0, mid);
        reverse(nums, mid + 1, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        
    }
    
    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    
    public void rotate2(int[] nums, int k) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newI = (i + k) % nums.length;
            ans[newI] = nums[i];
        }
        // 将 ans 数组的内容复制回 nums 数组
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }
    
    public static void main(String[] args) {
        Lt189 lt189 = new Lt189();
        int[] nums = {1, 2, 3, 4, 5};
        lt189.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
