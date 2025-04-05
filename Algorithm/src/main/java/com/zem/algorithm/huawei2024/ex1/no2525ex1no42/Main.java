package com.zem.algorithm.huawei2024.ex1.no2525ex1no42;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfOrders = Integer.parseInt(sc.nextLine());
        int luckNumber = Integer.parseInt(sc.nextLine());
        String[] split = sc.nextLine().split(" ");

        int pos = 0;
        int max = pos;
        for (int i = 0; i < split.length; i++) {
            Integer order = Integer.parseInt(split[i]);
            if(order == luckNumber){
                if(order > 0){
                    order = order+1;
                }
                if(order <0){
                    order = order-1;
                }
            }
            pos += order;
            if(pos > max){
                max= pos;
            }
        }
        System.out.println(max);
    }
}
