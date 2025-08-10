package leetcode.矩阵.垂直翻转子矩阵;

public class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int[][] res = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            res[i] = grid[i].clone();
        }
        // 垂直翻转子矩阵
        for (int j = 0; j < k / 2; j++) {
            // 计算要交换的两行在子矩阵中的相对位置
            int r1 = x + j;
            int r2 = x + k - j - 1;
            // 交换这两行的子矩阵部分
            for (int t = y; t < y + k; t++) {
                int temp = res[r1][t];
                res[r1][t] = res[r2][t];
                res[r2][t] = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int x = 1;
        int y = 0;
        int k = 3;
        Solution solution = new Solution();
        int[][] result = solution.reverseSubmatrix(grid, x, y, k);
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
