package org.example.sort;

import java.util.Arrays;

public class InsertSort<T extends Comparable<T>> extends SortModelArr<T> {

    @Override
    public void sort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            T key = arr[i];
            while (j >= 0 && less(key, arr[j])) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        InsertSort<Integer> sort = new InsertSort<>();
        Integer[] arr = {4, 9, 3, 1};
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
