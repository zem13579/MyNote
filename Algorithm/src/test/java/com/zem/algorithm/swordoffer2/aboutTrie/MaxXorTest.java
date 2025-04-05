package com.zem.algorithm.swordoffer2.aboutTrie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxXorTest {
    @Test
    public void test() {
        int i = 4;
        for (int j = 31; j >= 0; j--) {
            int bit = (i >> j) & 1;
            System.out.print(bit + "\t");
        }
    }

    @Test
    public void test2() {
        System.out.println(0 << 1);
    }

}