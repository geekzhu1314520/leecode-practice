package recursion;

public class Pow01 {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / myPow(x, -n);
        } else if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            return myPow(x * x, n / 2);
        }
    }

    public static void main(String[] args) {

        Pow01 pow = new Pow01();

        System.out.println(pow.myPow(2, 10));
        System.out.println(pow.myPow(2.10000, 3));
        System.out.println(pow.myPow(2, -2));
    }

}
