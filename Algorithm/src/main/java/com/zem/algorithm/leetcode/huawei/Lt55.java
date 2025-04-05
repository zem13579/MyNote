package com.zem.algorithm.leetcode.huawei;

public class Lt55 {
    public static void main(String[] args) {
        Lt55 lt55 = new Lt55();
        System.out.println(lt55.canJump(new int[]{0}));
        System.out.println(lt55.canJump(new int[]{0, 2}));
        System.out.println(lt55.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, i + nums[i]);
                if (rightMost >= n - 1) {
                    return true;
                }
            }else{
                return false;
            }
        }
        return false;
    }
}
