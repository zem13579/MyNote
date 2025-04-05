package com.zem.algorithm.swordoffer2.aboutlinkedlist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ReverseListTest {
    @Test
    public void test(){
        int[] list = {1,2,3,4,5};
        LinkedList<Integer> linkedList = Arrays.stream(list).boxed().collect(Collectors.toCollection(LinkedList::new));
        Collections.reverse(linkedList);
        for (Integer i : linkedList) {
            System.out.println(i);
        }
    }
}