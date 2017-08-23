package leetcode.medium.application;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lenovo on 2017/8/20.
 */
public class LRUCache {
//    ThreadPoolExecutor
    private Map<Integer, Integer> list;
    private int cap;

    public LRUCache(int capacity) {
        this.list = new MyLinkedHashMap<Integer, Integer>(capacity);
    }

    public int get(int key) {
        if(list.containsKey(key)) return list.get(key);
        return -1;
    }

    public void put(int key, int value) {
        list.put(key, value);
    }

    private static class MyLinkedHashMap<K,V> extends LinkedHashMap<K,V> {
        int capacity;
        MyLinkedHashMap(int capacity) {
            super(16, 0.75f, true);
            this.capacity = capacity;
        }

        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }
}
