package dynamic;

public class Fib {

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }

        int[] memory = new int[N + 1];
        memory[0] = 0;
        memory[1] = 1;
        for (int i = 2; i <= N; i++) {
            memory[i] = memory[i - 1] + memory[i - 2];
        }
        return memory[N];
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(4));
    }

}
