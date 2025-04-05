package com.zem.algorithm.swordoffer;

import org.junit.jupiter.api.Test;

import java.util.Random;

class Code36Test {

    @Test
    public void test() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
//            System.out.println(Math.random());
            System.out.println(random.nextInt(100) + 1);
        }

    }

}