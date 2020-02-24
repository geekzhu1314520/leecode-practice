package stack;

import java.util.Stack;

public class ValidParentheses01 {

    public boolean isValid(String s) {

        if (s == null) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (!stack.empty() && c == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses01 parentheses = new ValidParentheses01();

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