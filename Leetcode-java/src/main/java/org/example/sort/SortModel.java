package org.example.sort;

import java.util.List;

public abstract class SortModel<T extends Comparable<T>> {

    protected boolean less(T v, T w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        return v.compareTo(w) < 0;
    }

    protected void exch(List<T> arr, int i, int j) {
        if (arr == null) {
            throw new IllegalArgumentException("数组不能为null");
        }
        if (i < 0 || i >= arr.size() || j < 0 || j >= arr.size()) {
            throw new IllegalArgumentException("索引超出数组范围");
        }
        T temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    protected  void show(List<T> arr) {
        if (arr == null) {
            System.out.println("Input list is null");
            return;
        }
        System.out.println(arr);
    }


    public abstract void sort(List<T> arr);
}
