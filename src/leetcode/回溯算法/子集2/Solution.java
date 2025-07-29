package leetcode.回溯算法.子集2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> child = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, child, res);
        return res;
    }
    private void backtrack(int[] nums, int start, List<Integer> child, List<List<Integer>> res) {
        res.add(new ArrayList<>(child));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            child.add(nums[i]);
            backtrack(nums, i + 1, child, res);
            child.removeLast();
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> subsets = new  Solution().subsetsWithDup(new int[]{0});
        System.out.println(subsets);
    }
}
