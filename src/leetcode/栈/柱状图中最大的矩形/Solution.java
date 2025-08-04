package leetcode.栈.柱状图中最大的矩形;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int[] heights = new int[] {2,1,5,6,2,3};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
}
