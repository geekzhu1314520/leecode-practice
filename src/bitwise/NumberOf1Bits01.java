package bitwise;

public class NumberOf1Bits01 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits01 bits = new NumberOf1Bits01();
        System.out.println(bits.hammingWeight(7));
    }

}
