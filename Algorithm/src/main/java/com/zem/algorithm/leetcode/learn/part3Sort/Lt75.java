package com.zem.algorithm.leetcode.learn.part3Sort;

import java.util.Arrays;

public class Lt75 {
    public static void main(String[] args) {
        Lt75 lt75 = new Lt75();
        int[] nums = {2, 3, 9, 5, 4};
        lt75.sortColors5(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            boolean moved = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    moved = true;
                }
            }
            if (!moved) {
                break;
            }
        }
    }

    /**
     * 选择排序
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[index] > nums[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            }

        }
    }

    /**
     * 插入排序
     *
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }
    }

    /**
     * 希尔排序
     *
     * @param nums
     */
    public void sortColors4(int[] nums) {
        int n = nums.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = nums[i];
                int j;
                for (j = i; j >= gap && nums[j - gap] > temp; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }
        }
    }

    /**
     * 快速排序
     * @param nums
     */
    public void sortColors5(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = this.partition(nums, low, high);
            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        //i 是“小于 pivot”部分的最后一个位置
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                i++;
                //将较小的元素移动到左边
                this.swap(nums, i, j);
            }
        }
        //注意，这里是i+1
        swap(nums, i + 1, high);
        return i + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
