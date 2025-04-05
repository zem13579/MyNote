package com.zem.algorithm.huawei2024.ex1.no2528ex1no39;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (isPrime(num)) {
            System.out.println("-1 -1");
            return;
        }
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                int j = num / i;
                if (isPrime(j) && isPrime(i)) {
                    System.out.println(i < j ? i + " " + j : j + " " + i);
                    return;
                }
            }
        }
        System.out.println("-1 -1");
    }

    private static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        if (num % 6 != 1 && num % 6 != 5) {
            return false;
        }
        for (int i = 5; i < Math.sqrt(num); i = i + 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
