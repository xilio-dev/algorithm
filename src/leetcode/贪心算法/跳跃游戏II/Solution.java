package leetcode.贪心算法.跳跃游戏II;

class Solution {
    public int jump(int[] nums) {
        int maxReach = 0;
        int currentEnd = 0;
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == currentEnd) {
                count++;
                currentEnd = maxReach;
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        Solution solution = new Solution();
        int jump = solution.jump(nums);
        System.out.println(jump);
    }
}
