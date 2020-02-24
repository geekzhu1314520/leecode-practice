package trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        //把words放到Trie里
        for (String word : words) {
            trie.insert(word);
        }

        //遍历board
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Set<String> result = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                fun(trie, "", board, i, j, visited, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void fun(Trie trie, String str, char[][] board, int i, int j, boolean[][] visited, Set<String> result) {

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        str += board[i][j];
        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            result.add(str);
        }

        visited[i][j] = true;
        fun(trie, str, board, i, j + 1, visited, result);
        fun(trie, str, board, i, j - 1, visited, result);
        fun(trie, str, board, i + 1, j, visited, result);
        fun(trie, str, board, i - 1, j, visited, result);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearchII searchII = new WordSearchII();
        List<String> result = searchII.findWords(board, words);
        System.out.println(result);

        System.out.println(6&11);
    }

}
