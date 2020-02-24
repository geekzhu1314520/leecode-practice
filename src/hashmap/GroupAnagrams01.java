package hashmap;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams
 */
public class GroupAnagrams01 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>(16);
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                stringBuilder.append("#").append(count[i]);
            }
            String key = stringBuilder.toString();
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams01 groupAnagrams = new GroupAnagrams01();
        List<List<String>> result = groupAnagrams.groupAnagrams(strs);
        System.out.println(result);
    }


}
