package leetcode.回溯算法.全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(res, current, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> current, int[] nums) {
        if (current.size() == nums.length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int num : nums) {
            // 去重,不能够选择已经选择过的数字
            if (current.contains(num)) {
                continue;
            }
            //选择
            current.add(num);
            //回溯进入下一层
            backtrack(res, current, nums);
            //撤销当前选择的数字，进行另一种选择
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> data = new Solution().permute(new int[]{1, 2, 3});
        System.out.println(data);
    }
}
