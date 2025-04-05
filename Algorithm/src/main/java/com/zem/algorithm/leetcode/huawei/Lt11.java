package com.zem.algorithm.leetcode.huawei;

public class Lt11 {
    public static void main(String[] args) {

    }

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * (Math.min(height[left], height[right]));
            if(area>maxArea){
                maxArea = area;
            }
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
