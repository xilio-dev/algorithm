package leetcode.栈.字符串解码;

import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        int currentNum = 0;
        StringBuilder currentStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                //数字可能是多位数，需要拼接起来，所以这里需要将当前数字乘10再加上新的数字
                currentNum = currentNum * 10 + (c - '0');
            } else if (c == '[') {
                //将当前数字和字符串压入栈中
                numStack.push(currentNum);
                strStack.push(currentStr);
                currentNum = 0;
                currentStr = new StringBuilder();

            } else if (c == ']') {
                //从字符串栈中弹出一个字符串
                StringBuilder topStr = strStack.pop();
                //从数字栈中弹出字符串重复次数
                Integer k = numStack.pop();
                //将弹出的字符串重复k次后，拼接在当前字符串后面
                currentStr = topStr.append(currentStr.toString().repeat(k));
            } else {
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(new Solution().decodeString(s));
    }
}
