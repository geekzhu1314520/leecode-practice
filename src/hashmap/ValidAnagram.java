package hashmap;

import java.util.HashMap;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        HashMap<Character, Integer> sCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer count = sCountMap.get(c);
            if(count == null){
                count = 0;
            }
            sCountMap.put(c, count + 1);
        }

        HashMap<Character, Integer> tCountMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            Integer count = tCountMap.get(c);
            if(count == null){
                count = 0;
            }
            tCountMap.put(c, count + 1);
        }
        return sCountMap.equals(tCountMap);
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "rat", t = "cat";
//        String s = "aa", t = "a";
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram(s, t));
    }

}
