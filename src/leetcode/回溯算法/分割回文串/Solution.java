package leetcode.回溯算法.分割回文串;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> child = new ArrayList<>();
        backtrack(s, 0, child, res);
        return res;

    }

    private void backtrack(String s, int index, List<String> child, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(child));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                child.add(s.substring(index, i + 1));
                backtrack(s, i + 1, child, res);
                child.removeLast();
            }
        }
    }

    //判断是否是回文串 aba、abba start<end 对于奇数个，中间不用判断
    private boolean isPalindrome(String s, int index, int i) {
        for (int j = index; j < i; j++, i--) {
            if (s.charAt(j) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // List<List<String>> partition = new Solution().partition("aab");
        List<List<String>> partition = new Solution().partition("cbab");
        System.out.println(partition);
    }
}


