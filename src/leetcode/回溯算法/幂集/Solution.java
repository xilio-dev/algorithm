package leetcode.回溯算法.幂集;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(res, current, nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> current, int[] nums, int start) {
        if (current.size() <= nums.length) {
            res.add(new ArrayList<>(current));
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(res, current, nums, i + 1);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> data = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(data);
    }
}
