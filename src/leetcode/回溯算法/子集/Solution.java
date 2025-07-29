package leetcode.回溯算法.子集;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> child = new ArrayList<>();
        backtrack(nums, 0, child, res);
        return res;
    }
    //start用于记录当前子集的起始位置，避免使用之前使用过的元素，集合不能够重复
    private void backtrack(int[] nums, int start, List<Integer> child, List<List<Integer>> res) {
        //只要小于nums.length，就添加到结果集中
        if (child.size() <= nums.length) {
            res.add(new ArrayList<>(child));
        }
        for (int i = start; i < nums.length; i++) {
            child.add(nums[i]);
            backtrack(nums, i + 1, child, res);
            child.removeLast();
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution().subsets(new int[]{1, 2, 3});
        System.out.println(subsets);
    }
}
