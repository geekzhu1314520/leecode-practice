package bitwise;

public class CountingBits {

    public int[] countBits(int num) {
        int[] arr = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            arr[i] = arr[i & i - 1] + 1;
        }
        return arr;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] arr = countingBits.countBits(5);
        System.out.println(arr);
    }

}
