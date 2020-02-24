package bitwise;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        return hammingWeight(n) == 1;
    }

    private int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(3));
    }

}
