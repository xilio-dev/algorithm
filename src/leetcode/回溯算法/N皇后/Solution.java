package leetcode.回溯算法.N皇后;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, res);
        return res;
    }

    private void dfs(char[][] board, int index, List<List<String>> res) {
        if (index == board.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (!isValid(board, index, i)) {
                continue;
            }
            board[index][i] = 'Q';
            dfs(board, index + 1, res);
            board[index][i] = '.';
        }

    }

    private boolean isValid(char[][] board, int index, int i) {
        for (int j = 0; j < index; j++) {
            if (board[j][i] == 'Q') {
                return false;
            }
        }
        for (int j = index - 1, k = i - 1; j >= 0 && k >= 0; j--, k--) {
            if (board[j][k] == 'Q') {
                return false;
            }
        }
        for (int j = index - 1, k = i + 1; j >= 0 && k < board.length; j--, k++) {
            if (board[j][k] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> result = new Solution().solveNQueens(n);
        for (List<String> l : result) {
            for (String s : l) {
                System.out.println(s);
            }
            System.out.println("------------");
        }
    }
}
