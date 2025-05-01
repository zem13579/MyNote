package org.example.sort;

import java.util.List;

public abstract class SortModelArr<T extends Comparable<T>> {

    protected boolean less(T v, T w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        return v.compareTo(w) < 0;
    }

    protected void exch(T[] arr, int i, int j) {
        if (arr == null) {
            throw new IllegalArgumentException("数组不能为null");
        }
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    protected void show(T[] arr) {
        if (arr == null) {
            System.out.println("Input list is null");
            return;
        }
        for (T t : arr) {
            System.out.print(t + "\t");
        }
    }


    public abstract void sort(T[] arr);

    public void testSpeed(){

    }
}
