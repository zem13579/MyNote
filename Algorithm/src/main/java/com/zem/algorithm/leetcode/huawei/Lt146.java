package com.zem.algorithm.leetcode.huawei;


import java.util.HashMap;
import java.util.Map;

public class Lt146 {


    class LRUCache {
        private int size;
        private int capacity;
        private DLinkNode head, tail;
        private Map<Integer, DLinkNode> cache = new HashMap<>();


        class DLinkNode {
            int key;
            int value;
            DLinkNode prev;
            DLinkNode next;

            public DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }

            public DLinkNode() {
            }
        }

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkNode();
            tail = new DLinkNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkNode dLinkNode = cache.get(key);
            if (dLinkNode == null) {
                return -1;
            }
            moveToHead(dLinkNode);
            return dLinkNode.value;
        }

        private void moveToHead(DLinkNode node) {
            //摘出去
            removeNode(node);

            //插入头
            addToHead(node);
        }

        private void addToHead(DLinkNode node) {
            DLinkNode first = head.next;

            head.next = node;
            node.prev = head;

            first.prev = node;
            node.next = first;
        }

        private void removeNode(DLinkNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void put(int key, int value) {
            DLinkNode node = cache.get(key);
            if (node == null) {
                //插入头
                DLinkNode newNode = new DLinkNode(key, value);
                cache.put(key, newNode);

                addToHead(newNode);

                size++;
                if (size > capacity) {
                    DLinkNode dLinkNode = removeTail();
                    cache.remove(dLinkNode.key);
                    size--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private DLinkNode removeTail() {
            DLinkNode res = tail.prev;
            removeNode(res);
            return res;
        }
    }

}
