package recursion;

public class Pow02 {

    public double myPow(double x, int num) {
        long n = num;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double power = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                power *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return power;
    }

    public static void main(String[] args) {

        Pow02 pow = new Pow02();
        System.out.println(pow.myPow(-1.00000, -2147483648));
        System.out.println(pow.myPow(2.00000, -2147483648));
//        System.out.println(pow.myPow(2, 10));
//        System.out.println(pow.myPow(2.10000, 3));
//        System.out.println(pow.myPow(2, -2));
    }

}
