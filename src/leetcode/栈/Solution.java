package leetcode.栈;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        // 如果长度为奇数，直接返回false
        if (length % 2 != 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            // 如果是左括号，压入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 如果是右括号，判断栈顶元素是否匹配
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == ']' && top != '[') ||
                        (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        //如果栈中的元素不为空，说明有未匹配的括号，这点很重要
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        char[] arr = s.toCharArray();
        int top = 0;
        for (int i = 0; i < length; i++) {
            char c = arr[i];
            if (c == '(') {
                arr[top++] = ')';
            } else if (c == '[') {
                arr[top++] = ']';
            } else if (c == '{') {
                arr[top++] = '}';
            } else if (top == 0 || c != arr[--top]) {
                //top==0 说明s没有左括号，可能都是右括号
                return false;
            }
        }
        return top == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid2("(("));
        System.out.println(new Solution().isValid2("()[]{}"));
        System.out.println(new Solution().isValid2("(]"));
        System.out.println(new Solution().isValid2("([)]"));
        System.out.println(new Solution().isValid2("{[]}"));
    }
}
