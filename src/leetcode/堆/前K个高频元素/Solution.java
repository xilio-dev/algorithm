package leetcode.堆.前K个高频元素;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> frequency = new HashMap<>();
        //统计频率 {数字:频率}
        for (int num : nums) {
            frequency.merge(num, 1, Integer::sum);
        }
        //小顶堆
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            //限制堆的大小，只保留前k个元素 ，节省空间
            if (minHeap.size() > k) {
                //弹出对顶频率小的元素
                minHeap.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll()[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};
        Solution solution = new Solution();
        int[] res = solution.topKFrequent(nums, 2);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
