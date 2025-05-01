package org.example.sort;

import java.util.Arrays;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> extends SortModelArr<T> {

    @Override
    public void sort(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length ; j++) {
                if (less(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }
            exch(arr,i,minIndex);
        }
    }

    public static void main(String[] args) {
        SelectionSort<Integer> integerSelectionSort = new SelectionSort<>();
        Integer[] arr = {4,9,3,1};
        integerSelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
