package bitwise;

public class PowerOfTwo01 {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & n - 1) == 0;
    }

    public static void main(String[] args) {
        PowerOfTwo01 powerOfTwo = new PowerOfTwo01();
        System.out.println(powerOfTwo.isPowerOfTwo(7));
    }

}
