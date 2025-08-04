package leetcode.栈.每日温度;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    //该解法会超时，时间复杂度比较高
    public int[] dailyTemperatures(int[] temperatures) {
        int size = temperatures.length;
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            int value = temperatures[i];
            int day = 0;
            for (int j = i; j < size; j++) {
                if (temperatures[j] > value) {
                    day = j - i;
                    break;
                }
            }
            result[i] = day;
        }
        return result;
    }
    //单调栈实现
    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            int value = temperatures[i];
            while (!stack.isEmpty() && value > temperatures[stack.peek()]) {
                Integer startIndex = stack.pop();
                result[startIndex] = i - startIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(temperatures.length);
        System.out.println(Arrays.toString(new Solution().dailyTemperatures2(temperatures)));
    }
}
