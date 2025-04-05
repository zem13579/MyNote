package com.zem.algorithm.leetcode.huawei;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Lt460 {
    class LFUCache {

        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedHashMap<Integer, Integer> counter = new LinkedHashMap<>();

        int capacity;
        int curNum;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.curNum = 0;
        }

        public int get(int key) {
            counter.merge(key, 1, Integer::sum);
            return map.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if(curNum == capacity){
                //remove
            }
            counter.merge(key, 1, Integer::sum);
        }
    }

    public static void main(String[] args) {

    }
}
