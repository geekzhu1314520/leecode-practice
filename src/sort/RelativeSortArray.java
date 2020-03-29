package sort;

import java.util.*;
import java.util.concurrent.atomic.LongAdder;

/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 * Created by bluzelee on 2020/3/29.
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, LongAdder> map = new HashMap<>();
        for (int value : arr1) {
            LongAdder longAdder = map.computeIfAbsent(value, i -> new LongAdder());
            longAdder.increment();
        }

        int[] result = new int[arr1.length];
        int k = 0;
        for (int value : arr2) {
            LongAdder longAdder = map.get(value);
            for (int i = 0; i < longAdder.intValue(); i++) {
                result[k++] = value;
            }
            map.remove(value);
        }

        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        for (Object key : keys) {
            LongAdder longAdder = map.get(key);
            for (int i = 0; i < longAdder.intValue(); i++) {
                result[k++] = (int) key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RelativeSortArray array = new RelativeSortArray();
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        int[] result = array.relativeSortArray(arr1, arr2);
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
