package pruning;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<>();
        DFS(0, n, new boolean[n], new boolean[2 * n], new boolean[2 * n], new String[n], result);
        return result;
    }

    private void DFS(int row, int n, boolean[] cols, boolean[] pie, boolean[] na, String[] board, List<String[]> result) {

        if (row >= n) {
            result.add(board);
        } else {
            for (int i = 0; i < board.length; i++) {

            }
        }

    }

}
