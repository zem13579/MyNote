package com.zem.algorithm.huawei2024.ex1.no2655ex1no13;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] array = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
        int[] result = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            int k = (i + 1) % array.length;
            while (k != i) {
                if (array[k] < array[i]) {
                    result[i] = array[k] + result[i];
                    break;
                }
                k = (k + 1) % array.length;
            }
        }
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
