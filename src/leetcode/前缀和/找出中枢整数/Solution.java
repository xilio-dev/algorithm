package leetcode.前缀和.找出中枢整数;

class Solution {
    public int pivotInteger(int n) {
        //等差数列求和
        int sum = n * (n + 1) / 2;
        //求sum的平方根
        int x = (int) Math.sqrt(sum);
        if (x * x == sum) {
            return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().pivotInteger(8));
    }
}
