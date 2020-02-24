package recursion;

public class Pow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return x * myPow(x, n - 1);
        } else {
            return 1 / myPow(x, -n);
        }
    }

    public static void main(String[] args) {

        Pow pow = new Pow();

        System.out.println(pow.myPow(2, 10));
        System.out.println(pow.myPow(2.10000, 3));
        System.out.println(pow.myPow(2, -2));
    }

}
