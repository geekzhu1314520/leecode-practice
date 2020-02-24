package bitwise;

public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int count = 0;
        int opt = 1;
        while (opt != 0) {
            if ((opt & n) == opt) {
                count++;
            }
            opt = opt << 1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits bits = new NumberOf1Bits();
        System.out.println(bits.hammingWeight(3));
    }

}
