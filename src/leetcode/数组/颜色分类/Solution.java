package leetcode.数组.颜色分类;
//时间复杂度：O(n) 空间复杂度：O(1)
class Solution {
    public void sortColors(int[] nums) {
        int p=0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[p];
                nums[p]=temp;
                ++p;
            }
        }
        for (int i = p; i < nums.length; ++i) {
            if (nums[i]==1){
                int temp=nums[i];
                nums[i]=nums[p];
                nums[p]=temp;
                ++p;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        Solution solution = new Solution();
        solution.sortColors(nums);
        for (int i = 0; i < nums.length; ++i) {
            System.out.println(nums[i]);
        }
    }
}
