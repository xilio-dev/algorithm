package leetcode.数组.除自身以外数组的乘积;

//时间复杂度为O(n)  空间复杂度为O(1)
class Solution3 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        //第一个数的左边啥也没有，所以为1，1*任何数都为他自己
        res[0] = 1;
        //从1开始，计算每一个数左边的乘积
        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        //一开始最后一个元素的右边没有数字，所以为1，1*任何数都为他自己
        int r = 1;
        for (int i = length - 1; i >= 0; i--) {
            res[i] = res[i] * r;
            //计算下一个元素右边的乘积，因为res[i]已经保存了左边的乘积，所以这里只需要保存右边的乘积
            r *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] res = new Solution3().productExceptSelf(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
