package lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache02 {

    private int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache02(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer value = cache.get(key);
        if (value == null) {
            value = -1;
        }
        return value;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
