package leetcode.子串.和为K的子数组;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int sum = nums[i];
            if (sum == k) {
                count++;
            }
            for (int j = i + 1; j < length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 0};
        int k = 0;
        System.out.println(new Solution().subarraySum(nums, k));
    }
}
