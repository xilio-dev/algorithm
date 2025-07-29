package leetcode.回溯算法.括号生成;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtrack(n, path, res, 0, 0);
        return res;
    }

    private void backtrack(int n, StringBuilder path, List<String> res, int open, int close) {
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }
        if (open < n) {
            backtrack(n, path.append("("), res, open + 1, close);
            path.deleteCharAt(path.length() - 1);
        }
        if (close < open) {
            backtrack(n, path.append(")"), res, open, close + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }


    public static void main(String[] args) {
        List<String> generateParenthesis = new Solution().generateParenthesis(3);
        System.out.println(generateParenthesis);
    }
}
