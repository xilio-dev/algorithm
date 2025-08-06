package leetcode.堆.数组中的第K个最大元素;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        //第k大就是第nums.length-k小的数
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[k];
        }
        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        int pivotValue = nums[pivotIndex];
        int i = left, j = right;
        while (i <= j) {
            while (nums[i] < pivotValue) {
                i++;
            }
            while (nums[j] > pivotValue) {
                j--;
            }
            if (i <= j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        if (k <= j) {
            return quickSort(nums, left, j, k);
        } else {
            return quickSort(nums, i, right, k);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));

    }
}
