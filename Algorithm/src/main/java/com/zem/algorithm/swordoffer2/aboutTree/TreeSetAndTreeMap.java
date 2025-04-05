package com.zem.algorithm.swordoffer2.aboutTree;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Describe
 * @Author zem
 * @CreateDate 2024/3/28 0028 14:30
 */
public class TreeSetAndTreeMap {

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
    }

    static class MyCalendar {

        private TreeMap<Integer, Integer> events;

        public MyCalendar() {
            events = new TreeMap<>();
        }

        public boolean book(Integer start, Integer end) {
            Map.Entry<Integer, Integer> event = events.floorEntry(start);
            if (event != null && event.getValue() > start) {
                return false;
            }
            event = events.ceilingEntry(start);
            if (event != null && event.getValue() < end) {
                return false;
            }
            events.put(start, end);
            return true;
        }
    }
}
