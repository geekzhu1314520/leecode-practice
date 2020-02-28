package divideconquer;

public class PowXN02 {

    public double myPow(double x, int num) {
        long n = num;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return pow(x, n);
    }

    private double pow(double x, long n) {

        //终止条件
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        //分治：奇、偶数
        double half = pow(x, n >>> 1);
        if ((n & 1) == 1) {
            return x * half * half;
        } else {
            return half * half;
        }
    }

    public static void main(String[] args) {
        PowXN02 powXN02 = new PowXN02();
        System.out.println(powXN02.myPow(0.00001, 2147483647));
    }

}

