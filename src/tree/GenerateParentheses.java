package tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gene(result, "", n, 0, 0);
        return result;
    }

    private void gene(List<String> result, String each, int n, int left, int right) {
        if (left >= n && right >= n) {
            result.add(each);
            return;
        }

        if (left < n) {
            gene(result, each + "(", n, left + 1, right);
        }
        if (left > right && right < n) {
            gene(result, each + ")", n, left, right + 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(4));

        Integer a = 100;
        int b = 100;
        System.out.println(a == b);
    }

}
