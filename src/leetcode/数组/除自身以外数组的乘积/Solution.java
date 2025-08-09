package leetcode.数组.除自身以外数组的乘积;
//暴力求解 时间复杂度为O(n^2)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum=1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    sum = sum * nums[j];
                }
            }
            res[i]=sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = new Solution().productExceptSelf(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
