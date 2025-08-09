package leetcode.数组.除自身以外数组的乘积;

//时间复杂度为O(n)  空间复杂度为O(n)
class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        //第一个数的左边啥也没有，所以为1，1*任何数都为他自己
        left[0] = 1;
        //从1开始，计算每一个数左边的乘积
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        //最后一个数的最右边啥也没有，所以为1，1*任何数都为他自己
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = nums[i + 1] * right[i + 1];
        }
        //计算结果，用当前的左边乘以当前的右边，因为左右在上面都已经计算出来了
        for (int i = 0; i < length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = new Solution2().productExceptSelf(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
