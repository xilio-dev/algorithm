package leetcode.数组.轮转数组;

class Solution2 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k == 0 || length == 1) {
            return;
        }
        //避免k大于数组长度，进行不必要的重复移动
        k = k % length;
        int[] temp = new int[k];

        for (int i = length - k, j = 0; i < length; i++, j++) {
            temp[j] = nums[i];
        }
        //nums向后移动k个位置
        for (int i = length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        System.arraycopy(temp, 0, nums, 0, k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Solution2().rotate(nums, 3);
        for (int i : nums) {
            System.out.println(i);
        }

    }
}
