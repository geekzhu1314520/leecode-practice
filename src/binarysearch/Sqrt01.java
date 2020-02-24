package binarysearch;

public class Sqrt01 {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int r = x;
        while (r > x / r) {
            int value = r + x / r;
            r = (value < 0 ? Integer.MAX_VALUE : value) / 2;
        }
        return r;
    }

    public static void main(String[] args) {
        Sqrt01 sqrt = new Sqrt01();
        System.out.println(sqrt.mySqrt(2147395600));

    }

}
