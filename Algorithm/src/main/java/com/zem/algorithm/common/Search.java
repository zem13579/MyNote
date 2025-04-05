package com.zem.algorithm.common;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 查找算法
 * 顺序查找、二分查找、哈希表查找和二叉排序树查找
 */
public class Search {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println(binarySearchLoop(arrayList, -1));

    }

    /***
     * 顺序查找
     * @param arrayList
     */
    private static Object sequentialSearch(ArrayList<Object> arrayList, Objects target) {
        for (Object o : arrayList) {
            if (o.equals(target)) {
                return o;
            }
        }
        return null;
    }

    /**
     * 二分查找 递归
     *
     * @param arrayList
     * @return
     */
    private static <T extends Comparable<T>> int binarySearchRecursion(ArrayList<T> arrayList, T target) {
        int left = 0;
        int right = arrayList.size() - 1;
        return doBinarySearchRecursion(left, right, arrayList, target);
    }

    private static <T extends Comparable<T>> int doBinarySearchRecursion(int left, int right, ArrayList<T> arrayList, T target) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        T midObject = arrayList.get(mid);
        if (midObject.compareTo(target) == 0) {
            return mid;
        } else if (midObject.compareTo(target) > 0) {
            return doBinarySearchRecursion(left, mid - 1, arrayList, target);
        } else {
            return doBinarySearchRecursion(mid + 1, right, arrayList, target);
        }
    }

    private static <T extends Comparable<T>> int binarySearchLoop(ArrayList<T> arrayList, T target) {
        for (int left = 0, right = arrayList.size() - 1; left <= right; ) {
            int mid = (left + right) / 2;
            T midObj = arrayList.get(mid);
            if (midObj.compareTo(target) == 0) {
                return mid;
            } else if (midObj.compareTo(target) > 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
