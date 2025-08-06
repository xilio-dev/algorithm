package leetcode.双指针.验证回文串;

class Solution {
    public boolean isPalindrome(String s) {
        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (i < j) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            //判断左边字符是否是字母或数字，不是则跳过
            if (!Character.isLetterOrDigit(c1)) {
                i++;//左指针右移
                continue;
            }
            //判断右边字符是否是字母或数字，不是则跳过
            if (!Character.isLetterOrDigit(c2)) {
                j--;//右指针左移
                continue;
            }
            //判断左右字符是否相等，不等则返回false，跳出循环
            if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            }
            i++;//左指针右移
            j--;//右指针左移

        }
        //只有一个字符、空字符、左右指针相遇时，返回true
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome("A"));
    }
}
