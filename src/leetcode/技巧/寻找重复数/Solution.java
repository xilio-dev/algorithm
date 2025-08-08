package leetcode.技巧.寻找重复数;

class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        slow=0;
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        System.out.println(new Solution().findDuplicate(nums));
    }
}
