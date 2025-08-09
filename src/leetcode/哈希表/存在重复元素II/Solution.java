package leetcode.哈希表.存在重复元素II;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (!map.containsKey(value)) {
                map.put(value, i);
            } else {
                if (Math.abs(i - map.get(value)) <= k) {
                    return true;
                }else {
                    map.put(value, i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(nums, 3));
    }
}
