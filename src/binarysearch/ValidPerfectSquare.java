package binarysearch;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 0) {
            return false;
        }
        int r = num;
        while (r > num / r) {
            int value = r + num / r;
            r = (value < 0 ? Integer.MAX_VALUE : value) / 2;
        }
        return r * r == num;
    }

    public static void main(String[] args) {
        ValidPerfectSquare square = new ValidPerfectSquare();
        System.out.println(square.isPerfectSquare(1));
    }

}
