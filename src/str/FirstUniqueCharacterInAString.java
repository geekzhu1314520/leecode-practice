package str;

import hashmap.HashDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

/**
 * @description: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @author: alan
 * @date: 2020/4/5
 * @time: 6:09 下午
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        Map<Character, LongAdder> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            LongAdder longAdder = map.computeIfAbsent(s.charAt(i), v -> new LongAdder());
            longAdder.increment();
        }

        for (int i = 0; i < s.length(); i++) {
            LongAdder value = map.get(s.charAt(i));
            if (value.intValue() == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        FirstUniqueCharacterInAString inAString = new FirstUniqueCharacterInAString();
        System.out.println(inAString.firstUniqChar(s));
    }

}
