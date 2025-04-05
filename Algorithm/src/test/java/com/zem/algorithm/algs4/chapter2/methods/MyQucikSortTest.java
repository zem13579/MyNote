package com.zem.algorithm.algs4.chapter2.methods;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyQucikSortTest {
    
    @Test
    public void test() {
        Character[] characters = ArrayUtils.toObject("EASYQUESTION".toCharArray());
        System.out.println(Arrays.toString(characters));
        quickSort(characters, 0, characters.length - 1);
        System.out.println(Arrays.toString(characters));
    }
    
    public void quickSort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int j = newPartition(a, low, high);
        quickSort(a, low, high - 1);
        quickSort(a, low + 1, high);
    }
    
    private int newPartition(Comparable[] a, int low, int high) {
        Comparable target = a[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (a[++i].compareTo(target) <= 0) {
                if (i == high) {
                    break;
                }
            }
            while (a[--j].compareTo(target) >= 0) {
                if (j == low) {
                    break;
                }
            }
            
            if (i >= j) {
                //全部交换完成,跳出循环
                break;
            }
            
            //未完成，左侧都比target小，右侧都比target大
            exchange(a, i, j);
        }
        //选择j 是因为 j此时比i小
        exchange(a, low, j);
        return j;
    }
    
    public void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}