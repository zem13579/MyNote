package com.zem.algorithm.huawei2024.ex1.no3160ex1no48;

import java.util.Scanner;

/**
 * todo 不是很懂 相当于合理分配占有的车位，将车位放到
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputArr = sc.nextLine().split(",");
        String inputStr = String.join("", inputArr);
        String[] parking_slots = inputStr.split("0");

        int min_cars = 0;

        for (String slot : parking_slots) {
            int occupiedLength = slot.length();
            if (occupiedLength != 0) {
                if (occupiedLength % 3 == 0) {
                    min_cars += occupiedLength / 3;
                } else {
                    min_cars += (occupiedLength - occupiedLength % 3) / 3;
                    min_cars++;
                }
            }

        }
        System.out.println(min_cars);
    }
}
