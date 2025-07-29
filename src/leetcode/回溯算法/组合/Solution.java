package leetcode.回溯算法.组合;

import java.util.ArrayList;
import java.util.List;

//问题：超时

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combine = new ArrayList<>(k);
        backtrack(n, k, 1, combine, res);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> combine, List<List<Integer>> res) {
        if (combine.size() == k) {
            res.add(new ArrayList<>(combine));
            return;
        }
        // for (int i = start; i <= n; i++) {
        //剪枝：n - (k - combine.size()) + 1 去除最后一个元素的选择，因为无法凑成k个元素
        for (int i = start; i <= n - (k - combine.size()) + 1; i++) {
            combine.add(i);
            backtrack(n, k, i + 1, combine, res);
            combine.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> data = new Solution().combine(4, 2);
        System.out.println(data);
    }
}
