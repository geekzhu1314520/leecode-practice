package divideconquer;

/**
 * https://leetcode-cn.com/problems/powx-n/
 */
public class PowXN01 {

    public double myPow(double x, int num) {

        long n = num;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double power = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                power *= x;
            }
            x *= x;
            n = n >>> 1;
        }
        return power;
    }

    public static void main(String[] args) {
        PowXN01 powXN = new PowXN01();
        System.out.println(powXN.myPow(2.00000, -2147483648));
    }

}
