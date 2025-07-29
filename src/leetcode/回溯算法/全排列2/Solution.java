package leetcode.回溯算法.全排列2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(res, current, nums, used);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> current, int[] nums, boolean[] used) {
        if ((current.size() == nums.length) && !res.contains(current)) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 选择
            current.add(nums[i]);
            used[i] = true;
            // 回溯进入下一层
            backtrack(res, current, nums, used);
            // 撤销当前选择
            current.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> data = new Solution().permuteUnique(new int[]{1, 1, 3});
        System.out.println(data);
    }
}
