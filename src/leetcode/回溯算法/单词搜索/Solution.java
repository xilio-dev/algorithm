package leetcode.回溯算法.单词搜索;

class Solution {
    public boolean exist(char[][] board, String word) {
        //记录访问过的位置
        boolean[][] visited = new boolean[board.length][board[0].length];
        //遍历二维数组 每一个位置都作为起点进行dfs
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 递归函数 实现四个方向的dfs
    private boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean found = dfs(board, word, i - 1, j, index + 1, visited) ||
                dfs(board, word, i + 1, j, index + 1, visited) ||
                dfs(board, word, i, j - 1, index + 1, visited) ||
                dfs(board, word, i, j + 1, index + 1, visited);
        visited[i][j] = false;
        return found;
    }


    public static void main(String[] args) {
        //  char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = new char[][]{{'A'}};
        String word = "A";
        System.out.println(new Solution().exist(board, word));
    }
}
