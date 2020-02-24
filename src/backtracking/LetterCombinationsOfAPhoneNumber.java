package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {

    private Map<String, String> map = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack("", digits, result);

        return result;
    }

    private void backtrack(String combination, String digits, List<String> result) {
        if (digits.length() == 0) {
            result.add(combination);
            return;
        }

        String digit = digits.substring(0, 1);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String letter = letters.substring(i, i + 1);
            backtrack(combination + letter, digits.substring(1), result);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber phoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(phoneNumber.letterCombinations("23"));
    }

}
