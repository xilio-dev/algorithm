package leetcode.回溯算法.单词搜索;

class Solution {
    public boolean exist(char[][] board, String word) {
        //记录访问过的位置
        boolean[][] visited = new boolean[board.length][board[0].length];
        //遍历二维数组 每一个位置都作为起点进行dfs （起点）
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
        //递归的终止条件，单词的最后一个字符匹配成功
        if (index == word.length()) {
            return true;
        }
        //判断当前位置是否越界，是否访问过，是否匹配
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        //走不同的方向都可能找到单词，只要有一个方向找到就返回true
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
