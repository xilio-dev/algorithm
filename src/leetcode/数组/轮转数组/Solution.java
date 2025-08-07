package leetcode.数组.轮转数组;

class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k == 0 || length == 1) {
            return;
        }
        //避免k大于数组长度，进行不必要的重复移动
        k = k % length;
        while (k > 0) {
            int t = nums[length - 1];
            for (int f = length - 1; f > 0; f--) {
                nums[f] = nums[f - 1];
            }
            nums[0] = t;
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution().rotate(nums, 3);
        for (int i : nums) {
            System.out.println(i);
        }

    }
}
