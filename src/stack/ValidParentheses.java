package stack;

import java.util.*;

public class ValidParentheses {

    public boolean isValid(String s) {

        if (s == null) {
            return true;
        }

        Map<Character, Character> param = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Stack<Character> stack = new Stack<>();
        Set<Character> keys = param.keySet();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (keys.contains(c)) {
                if (stack.empty() || !param.get(c).equals(stack.pop())) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses parentheses = new ValidParentheses();

        String s1 = "()";
        System.out.println(parentheses.isValid(s1));

        String s2 = "()[]{}";
        System.out.println(parentheses.isValid(s2));

        String s3 = "(]";
        System.out.println(parentheses.isValid(s3));

        String s4 = "([)]";
        System.out.println(parentheses.isValid(s4));

        String s5 = "{[]}";
        System.out.println(parentheses.isValid(s5));

        String s6 = null;
        System.out.println(parentheses.isValid(s6));

    }

}