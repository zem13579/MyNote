package org.example.sort;

import java.util.ArrayList;
import java.util.Collections;
public abstract class SortModelArr<T extends Comparable<T>> {
/**
 * @author zhang
 */

    protected boolean less(T v, T w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        return v.compareTo(w) < 0;
    }


    protected boolean bigger(T v, T w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        return v.compareTo(w) > 0;
    }

    protected boolean equal(T v, T w) {
        if (v == null || w == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        return v.compareTo(w) == 0;
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

    public static Integer[] generateUniqueRandomNumbers(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0.");
        }

        List<Integer> numbers = new ArrayList<>(size);

        // 添加从1到size的数字
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }

        // 打乱顺序
        Collections.shuffle(numbers);

        // 转换为 Integer[] 并返回
        return numbers.toArray(new Integer[0]);
    }

    public abstract void sort(T[] arr);

}
