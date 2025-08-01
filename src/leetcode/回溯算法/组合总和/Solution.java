package leetcode.回溯算法.组合总和;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, path, res);
        return res;
    }

    private void dfs(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new Solution().combinationSum(candidates, target);
        System.out.println(result);

    }
}
