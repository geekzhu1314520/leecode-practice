package divideconquer;

public class PowXN {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        if (n % 2 == 0) {
            return myPow(x, n / 2) * myPow(x, n / 2);
        } else {
            return x * myPow(x, n / 2) * myPow(x, n / 2);
        }
    }

    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(0.00001, 2147483647));
    }

}
