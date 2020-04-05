package str;

/**
 * @description: https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * @author: alan
 * @date: 2020/4/5
 * @time: 6:09 下午
 */
public class FirstUniqueCharacterInAString02 {

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        FirstUniqueCharacterInAString02 inAString = new FirstUniqueCharacterInAString02();
        System.out.println(inAString.firstUniqChar(s));
    }

}
