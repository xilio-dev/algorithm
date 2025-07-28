package leetcode.回溯算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    // 主方法，获取给定数组的所有全排列
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, current, result);
        return result;
    }

    // 回溯算法核心
    private static void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        // 如果当前排列长度等于输入数组长度，说明找到一个完整排列
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 尝试每个未使用的数字
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) { // 如果当前数字未被使用
                used[i] = true; // 标记为已使用
                current.add(nums[i]); // 添加到当前排列
                backtrack(nums, used, current, result); // 递归调用
                current.remove(current.size() - 1); // 回溯：移除最后添加的数字
                used[i] = false; // 回溯：取消使用标记
            }
        }
    }

    // 测试代码
    public static void main(String[] args) {
        // 测试用例1: [1,2,3]
        int[] nums1 = {1, 2, 3};
        System.out.println("Test Case 1: Input = " + Arrays.toString(nums1));
        List<List<Integer>> result1 = permute(nums1);
        System.out.println("Output: " + result1);
        System.out.println("Total permutations: " + result1.size());
        System.out.println();

        // 测试用例2: [0,1]
        int[] nums2 = {0, 1};
        System.out.println("Test Case 2: Input = " + Arrays.toString(nums2));
        List<List<Integer>> result2 = permute(nums2);
        System.out.println("Output: " + result2);
        System.out.println("Total permutations: " + result2.size());
        System.out.println();

        // 测试用例3: [1]
        int[] nums3 = {1};
        System.out.println("Test Case 3: Input = " + Arrays.toString(nums3));
        List<List<Integer>> result3 = permute(nums3);
        System.out.println("Output: " + result3);
        System.out.println("Total permutations: " + result3.size());
    }
}
