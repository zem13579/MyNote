package com.zem.algorithm.swordoffer;

import org.junit.jupiter.api.Test;

class Code42Test {

    @Test
    void reverse() {
        Code42 code42 = new Code42();
        byte[] str = "abcdef".getBytes();
        code42.reverse(str,0,str.length);
        System.out.println(new String(str));
    }
}