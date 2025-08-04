package leetcode.动态规划.杨辉三角;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows == 0) {
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                List<Integer> item = new ArrayList<>(1);
                item.add(1);
                result.add(item);
            }
            if (i > 0) {
                List<Integer> pre = result.get(i - 1);
                int size = pre.size();
                List<Integer> item = new ArrayList<>(size + 1);
                item.add(1);
                for (int j = 0; j < size - 1; j++) {
                    item.add(pre.get(j) + pre.get(j + 1));
                }
                item.add(1);
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(7));
    }
}
