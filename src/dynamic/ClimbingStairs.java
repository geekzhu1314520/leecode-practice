package dynamic;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] memory = new int[n];
        memory[0] = 1;
        memory[1] = 2;
        for (int i = 2; i < n; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[n - 1];
    }

    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println(stairs.climbStairs(45));
    }

}
