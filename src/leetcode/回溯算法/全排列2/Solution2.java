package leetcode.回溯算法.全排列2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(res, current, nums, used);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //不能选自己
            if (used[i]) {
                continue;
            }
            //剪枝，用于去除重复的前缀，比如[1,1,2]，第一个1选择后，第二个1不能选择作为和之前的前缀开头一样
            if (i > 0 && nums[i] == nums[i - 1]&& !used[i - 1]) {
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
        List<List<Integer>> data = new Solution2().permuteUnique(new int[]{1, 1, 3});
        System.out.println(data);
    }
}
