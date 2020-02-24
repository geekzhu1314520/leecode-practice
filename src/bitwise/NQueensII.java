package bitwise;

public class NQueensII {

    private int count = 0;

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        dfs(0, 0, 0, 0, n);
        return count;
    }

    public void dfs(int row, int cols, int pie, int na, int n) {
        if (row >= n) {
            count++;
            return;
        }
        int bits = (~(cols | pie | na)) & ((1 << n) - 1);
        while (bits != 0) {
            int p = bits & -bits;
            dfs(row + 1, cols | p, (pie | p) << 1, (na | p) >> 1, n);
            bits = bits & (bits - 1);
        }
    }

    public static void main(String[] args) {
        NQueensII nQueensII = new NQueensII();
        System.out.println(nQueensII.totalNQueens(4));
    }

}
